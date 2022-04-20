package com.example.consumeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.consumeapi.adapter.RecylerviewAdapter
import com.example.consumeapi.models.User
import com.example.consumeapi.models.UserList
import com.example.consumeapi.ui.CreateNewUser
import com.example.consumeapi.viewModel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter:RecylerviewAdapter
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val createBtn=findViewById<Button>(R.id.btncreate)
        createBtn.setOnClickListener {
            startActivity(Intent(this,CreateNewUser::class.java))
        }
        initRecyclerView()
        initViewModel()
         searchUser()
    }

    private fun searchUser() {
      val searchBtn= findViewById<Button>(R.id.searchbtn)
        val searchText : EditText= findViewById(R.id.searcvheditText)
        searchBtn.setOnClickListener {
         if(!TextUtils.isEmpty(searchBtn.text.toString())){
             viewModel.searchUserList(searchText.text.toString())
         }else{
             viewModel.getUserList()
         }
        }

    }


    private fun initRecyclerView(){
        val recycler_view:RecyclerView=findViewById(R.id.recycler_view)
        recycler_view.apply{
            val layoutManager= LinearLayoutManager(this@MainActivity)
            recycler_view.layoutManager= layoutManager
            val decoration= DividerItemDecoration(this@MainActivity,LinearLayoutManager.HORIZONTAL)
           addItemDecoration(decoration)
            recyclerViewAdapter= RecylerviewAdapter()
            adapter= recyclerViewAdapter
        }
    }
    private fun initViewModel() {
       viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getUserListObserverable().observe(this, Observer<UserList> {
            if (it==null){
                Toast.makeText(this@MainActivity, "no results found...", Toast.LENGTH_LONG).show()

            }else{
                recyclerViewAdapter.items= it.toMutableList() as ArrayList<User>
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getUserList()
    }


}