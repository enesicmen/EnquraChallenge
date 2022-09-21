package com.example.enqurachallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.enqurachallenge.data.model.BankBranch

@Dao
interface BankDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(bankBranchList: List<BankBranch>)

    @Query("SELECT * FROM BankBranch")
    fun getAllBranches(): List<BankBranch>
}