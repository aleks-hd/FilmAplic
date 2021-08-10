package com.hfad.filmaplic


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.hfad.filmaplic.ui.main.FragmentMain


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            initFragment()
        }
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FragmentMain.newInstance())
            .commit()
    }

}