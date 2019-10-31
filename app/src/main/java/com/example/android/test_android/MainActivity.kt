package com.example.android.test_android

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerFragmentStateAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        fabPlus.setOnClickListener {
            val itemNo = adapter.inc()
            if(itemNo > 1){
                fabMinus.visibility = View.VISIBLE
            }
            viewPager.setCurrentItem(itemNo.minus(1), true)
        }

        fabMinus.setOnClickListener {
            if(adapter.dec() == 1){
                it.visibility = View.GONE
            }
        }
    }

}
