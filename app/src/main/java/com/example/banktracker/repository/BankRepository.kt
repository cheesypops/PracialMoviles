package com.example.banktracker.repository

import com.example.banktracker.data.bankModel.BankModel

class BankRepository(private val banks: MutableList<BankModel>) {

    //funciones del repositorio
    fun getBanks() = banks

    fun addBank(bank: BankModel) {
        banks.add(bank)
    }
}