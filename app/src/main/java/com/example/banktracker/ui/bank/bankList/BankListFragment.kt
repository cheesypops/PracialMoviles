package com.example.banktracker.ui.bank.bankList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banktracker.R
import com.example.banktracker.data.bankModel.BankModel
import com.example.banktracker.databinding.BankItemBinding
import com.example.banktracker.databinding.FragmentBankListBinding
import com.example.banktracker.ui.bank.bankList.recycleView.BankAdapter
import com.example.banktracker.ui.bank.bankViewModel.BankViewModel

class BankListFragment : Fragment() {
    //creacion de variables generales
    private lateinit var binding: FragmentBankListBinding

    private val bankViewModel: BankViewModel by activityViewModels<BankViewModel> {
        BankViewModel.Factory
    }

    private lateinit var adapter: BankAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBankListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.actionToCreateMovie.setOnClickListener(){
            bankViewModel.clearData()
            it.findNavController().navigate(R.id.action_bankListFragment_to_newBankFragment)
        }
    }

    //funion para mostrar banco seleccionado
    private fun showSelectedBank(bank: BankModel){
        bankViewModel.setSelectedItem(bank)

        findNavController().navigate(R.id.action_bankListFragment_to_bankInfoFragment)
    }

    //funcion de display
    private fun displayBanks(){
        adapter.setData(bankViewModel.getBanks())
        adapter.notifyDataSetChanged()
    }

    //setear el recycle view
    private fun setRecyclerView(view:View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = BankAdapter{bank -> showSelectedBank(bank)}

        binding.recyclerView.adapter = adapter
        displayBanks()
    }
}