package com.example.enqurachallenge.data.source

import com.example.enqurachallenge.data.DataCallback
import com.example.enqurachallenge.data.local.BankDao
import com.example.enqurachallenge.data.model.BankBranch
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class BankBranchLocalDataSource
@Inject constructor(
    private val bankDao: BankDao
): BankBranchDataSource {

    override fun getBankBranchList(callback: DataCallback<List<BankBranch>>){
        GlobalScope.launch {
            val branchList =  bankDao.getAllBranches()
            if(branchList.isNotEmpty()) {
                callback.onSuccess(branchList)
            } else {
                callback.onError("Data not found on database")
            }
        }
    }

    override fun saveBankBranchList(bankBranchList: List<BankBranch>) {
        GlobalScope.launch {
            bankDao.save(bankBranchList)
        }
    }
}