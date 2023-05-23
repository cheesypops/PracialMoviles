package com.example.banktracker.ui.bank.bankList.recycleView

import androidx.recyclerview.widget.RecyclerView
import com.example.banktracker.data.bankModel.BankModel
import com.example.banktracker.databinding.BankItemBinding

class BankHolder(private val binding: BankItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(bank: BankModel, clickListener: (BankModel) -> Unit){
        binding.bankName.text = bank.name
        binding.bankCountry.text = bank.country

        binding.card.setOnClickListener { clickListener(bank) }

    }
}