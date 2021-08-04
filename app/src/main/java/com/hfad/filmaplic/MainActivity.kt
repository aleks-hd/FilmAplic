package com.hfad.filmaplic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.filmaplic.databinding.MainActivityBinding
import com.hfad.filmaplic.ui.main.DetailFragment
import com.hfad.filmaplic.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.main_activity)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            initFragment()
            initFragmentTwo()

        }


    }

    private fun initFragmentTwo() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerMain, MainFragment.newInstance())
            .commit()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerDetail, DetailFragment.newInstance())
            .commit()
    }
}