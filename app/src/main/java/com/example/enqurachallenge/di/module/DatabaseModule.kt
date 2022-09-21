package com.example.enqurachallenge.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.enqurachallenge.data.Constants
import com.example.enqurachallenge.data.local.BankDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideBankDao(bankDatabase: BankDatabase) = bankDatabase.bankDao()

    @Provides
    fun provideBankDatabase(bankDatabaseBuilder: RoomDatabase.Builder<BankDatabase?>) =
        bankDatabaseBuilder
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideBankDatabaseBuilder(@ApplicationContext context: Context?) =
        Room.databaseBuilder(
            context!!,
            BankDatabase::class.java,
            Constants.Database.NAME
        )
}