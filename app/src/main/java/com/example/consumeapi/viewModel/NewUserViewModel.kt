package com.example.consumeapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.consumeapi.models.User

import com.example.consumeapi.models.UserResponse
import com.example.consumeapi.network.RetroInstance
import com.example.consumeapi.network.RetroService
import retrofit2.Call
import retrofit2.Response

class NewUserViewModel : ViewModel() {
    lateinit var createNewUserLiveData: MutableLiveData<UserResponse>
    init {
        createNewUserLiveData= MutableLiveData()
    }
    fun getCreateNewUserObserverable():MutableLiveData<UserResponse>{
        return createNewUserLiveData
    }
     fun createNewUser(user:User){
         val retroInstance= RetroInstance.getRetroInstance().create(RetroService::class.java)
         val call = retroInstance.createUser(user)
         call.enqueue(object : retrofit2.Callback<UserResponse>{
             override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                 if(response.isSuccessful){
                     createNewUserLiveData.postValue(response.body())
                 }else{
                     print("not a success")
                 }
             }

             override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                 createNewUserLiveData.postValue(null)
                 println("::::error:::at $t")
             }


         })
     }
}