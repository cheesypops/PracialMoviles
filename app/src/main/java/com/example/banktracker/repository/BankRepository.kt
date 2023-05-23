package com.example.banktracker.repository

import com.example.banktracker.data.bankModel.BankModel

class BankRepository(private val banks: MutableList<BankModel>) {

    //funciones del repositorio

    //obtener los bancos
    fun getBanks() = banks

    //agregar un nuevo banco
    fun addBank(bank: BankModel) {
        banks.add(bank)
    }
}