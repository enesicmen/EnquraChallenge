package com.example.enqurachallenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.enqurachallenge.data.model.BankBranch

@Database(
    entities = [BankBranch::class],
    version = 1,
    exportSchema = false
)
abstract class BankDatabase : RoomDatabase() {
    abstract fun bankDao(): BankDao
}