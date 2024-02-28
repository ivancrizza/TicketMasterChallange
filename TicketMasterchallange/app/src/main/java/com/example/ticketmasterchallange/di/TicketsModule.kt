package com.example.ticketmasterchallange.di

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.ticketmasterchallange.data.RetrofitClient
import com.example.ticketmasterchallange.data.TicketApiService
import com.example.ticketmasterchallange.data.repository.TicketRepository
import com.example.ticketmasterchallange.data.room.EventDao
import com.example.ticketmasterchallange.data.room.TicketDataBase
import com.example.ticketmasterchallange.domain.TicketsRepositoryImpl
import com.example.ticketmasterchallange.ui.viewmodel.TicketViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            TicketDataBase::class.java,
            "ticket_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single<TicketRepository> { TicketsRepositoryImpl(get(), get()) }

    single {
        val appDataBase: TicketDataBase = get()
        appDataBase.eventDao()
    }
    single {
        RetrofitClient.apiService
    }
    viewModel { TicketViewModel(get()) }
}