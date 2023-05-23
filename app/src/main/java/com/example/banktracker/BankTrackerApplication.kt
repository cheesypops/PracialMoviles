package com.example.banktracker

import android.app.Application
import com.example.banktracker.data.banks
import com.example.banktracker.repository.BankRepository

class BankTrackerApplication: Application() {

    //permitir que el repositorio obtenga una variable de bancos
    val bankRepository: BankRepository by lazy {
        BankRepository(banks)
    }
}