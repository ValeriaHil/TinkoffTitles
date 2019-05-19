package com.example.lenovo.tinkofftitles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.lenovo.tinkofftitles.titles.TitlesFragment
import com.example.lenovo.tinkofftitles.titles.content.ContentFragment

class MainActivity : AppCompatActivity(), TitlesFragment.TitleFragmentListener {
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(TitlesFragment.newInstance())
    }

    override fun onTitleItemClicked(id: Int) {
        currentFragment = ContentFragment.newInstance()
        currentFragment.arguments = Bundle()
        currentFragment.arguments?.putInt("ID", id)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, currentFragment)
            .addToBackStack("content")
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            if (currentFragment is ContentFragment) {
                supportFragmentManager.popBackStack()
                loadFragment(TitlesFragment.newInstance())
            }
        } else {
            super.onBackPressed()
        }
    }

    private fun loadFragment(fragment: Fragment) {
        currentFragment = fragment
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
