package com.example.banktracker.ui.bank.newBank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.banktracker.R
import com.example.banktracker.databinding.FragmentNewBankBinding
import com.example.banktracker.ui.bank.bankViewModel.BankViewModel


class NewBankFragment : Fragment() {
    //creacion de variable generales
    private lateinit var binding: FragmentNewBankBinding

    private val bankviewmodel: BankViewModel by activityViewModels {
        BankViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentNewBankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setviewModel()
        setObserver()
    }

    //funcion para setear el viewmodel
    private fun setviewModel(){
        binding.viewModel = bankviewmodel
    }

    ///funcion para setear el observer
    private fun setObserver(){
        bankviewmodel.status.observe(viewLifecycleOwner) {status ->
            when{
                status.equals(BankViewModel.BANK_CREATED) -> {
                    bankviewmodel.clearData()
                    bankviewmodel.clearStatus()

                    findNavController().popBackStack()
                }
                status.equals(BankViewModel.BANK_NOT_CREATED) -> {
                    bankviewmodel.clearStatus()
                }
            }
        }
    }
}