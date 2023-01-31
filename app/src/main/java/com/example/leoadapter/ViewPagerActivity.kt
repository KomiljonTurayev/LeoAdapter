package com.example.leoadapter

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.leoadapter.data.Person
import com.example.leoadapter.data.colors
import com.example.leoadapter.databinding.ActivityViewPagerBinding
import com.example.leoadapter.databinding.PagePersonBinding
import me.komiljon.leo.LeoAdapter
import me.komiljon.leo.viewpager.setupAdapter

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val leoAdapter: LeoAdapter<Person> = binding.viewPager.setupAdapter(
            PagePersonBinding::inflate
        ) { itemBinding, index, item ->

            itemBinding.personName.text = "${item.name}  $index"
            itemBinding.personAge.text = "Age = ${item.age}"
            itemBinding.root.setBackgroundResource(colors[index % colors.size])
            itemBinding.root.setOnClickListener {
                Toast.makeText(itemBinding.root.context, "${item.name}", Toast.LENGTH_SHORT).show()
            }
        }

        val data = (1..1000).map {
            Person(it, it, "Adam")
        }

        leoAdapter.setList(data.shuffled())
        binding.fab.setOnClickListener { leoAdapter.setList(data.shuffled()) }
    }
}