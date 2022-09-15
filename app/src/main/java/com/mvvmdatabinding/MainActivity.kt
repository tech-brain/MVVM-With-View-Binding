package com.mvvmdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvmdatabinding.adapters.HerosAdapter
import com.mvvmdatabinding.databinding.ActivityMainBinding
import com.mvvmdatabinding.networkCall.Repository
import com.mvvmdatabinding.networkCall.RetrofitService
import com.mvvmdatabinding.viewModels.MainViewModel
import com.mvvmdatabinding.viewModels.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    lateinit var adapter : HerosAdapter
   var  retrofitService : RetrofitService = RetrofitService.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  retrofitService = RetrofitService.getInstance()

            viewModel = ViewModelProvider(this, MyViewModelFactory(Repository(retrofitService))).get(MainViewModel::class.java)


            binding.rvHeros.adapter = adapter

            viewModel.heroesList.observe(this, Observer{
                adapter = HerosAdapter(it)
                Log.e(TAG, "HerosList $it")
            })

            viewModel.errorMessage.observe(this, Observer{
                Log.e(TAG, it)
            })

            viewModel.getAllHeros()

    }

}