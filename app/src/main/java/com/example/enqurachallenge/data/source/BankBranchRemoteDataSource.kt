package com.example.enqurachallenge.data.source

import com.example.enqurachallenge.data.DataCallback
import com.example.enqurachallenge.data.api.ApiService
import com.example.enqurachallenge.data.model.BankBranch
import com.example.enqurachallenge.di.qualifier.BankBranchDataSourceLocal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class BankBranchRemoteDataSource
@Inject constructor(
    private val apiService: ApiService,
    @BankBranchDataSourceLocal private val bankBranchLocalDataSource: BankBranchDataSource
): BankBranchDataSource {

    override fun getBankBranchList(callback: DataCallback<List<BankBranch>>) {

        val call: Call<List<BankBranch>> = apiService.getBankBranches()
        call.enqueue(object : Callback<List<BankBranch>> {
            override fun onResponse(
                call: Call<List<BankBranch>>,
                response: Response<List<BankBranch>>
            ) {
                if (response.isSuccessful) {
                    val bankBranchList = response.body()!!
                    bankBranchLocalDataSource.saveBankBranchList(bankBranchList)
                    callback.onSuccess(data = bankBranchList)
                } else {
                    callback.onError(message = response.message())
                }
            }

            override fun onFailure(call: Call<List<BankBranch>>, t: Throwable) {
                callback.onError(message = t.message ?: "")
            }
        })
    }

    override fun saveBankBranchList(bankBranchList: List<BankBranch>) {}
}