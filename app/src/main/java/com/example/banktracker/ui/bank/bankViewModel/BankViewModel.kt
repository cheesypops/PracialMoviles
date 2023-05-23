package com.example.banktracker.ui.bank.bankViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.banktracker.BankTrackerApplication
import com.example.banktracker.data.bankModel.BankModel
import com.example.banktracker.repository.BankRepository

class BankViewModel(private val repository: BankRepository): ViewModel() {

    //datos para la creacion de un banco
    val name = MutableLiveData("")
    val country = MutableLiveData("")

    //variable para manejo de estados
    val status = MutableLiveData("")

    //funciones obtenidas del repositorio

    fun getBanks() = repository.getBanks()
    fun addBank(bank: BankModel) = repository.addBank(bank)

    //funcion para validdacion de datos
    fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            country.value.isNullOrEmpty() -> return false
        }
        return true
    }

    //funcion para crear banco
    fun createBank(){
        if(validateData()){
            val bank = BankModel(name.value.toString(), country.value.toString())
            addBank(bank)
            status.value = BANK_CREATED
        }else{
            status.value = BANK_NOT_CREATED
        }
    }

    //limpiar data
    fun clearData(){
        name.value = ""
        country.value = ""
    }

    //limpiar el estado
    fun clearStatus(){
        status.value = BASE
    }

    //setear el elemneto seleccionado
    fun setSelectedItem(bank: BankModel){
        name.value = bank.name
        country.value = bank.country
    }


    //creacion del companion object para la factory y estados
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BankTrackerApplication
                BankViewModel(app.bankRepository)
            }
        }

        //manejo de estados
        const val BANK_CREATED = "BANK_CREATED"
        const val BANK_NOT_CREATED = "BANK_NOT_CREATED"
        const val BASE = "BASE"
    }
}