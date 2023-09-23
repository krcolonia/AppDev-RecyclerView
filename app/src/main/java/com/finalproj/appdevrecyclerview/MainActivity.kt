package com.finalproj.appdevrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.finalproj.appdevrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AgentAdapter

    private var agentList = ArrayList<String>()
    private var roleList = ArrayList<String>()
    private var imgList = ArrayList<Int>()
    private var itemList = ArrayList<Agent>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.agentRecycler

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        assignArrayLists()
        addDataToList()

        adapter = AgentAdapter(itemList)

        recyclerView.adapter = adapter
    }

    private fun assignArrayLists() {
        // Retrieves the String Array of the VALORANT Agent's Names and Roles and inserts into agentList and roleList
        agentList = getResources().getStringArray(R.array.valoAgents).toCollection(ArrayList())
        roleList = getResources().getStringArray(R.array.valoRoles).toCollection(ArrayList())

        // Retrieves the images from @drawable and inserts into imgList
        for(i in 1..22) imgList.add(getResources().getIdentifier("agent"+i, "drawable", this.packageName))
    }

    private fun addDataToList() {
        for(i in 0..21) itemList.add(Agent(agentList[i], roleList[i], imgList[i]))
    }
}