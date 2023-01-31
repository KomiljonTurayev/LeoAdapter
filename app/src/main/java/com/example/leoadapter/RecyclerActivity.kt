package com.example.leoadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import com.example.leoadapter.data.Person
import com.example.leoadapter.data.colors
import com.example.leoadapter.databinding.ActivityRecyclerBinding
import com.example.leoadapter.databinding.RecyclerItemBinding
import me.komiljon.leo.LeoAdapter
import me.komiljon.leo.recycler.setupAdapter


class RecyclerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val leoAdapter: LeoAdapter<Person> = binding.recycler.setupAdapter(
            getViewBinding = RecyclerItemBinding::inflate,
            diffUtil = DIFF_UTIL,
        ) { itemBinding, index, item ->
            itemBinding.textView.text = "${item.name} $index"
            itemBinding.textView.setBackgroundResource(colors[index % colors.size])

            itemBinding.root.setOnClickListener {
                Toast.makeText(itemBinding.root.context, "${item.name} - ${item.id}", Toast.LENGTH_SHORT).show()
            }
        }

        val data = (1..1000).map {
            Person(it, it, "Adam")
        }

        leoAdapter.setList(data)
        binding.fab.setOnClickListener {
            leoAdapter.setList(data.shuffled())
        }

    }
}

val DIFF_UTIL: DiffUtil.ItemCallback<Person> = object : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean = oldItem == newItem

}