package com.mvvmdatabinding.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import com.mvvmdatabinding.networkCall.Repository


class MyViewModelFactory constructor(val repository: Repository):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}