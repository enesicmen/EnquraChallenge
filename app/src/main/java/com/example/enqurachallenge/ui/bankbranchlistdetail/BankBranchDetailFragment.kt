package com.example.enqurachallenge.ui.bankbranchlistdetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.example.enqurachallenge.data.model.BankBranch
import com.example.enqurachallenge.databinding.FragmentBankBranchDetailBinding
import com.example.enqurachallenge.ui.common.BaseFragment
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
            tvAddress.text = mBankBranch.address
            tvNearestAtm.text = mBankBranch.nearestAtm

            btnDirection.setOnClickListener(View.OnClickListener {
                if(mBankBranch.address != null || mBankBranch.address == "") {
                    val url = "http://maps.google.co.in/maps?q=${mBankBranch.address}"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                }else {

                }
            })
        }
    }



}