package com.example.ticketmasterchallange.domain

import com.example.ticketmasterchallange.data.response.ImageResponse

data class Tickets(
    val embedded: Embedded
)

data class Embedded(
    val events: List<TicketEvent>
)

data class TicketEvent(
    val name: String,
    val type: String,
    val id: String,
    val test: Boolean,
    val url: String,
    val locale: String,
    val images: List<ImageEvent>
)

data class ImageEvent(
    val ratio: String,
    val url: String,
    val width: Int,
    val height: Int,
    val fallback: Boolean
)
