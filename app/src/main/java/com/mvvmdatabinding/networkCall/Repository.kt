package com.mvvmdatabinding.networkCall


class Repository constructor(private val retrofitService : RetrofitService){
    fun getAllHeros() = retrofitService.getAllHeros()
}