package com.example.shopeerdriver.features.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopeerdriver.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private  val homeViewModel: HomeViewModel by viewModel()

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

    private fun validatedInputs(){
        if (!homeViewModel.validInputs(binding.myAddressEditText.text.toString(), binding.destinationAddressEdiText.text.toString() )){
            binding.myAddressEditText.error = "Por favor digite o nome da sua localidade "
            binding.destinationAddressEdiText.error = "Por favor digite o nome da localidade de destino "
        }else{

        }
    }

    private  fun confirmButton() {
        binding.confirmButton.setOnClickListener {
            validatedInputs()
        }
    }
    
}