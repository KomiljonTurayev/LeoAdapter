package com.example.leoadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.leoadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            actionRecycler.setOnClickListener {
                startActivity(Intent(applicationContext, RecyclerActivity::class.java))
            }

            actionViewPager.setOnClickListener {
                startActivity(Intent(applicationContext, ViewPagerActivity::class.java))
            }
        }
    }
}