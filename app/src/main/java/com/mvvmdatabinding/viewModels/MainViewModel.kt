package com.mvvmdatabinding.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmdatabinding.model.Heros
import com.mvvmdatabinding.networkCall.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository : Repository):ViewModel() {

    val heroesList = MutableLiveData<ArrayList<Heros.HerosItem>>()

    val errorMessage = MutableLiveData<String>()

    fun getAllHeros(){
        val response = repository.getAllHeros()
        response.enqueue(object : Callback<Heros>{
            override fun onResponse(call: Call<Heros>, response: Response<Heros>) {
                heroesList.postValue(response.body())
            }

            override fun onFailure(call: Call<Heros>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}