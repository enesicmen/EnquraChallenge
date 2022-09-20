package com.example.enqurachallenge.ui.bankbranchlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.example.enqurachallenge.R
import com.example.enqurachallenge.data.Resource
import com.example.enqurachallenge.data.model.BankBranch
import com.example.enqurachallenge.databinding.FragmentBankBranchesBinding
import com.example.enqurachallenge.ui.common.BaseFragment
import com.example.enqurachallenge.ui.common.ext.isConnected
import com.example.enqurachallenge.ui.common.ext.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankBranchesFragment:
    BaseFragment<FragmentBankBranchesBinding, BankBranchesViewModel>(){

    lateinit var mBankBranchesAdapter: BankBranchesAdapter

    private var mBankBranchList: MutableList<BankBranch> = mutableListOf()

    private var mFilteredList: MutableList<BankBranch> = mutableListOf()

    override fun setViewModelClass() = BankBranchesViewModel::class.java

    override fun setViewBinding(): FragmentBankBranchesBinding =
        FragmentBankBranchesBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        initBankBranchesAdapter()
        initSearchBar()
        onClickRetryConnection()
        getViewModel()?.bankBranchList?.observe(this){
            when (it) {
                is Resource.Loading -> getViewBinding()?.progressBar?.setVisibility(isVisible = true)

                is Resource.Success -> {
                    getViewBinding()?.progressBar?.setVisibility(isVisible = false)
                    setBankBranchList(it.data!!)
                }
                is Resource.Error -> {
                    getViewBinding()?.progressBar?.setVisibility(isVisible = false)
                    showErrorViews(R.drawable.no_network_icon)
                }
            }
        }
    }

    override fun initLogic() {
        super.initLogic()
        getBankBranches()
        //getViewModel()?.getBankBranches()
    }

    fun getBankBranches() {
        if(context?.isConnected == true) {
            getViewModel()?.getBankBranches()
        } else {
            showErrorViews(R.drawable.no_network_icon)
        }
    }

    private fun onClickRetryConnection() {
        getViewBinding()?.retryButton?.setOnClickListener(View.OnClickListener {
            getBankBranches()
        })
    }

    fun showErrorViews(imageResId: Int) {
        getViewBinding()?.bankBranchGroup?.setVisibility(isVisible = false)
        getViewBinding()?.errorGroup?.setVisibility(isVisible = true)
        getViewBinding()?.errorImageView?.setImageResource(imageResId)
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

    private fun setBankBranchList(bankBranches: List<BankBranch>) {
        mBankBranchList.clear()
        mBankBranchList.addAll(bankBranches)
        mFilteredList.addAll(mBankBranchList)
        mBankBranchesAdapter.notifyDataSetChanged()
        if(bankBranches.isNotEmpty()){
            getViewBinding()?.bankBranchGroup?.setVisibility(isVisible = true)
            getViewBinding()?.errorGroup?.setVisibility(isVisible = false)
        } else {
            showErrorViews(R.drawable.ic_no_data)
        }
    }

    private fun filterList(text: String) {
        mFilteredList.clear()
        mFilteredList.addAll(mBankBranchList.filter { it.city?.contains(text) ?: false })
        mBankBranchesAdapter.notifyDataSetChanged()
    }

    private fun initSearchBar() {
        getViewBinding()?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query.toString())
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText.toString())
                return false
            }
        })
    }
}