package com.example.enqurachallenge.data.api

import com.example.enqurachallenge.data.model.BankBranches
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("bankdata")
    fun getBankBranches(): Call<List<BankBranches>>
}