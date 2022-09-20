package com.example.enqurachallenge.ui.bankbranchlist

import androidx.lifecycle.ViewModel
import com.example.enqurachallenge.data.DataCallback
import com.example.enqurachallenge.data.Resource
import com.example.enqurachallenge.data.model.BankBranch
import com.example.enqurachallenge.data.repository.BankBranchesRepository
import com.example.enqurachallenge.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BankBranchesViewModel @Inject constructor(
    private val bankBranchesRepository: BankBranchesRepository
) : ViewModel(){

    var bankBranchList: SingleLiveEvent<Resource<List<BankBranch>>> = SingleLiveEvent()

    fun getBankBranches() {
        bankBranchList.value = Resource.Loading()
        bankBranchesRepository.getBankBranchList(object : DataCallback<List<BankBranch>> {
            override fun onSuccess(data: List<BankBranch>) {
                bankBranchList.value = Resource.Success(data)
            }
            override fun onError(message: String) {
                bankBranchList.value = Resource.Error(message)
            }

        })
    }
}