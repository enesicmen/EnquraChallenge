package com.example.enqurachallenge.ui.bankbranchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.enqurachallenge.data.model.BankBranches
import com.example.enqurachallenge.databinding.RowBankBranchesBinding
import com.example.enqurachallenge.ui.common.RecyclerItemClickListener

class BankBranchesAdapter(
    private val mBankBranchList: MutableList<BankBranches>,
    private val onClicked: RecyclerItemClickListener
) : RecyclerView.Adapter<BankBranchesAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: RowBankBranchesBinding,
        private val onClicked: RecyclerItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(
                viewGroup: ViewGroup,
                onClicked: RecyclerItemClickListener,
            ): ViewHolder {
                val layoutInflater = LayoutInflater.from(viewGroup.context)
                val binding = RowBankBranchesBinding.inflate(layoutInflater, viewGroup, false)
                return ViewHolder(binding = binding, onClicked = onClicked)
            }
        }

        init {
            itemView.setOnClickListener { onClicked(adapterPosition) }
        }

        fun bind(item: BankBranches) {
            binding.apply {
                tvCity.text = item.city
                tvDistrict.text = item.district
                tvBankBranch.text = item.bankBranch
                tvAddressName.text = item.addressName
                tvAddress.text = item.address
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(viewGroup = parent, onClicked = onClicked)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(item = mBankBranchList[position])

    override fun getItemCount(): Int = mBankBranchList.size
}