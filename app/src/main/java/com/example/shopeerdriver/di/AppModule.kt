package com.example.shopeerdriver.di

import com.example.shopeerdriver.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModel = module {
    viewModel{
        HomeViewModel()
    }
}