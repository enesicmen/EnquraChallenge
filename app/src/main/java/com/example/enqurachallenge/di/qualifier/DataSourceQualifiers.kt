package com.example.enqurachallenge.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BankBranchDataSourceLocal

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BankBranchDataSourceRemote
