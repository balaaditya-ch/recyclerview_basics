package com.nam.recyclerview_basics

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),ItemClickOnItemModel {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Sample static data
        val items = listOf(
            ItemModel("Item 1", "Description for item 1"),
            ItemModel("Item 2", "Description for item 2"),
            ItemModel("Item 3", "Description for item 3"),
            ItemModel("Item 4", "Description for item 4"),
            ItemModel("Item 5", "Description for item 5"),
            ItemModel("Item 6", "Description for item 6"),
            ItemModel("Item 7", "Description for item 7"),
            ItemModel("Item 8", "Description for item 8")
        )

        // Find RecyclerView and set it up with GridLayoutManager
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // GridLayoutManager with 2 columns
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ItemAdapter(items,this)
    }

    override fun onItemClick(item: ItemModel) {
        Toast.makeText(
            this,
            "Item clicked: ${item.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}

//Click Actions
// Expandable list