package com.example.banktracker.ui.bank.bankInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.banktracker.R
import com.example.banktracker.databinding.FragmentBankInfoBinding
import com.example.banktracker.ui.bank.bankViewModel.BankViewModel

class BankInfoFragment : Fragment() {
    private lateinit var binding: FragmentBankInfoBinding

    private val bankViewMoel: BankViewModel by activityViewModels {
        BankViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBankInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = bankViewMoel
    }
}