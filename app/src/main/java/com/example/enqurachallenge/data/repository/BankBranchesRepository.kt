package com.example.enqurachallenge.data.repository

import com.example.enqurachallenge.data.DataCallback
import com.example.enqurachallenge.data.model.BankBranch
import com.example.enqurachallenge.data.source.BankBranchDataSource
import com.example.enqurachallenge.di.qualifier.BankBranchDataSourceLocal
import com.example.enqurachallenge.di.qualifier.BankBranchDataSourceRemote

import javax.inject.Inject

class BankBranchesRepository @Inject constructor(
    @BankBranchDataSourceLocal private var bankBranchLocalDataSource: BankBranchDataSource,
    @BankBranchDataSourceRemote private var bankBranchRemoteDataSource: BankBranchDataSource
) {
    fun getBankBranchList(callback: DataCallback<List<BankBranch>>) {
        bankBranchRemoteDataSource.getBankBranchList(callback)
    }
}