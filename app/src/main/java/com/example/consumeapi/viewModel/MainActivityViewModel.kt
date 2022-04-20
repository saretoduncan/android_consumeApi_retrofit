package com.example.consumeapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumeapi.models.User

import com.example.consumeapi.models.UserList
import com.example.consumeapi.network.RetroInstance
import com.example.consumeapi.network.RetroService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivityViewModel:ViewModel() {
  lateinit var recylerListData: MutableLiveData<UserList>
  init {
      recylerListData= MutableLiveData()
  }
    fun getUserListObserverable():MutableLiveData<UserList>{
        return recylerListData
    }
    fun getUserList(){
        val retroInstance= RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getUserList()
        call.enqueue(object : retrofit2.Callback<UserList>{
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
              if(response.isSuccessful){
                  recylerListData.postValue(response.body())
              }else{
                  print("not a success")
              }

            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                recylerListData.postValue(null)
                println("::::error:::at $t")
            }


        })
    }
    fun searchUserList(name:String){
        val retroInstance= RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.searchUsers(name)
        call.enqueue(object : retrofit2.Callback<UserList>{
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful){
                    recylerListData.postValue(response.body())
                }else{
                    print("not a success")
                }

            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                recylerListData.postValue(null)
                println("::::error:::at $t")
            }


        })
    }
}


