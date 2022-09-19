package com.example.enqurachallenge.ui.bankbranchlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.navigation.fragment.findNavController
import com.example.enqurachallenge.data.Resource
import com.example.enqurachallenge.data.model.BankBranches
import com.example.enqurachallenge.databinding.FragmentBankBranchesBinding
import com.example.enqurachallenge.ui.common.BaseFragment
import com.example.enqurachallenge.ui.common.ext.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankBranchesFragment:
    BaseFragment<FragmentBankBranchesBinding, BankBranchesViewModel>(){

    lateinit var mBankBranchesAdapter: BankBranchesAdapter

    private var mBankBranchList: MutableList<BankBranches> = mutableListOf()

    private var mFilteredList: MutableList<BankBranches> = mutableListOf()

    override fun setViewModelClass() = BankBranchesViewModel::class.java

    override fun setViewBinding(): FragmentBankBranchesBinding =
        FragmentBankBranchesBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        initBankBranchesAdapter()
        onClickSearchBank()
        getViewModel()?.bankBranchList?.observe(this){
            when (it) {
                is Resource.Loading -> getViewBinding()?.progressBar?.setVisibility(isVisible = true)

                is Resource.Success -> {
                    getViewBinding()?.progressBar?.setVisibility(isVisible = false)
                    setBankBranchList(it.data!!)

                    getViewBinding()?.llSearchView.setVisibility(isVisible = true)
                }
                is Resource.Error -> getViewBinding()?.progressBar?.setVisibility(isVisible = false)
            }
        }

    }

    override fun initLogic() {
        super.initLogic()
        getViewModel()!!.getBankBranches()
    }

    private fun initBankBranchesAdapter() {
        mBankBranchesAdapter = BankBranchesAdapter(
            mBankBranchList = mFilteredList,
            onClicked = {
                val actionDetail = BankBranchesFragmentDirections.actionBankBranchesFragmentToBankBranchDetail(bankBranchesModel = mFilteredList[it])
                findNavController().navigate(actionDetail)
            }
        )
        getViewBinding()?.rvBankBranches?.adapter = mBankBranchesAdapter
    }

    private fun setBankBranchList(bankBranches: List<BankBranches>) {
        mBankBranchList.clear()
        mBankBranchList.addAll(bankBranches)
        mFilteredList.addAll(mBankBranchList)
        mBankBranchesAdapter.notifyDataSetChanged()
    }

    private fun filterList(text: String) {
        mFilteredList.clear()
        mFilteredList.addAll(mBankBranchList.filter { it.city.contains(text) })
        mBankBranchesAdapter.notifyDataSetChanged()
    }

    private fun onClickSearchBank() {
        getViewBinding()?.searchView?.etSearch?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                filterList(p0.toString())
            }

        })
    }
}