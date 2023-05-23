package com.example.banktracker.ui.bank.bankList.recycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banktracker.data.bankModel.BankModel
import com.example.banktracker.databinding.BankItemBinding

class BankAdapter(private val clickListener: (BankModel) -> Unit): RecyclerView.Adapter<BankHolder>(){
    private var banks = ArrayList<BankModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankHolder {
        val binding = BankItemBinding.inflate(LayoutInflater.from(parent.context))
        return BankHolder(binding)
    }

    override fun onBindViewHolder(holder: BankHolder, position: Int) {
        holder.bind(banks[position], clickListener)
    }

    override fun getItemCount(): Int = banks.size

    //funcion para actualizar
    fun setData(BanksList: List<BankModel>){
        banks.clear()
        banks.addAll(BanksList)
    }
}