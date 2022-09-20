package com.example.enqurachallenge.ui.bankbranchlistdetail


import android.os.Bundle
import android.view.View
import com.example.enqurachallenge.data.model.BankBranch
import com.example.enqurachallenge.databinding.FragmentBankBranchDetailBinding
import com.example.enqurachallenge.ui.common.BaseFragment
import com.example.enqurachallenge.ui.common.ext.openMap
import com.example.enqurachallenge.util.AnalyticsUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankBranchDetailFragment:
    BaseFragment<FragmentBankBranchDetailBinding, BankBranchDetailViewModel>(){

    private lateinit var mBankBranch: BankBranch

    override fun setViewModelClass() = BankBranchDetailViewModel::class.java

    override fun setViewBinding(): FragmentBankBranchDetailBinding =
        FragmentBankBranchDetailBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        setData()
    }

    override fun readDataFromArguments() {
        super.readDataFromArguments()
        arguments?.let {
            val safeArgs = BankBranchDetailFragmentArgs.fromBundle(it)
            mBankBranch = safeArgs.bankBranchesModel
            AnalyticsUtils.logScreenView(mBankBranch.bankCode ?: "")
        }
    }

    private fun setData(){
        getViewBinding()?.apply {
            tvBankType.text = mBankBranch.bankType
            tvBankCode.text = mBankBranch.bankCode
            tvAddress.text = mBankBranch.address
            tvNearestAtm.text = mBankBranch.nearestAtm

            btnDirection.setOnClickListener(View.OnClickListener {
                context.openMap(mBankBranch.address)
            })
        }
    }
}