package com.example.shopeerdriver.features.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.shopeerdriver.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private  val homeViewModel: HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirmButton()



    }
    private fun  test(){
        lifecycleScope.launch {
            homeViewModel.list.collect{
                Log.i("text 123", it.toString())
            }
        }
    }

    private fun validatedInputs(){
        if (!homeViewModel.validInputs(binding.myAddressEditText.text.toString(), binding.destinationAddressEdiText.text.toString() )){
            binding.myAddressEditText.error = "Por favor digite o nome da sua localidade "
            binding.destinationAddressEdiText.error = "Por favor digite o nome da localidade de destino "

        }else{
            test()
            homeViewModel.getText(binding.myIdEditText.text.toString(), binding.myAddressEditText.text.toString(), binding.destinationAddressEdiText.text.toString())
        }
    }

    private  fun confirmButton() {
        binding.confirmButton.setOnClickListener {
            validatedInputs()
        }
    }
    
}