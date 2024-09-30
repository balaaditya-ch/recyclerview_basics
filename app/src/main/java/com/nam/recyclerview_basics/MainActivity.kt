package com.nam.recyclerview_basics
import android.os.Bundle
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableListAdapter: CustomExpandableListAdapter
    private lateinit var expandableListTitle: List<String>
    private lateinit var expandableListDetail: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expandableListView = findViewById(R.id.expandableListView)

        // Initialize the data for the expandable list view
        expandableListDetail = getData()

        // Parent group titles
        expandableListTitle = ArrayList(expandableListDetail.keys)

        // Set up the adapter
        expandableListAdapter = CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail)
        expandableListView.setAdapter(expandableListAdapter)
    }

    // Function to provide data for expandable list
    private fun getData(): HashMap<String, List<String>> {
        val listData = HashMap<String, List<String>>()

        val programmingLanguages = listOf("Java", "Kotlin", "Python", "Swift")
        val databases = listOf("SQLite", "Firebase", "Realm")
        val frameworks = listOf("Spring", "React Native", "Flutter")

        listData["Programming Languages"] = programmingLanguages
        listData["Databases"] = databases
        listData["Frameworks"] = frameworks

        return listData
    }
}
