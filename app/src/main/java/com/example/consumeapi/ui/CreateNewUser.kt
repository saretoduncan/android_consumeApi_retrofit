package com.example.consumeapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.consumeapi.R
import com.example.consumeapi.models.User
import com.example.consumeapi.models.UserResponse
import com.example.consumeapi.viewModel.NewUserViewModel

class CreateNewUser : AppCompatActivity() {
    lateinit var viewModel:NewUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)
        val createUser: Button =findViewById(R.id.submitBtn)
        createUserObservable()
        initViewModel()
        createUser.setOnClickListener {
            createNewUser()
        }


    }

    private fun createNewUser() {
        val user:User=  User(1,findViewById<EditText>(R.id.edemail).text.toString(),"male",findViewById<EditText>(R.id.edname).text.toString(),"active")
        viewModel.createNewUser(user);
    }

    private fun createUserObservable() {
        viewModel= ViewModelProvider(this).get(NewUserViewModel::class.java)

    }

    private fun initViewModel() {
        viewModel.getCreateNewUserObserverable().observe(this, Observer<UserResponse> {
            if(it==null){
                Toast.makeText(this,"failed to create new user...",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "successfully created..new user", Toast.LENGTH_LONG).show()
            }
        })
    }
}


