package com.example.lenovo.tinkofftitles.titles.content

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lenovo.tinkofftitles.Model.Content
import com.example.lenovo.tinkofftitles.R
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment

class ContentFragment : MvpLceFragment<SwipeRefreshLayout, Content, ContentView, ContentPresenter>(),
    ContentView, SwipeRefreshLayout.OnRefreshListener {

    companion object {
        fun newInstance(): ContentFragment {
            return ContentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val refresh = view.findViewById<SwipeRefreshLayout>(R.id.contentView)
        refresh.setOnRefreshListener(this)

        loadData(false)
    }

    override fun loadData(pullToRefresh: Boolean) {
        showLoading(pullToRefresh)
        presenter.loadContent(arguments?.getInt("ID")!!)
    }

    override fun createPresenter(): ContentPresenter {
        return ContentPresenter()
    }

    override fun setData(data: Content?) {
        showContent()
        val content = view?.findViewById<TextView>(R.id.content)
        content?.text = data?.text
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String {
        return e?.message ?: ""
    }

    override fun onRefresh() {
        loadData(true)
    }
}