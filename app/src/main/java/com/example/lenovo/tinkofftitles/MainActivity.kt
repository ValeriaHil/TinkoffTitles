package com.example.lenovo.tinkofftitles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lenovo.tinkofftitles.titles.TitlesFragment

class MainActivity : AppCompatActivity(), TitlesFragment.TitleFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(TitlesFragment.newInstance())
    }

    override fun onTitleItemClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun loadFragment(fragment: TitlesFragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
