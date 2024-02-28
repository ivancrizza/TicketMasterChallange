package com.example.ticketmasterchallange.domain

import androidx.compose.ui.Modifier
import com.example.ticketmasterchallange.data.response.TicketsResponse

object TicketsMapper {
    fun convertResponseToModel(response: TicketsResponse): List<TicketEvent> {
        return response.embedded.events.map {
            TicketEvent(
                name = it.name,
                type = it.type,
                id = it.id,
                url = it.url,
                locale = it.locale,
                images = it.images.map { imageResponse ->
                    ImageEvent(
                        ratio = imageResponse.ratio,
                        url = imageResponse.url,
                        width = imageResponse.width,
                        height = imageResponse.height,
                        fallback = imageResponse.fallback
                    )
                },
                test = it.test
            )
        }
    }
}
