package com.finalproj.appdevrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.finalproj.appdevrecyclerview.databinding.AgentItemBinding

class AgentAdapter(private var agentList: List<Agent>) : RecyclerView.Adapter<AgentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): AgentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AgentItemBinding.inflate(inflater, parent, false)

        return AgentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val mainContext = holder.itemView.context
        holder.bind(agentList[position])

        with(holder) {
            val name = agentList[position].name + " - " + agentList[position].role

            agentBinding.agentBtn.setOnClickListener {
                Toast.makeText(mainContext, name, Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return agentList.size
    }

}