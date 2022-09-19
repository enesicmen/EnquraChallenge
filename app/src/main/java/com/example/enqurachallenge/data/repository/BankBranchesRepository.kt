package com.example.enqurachallenge.data.repository

import com.example.enqurachallenge.data.NetworkCallback
import com.example.enqurachallenge.data.api.ApiService
import com.example.enqurachallenge.data.model.BankBranches
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class BankBranchesRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getBankBranches(callback: NetworkCallback<List<BankBranches>>) {

        val call: Call<List<BankBranches>> = apiService.getBankBranches()
        call.enqueue(object : Callback<List<BankBranches>> {
            override fun onResponse(
                call: Call<List<BankBranches>>,
                response: Response<List<BankBranches>>
            ) {
                if (response.isSuccessful) {
                    val bankBranchesApiResponse = response.body()!!
                    callback.onSuccess(data = bankBranchesApiResponse)
                } else {
                    callback.onError(message = response.message())
                }
            }

            override fun onFailure(call: Call<List<BankBranches>>, t: Throwable) {
                callback.onError(message = t.message ?: "")
            }
        })
    }
}