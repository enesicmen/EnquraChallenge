package com.example.enqurachallenge.ui.bankbranchlistdetail

import android.os.Bundle
import com.example.enqurachallenge.databinding.FragmentBankBranchDetailBinding
import com.example.enqurachallenge.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankBranchDetailFragment:
    BaseFragment<FragmentBankBranchDetailBinding, BankBranchDetailViewModel>(){


    override fun setViewModelClass() = BankBranchDetailViewModel::class.java

    override fun setViewBinding(): FragmentBankBranchDetailBinding =
        FragmentBankBranchDetailBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initLogic() {
        super.initLogic()
    }

}