package com.example.shopeerdriver.di

import com.example.shopeerdriver.Api.repository.UserAddressApi
import com.example.shopeerdriver.Api.repository.UserRepository
import com.example.shopeerdriver.features.home.EstimateRideCostUseCase
import com.example.shopeerdriver.features.home.EstimateRideCostUseCaseInterface
import com.example.shopeerdriver.features.home.HomeViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.factory


val retrofitModule = module {
    factory<Interceptor> {
        HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger.DEFAULT
        ).setLevel(
            HttpLoggingInterceptor.Level.HEADERS
        )
    }
    factory {
        OkHttpClient.Builder().addInterceptor(
            interceptor = get()
        ).build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://xd5zl5kk2yltomvw5fb37y3bm40vsyrx.lambda-url.sa-east-1.on.aws")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}

val apiModule = module {
    single {
        get<Retrofit>().create(UserAddressApi::class.java)
    }
}

val homeViewModel = module {
    viewModel{
        HomeViewModel(get())
    }
}

val repository = module {
    factory {
        UserRepository(get())
    }
}


val useCasesModules = module {
    factory<EstimateRideCostUseCaseInterface> {
        EstimateRideCostUseCase(get())
    }
}



