package com.finalproj.appdevrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.finalproj.appdevrecyclerview.databinding.AgentItemBinding

class AgentViewHolder(val agentBinding: AgentItemBinding) : RecyclerView.ViewHolder(agentBinding.root) {
    fun bind(agent: Agent) {
        agentBinding.agentName.text = agent.name.uppercase()
        agentBinding.agentRole.text = agent.role
        agentBinding.agentImg.setImageResource(agent.img)
    }
}