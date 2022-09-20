package com.example.enqurachallenge.data.source

import com.example.enqurachallenge.data.DataCallback
import com.example.enqurachallenge.data.model.BankBranch

interface BankBranchDataSource {
    fun getBankBranchList(callback:DataCallback<List<BankBranch>>)
}