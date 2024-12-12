package com.example.shopeerdriver

import android.app.Application
import com.example.shopeerdriver.di.apiModule
import com.example.shopeerdriver.di.homeViewModel
import com.example.shopeerdriver.di.repository
import com.example.shopeerdriver.di.retrofitModule
import com.example.shopeerdriver.di.useCasesModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
              listOf(
                  homeViewModel,
                  repository,
                  useCasesModules,
                  retrofitModule,
                   apiModule
              )
            )
        }
    }
}