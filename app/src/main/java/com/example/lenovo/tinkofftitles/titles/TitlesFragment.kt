package com.example.lenovo.tinkofftitles.titles

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lenovo.tinkofftitles.Model.Title
import com.example.lenovo.tinkofftitles.R
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment

class TitlesFragment : MvpLceFragment<SwipeRefreshLayout, List<Title>, TitlesView, TitlesPresenter>(),
    TitlesView, SwipeRefreshLayout.OnRefreshListener {

    interface TitleFragmentListener {
        fun onTitleItemClicked(id: Int)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private var listener: TitleFragmentListener? = null

    companion object {
        fun newInstance(): TitlesFragment {
            return TitlesFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is TitleFragmentListener) {
            listener = context
        } else {
            throw ClassCastException("$context is not TitleFragmentListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lce, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler)
        adapter = Adapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        val refresh = view.findViewById<SwipeRefreshLayout>(R.id.contentView)
        refresh.setOnRefreshListener(this)

        loadData(false)
    }

    override fun loadData(pullToRefresh: Boolean) {
        showLoading(pullToRefresh)
        presenter.loadTitles()
    }

    override fun createPresenter(): TitlesPresenter {
        return TitlesPresenter()
    }

    override fun setData(data: List<Title>?) {
        updateData(data)
        showContent()
        contentView.isRefreshing = false
    }

    private fun updateData(data: List<Title>?) {
        if (data != null) {
            adapter.updateData(data)
        }
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String {
        return e?.message ?: ""
    }

    override fun onTitleItemClicked(id: Int) {
        listener?.onTitleItemClicked(id)
    }

    override fun onRefresh() {
        loadData(true)
    }

    inner class Adapter(private var titles: List<Title>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, index: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.title_info, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return titles.size
        }

        override fun onBindViewHolder(holder: ViewHolder, index: Int) {
            holder.bind(titles[index])
        }

        fun updateData(data: List<Title>) {
            titles = data
            notifyDataSetChanged()
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val title: TextView = view.findViewById(R.id.title_info)
            private var id = -1

            init {
                view.setOnClickListener {
                    presenter.onItemClicked(id)
                }
            }

            fun bind(title: Title) {
                this.title.text = title.text
                id = title.id
            }
        }
    }
}