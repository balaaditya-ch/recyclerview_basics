package com.nam.recyclerview_basics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Sample static data
        val items = listOf(
            ItemModel("Item 1", "Description for item 1"),
            ItemModel("Item 2", "Description for item 2"),
            ItemModel("Item 3", "Description for item 3"),
            ItemModel("Item 4", "Description for item 4")
        )

        // Find RecyclerView and set it up
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        recyclerView.adapter = ItemAdapter(items)
    }
}