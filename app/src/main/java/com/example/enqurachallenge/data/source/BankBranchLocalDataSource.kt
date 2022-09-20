package com.example.enqurachallenge.data.source

import com.example.enqurachallenge.data.DataCallback
import com.example.enqurachallenge.data.model.BankBranch
import javax.inject.Inject

class BankBranchLocalDataSource
@Inject constructor(
): BankBranchDataSource {

    override fun getBankBranchList(callback: DataCallback<List<BankBranch>>){
        //TODO: will be implemented
    }
}