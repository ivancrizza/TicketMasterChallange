package com.example.ticketmasterchallange.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketmasterchallange.data.repository.TicketRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class TicketViewModel(private val ticketRepository: TicketRepository) : ViewModel() {


    val events = ticketRepository.getAllEvents()

    init {
        refreshEvents()
    }

    fun refreshEvents() {
        viewModelScope.launch {
            ticketRepository.refreshEvents()
        }
    }
}