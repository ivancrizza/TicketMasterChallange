package com.example.ticketmasterchallange.data.response

import com.google.gson.annotations.SerializedName

data class TicketsResponse(
    @SerializedName("_embedded") val embedded: EmbeddedResponse
)

data class EmbeddedResponse(
    @SerializedName("events") val events: List<EventResponse>
)

data class EventResponse(
    @SerializedName("name")val name: String,
    @SerializedName("type")val type: String,
    @SerializedName("id")val id: String,
    @SerializedName("test")val test: Boolean,
    @SerializedName("url")val url: String,
    @SerializedName("locale")val locale: String,
    @SerializedName("images")val images: List<ImageResponse>
)

data class ImageResponse(
    @SerializedName("ratio") val ratio: String,
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("fallback") val fallback: Boolean
)