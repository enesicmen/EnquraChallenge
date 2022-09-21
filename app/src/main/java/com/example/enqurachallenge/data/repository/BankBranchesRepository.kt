package com.example.enqurachallenge.data.repository

import android.content.Context
import com.example.enqurachallenge.data.DataCallback
import com.example.enqurachallenge.data.model.BankBranch
import com.example.enqurachallenge.data.source.BankBranchDataSource
import com.example.enqurachallenge.di.qualifier.BankBranchDataSourceLocal
import com.example.enqurachallenge.di.qualifier.BankBranchDataSourceRemote
import com.example.enqurachallenge.ui.common.ext.isConnected
import dagger.hilt.android.qualifiers.ApplicationContext

import javax.inject.Inject

class BankBranchesRepository @Inject constructor(
    @ApplicationContext private var context: Context,
    @BankBranchDataSourceLocal private var bankBranchLocalDataSource: BankBranchDataSource,
    @BankBranchDataSourceRemote private var bankBranchRemoteDataSource: BankBranchDataSource
) {
    fun getBankBranchList(callback: DataCallback<List<BankBranch>>) {
        if(context.isConnected){
            bankBranchRemoteDataSource.getBankBranchList(callback)
        }else {
            bankBranchLocalDataSource.getBankBranchList(callback)
        }
    }
}