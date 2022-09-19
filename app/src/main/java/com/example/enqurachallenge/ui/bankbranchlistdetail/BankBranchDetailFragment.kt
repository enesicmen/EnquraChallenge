package com.example.enqurachallenge.ui.bankbranchlistdetail

import android.os.Bundle
import com.example.enqurachallenge.data.model.BankBranches
import com.example.enqurachallenge.databinding.FragmentBankBranchDetailBinding
import com.example.enqurachallenge.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankBranchDetailFragment:
    BaseFragment<FragmentBankBranchDetailBinding, BankBranchDetailViewModel>(){

    private lateinit var mBankBranch: BankBranches

    override fun setViewModelClass() = BankBranchDetailViewModel::class.java

    override fun setViewBinding(): FragmentBankBranchDetailBinding =
        FragmentBankBranchDetailBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        setData()
    }

    override fun initLogic() {
        super.initLogic()
    }

    override fun readDataFromArguments() {
        super.readDataFromArguments()
        arguments?.let {
            val safeArgs = BankBranchDetailFragmentArgs.fromBundle(it)
            mBankBranch = safeArgs.bankBranchesModel
        }
    }

    private fun setData(){
        getViewBinding()?.apply {
            tvBankType.text = mBankBranch.bankType
            tvBankCode.text = mBankBranch.bankCode
            tvBankBranch.text = mBankBranch.bankBranch
            tvPostCode.text = mBankBranch.postCode
            tvOnOffLine.text = mBankBranch.onOffLine
            tvOnOffSite.text = mBankBranch.onOffSite
            tvRegionalCoordinator.text = mBankBranch.regionalCoordinator
            tvNearestAtm.text = mBankBranch.nearestAtm
        }
    }

}