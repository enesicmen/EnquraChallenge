package com.example.enqurachallenge.di.module

import com.example.enqurachallenge.data.source.BankBranchDataSource
import com.example.enqurachallenge.data.source.BankBranchLocalDataSource
import com.example.enqurachallenge.data.source.BankBranchRemoteDataSource
import com.example.enqurachallenge.di.qualifier.BankBranchDataSourceLocal
import com.example.enqurachallenge.di.qualifier.BankBranchDataSourceRemote
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @BankBranchDataSourceLocal
    abstract fun bindBankBranchLocalDataSource(bankBranchLocalDataSource: BankBranchLocalDataSource): BankBranchDataSource

    @Binds
    @BankBranchDataSourceRemote
    abstract fun bindBankBranchRemoteDataSource(bankBranchRemoteDataSource: BankBranchRemoteDataSource): BankBranchDataSource
}