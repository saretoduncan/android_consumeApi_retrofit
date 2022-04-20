package com.example.consumeapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.consumeapi.R
import com.example.consumeapi.adapter.RecylerviewAdapter.*

import com.example.consumeapi.models.User
import com.example.consumeapi.models.UserList

class RecylerviewAdapter: RecyclerView.Adapter<MyViewHolder>() {
    var items= ArrayList<User>()
    fun setUpdateData(items:ArrayList<User>){
        this.items= items
    }
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
    val name : TextView= view.findViewById(R.id.name)
        val email: TextView = view.findViewById(R.id.email)
        val status: TextView= view.findViewById(R.id.status)
        fun bind(data: User){
       name.text=data.name
            email.text=data.gender
            status.text= data.status
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recylayout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}