package com.example.ticketmasterchallange.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ticketmasterchallange.R
import com.example.ticketmasterchallange.data.room.EventEntity
import com.example.ticketmasterchallange.ui.viewmodel.TicketViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun TicketList(viewModel: TicketViewModel = koinViewModel()) {
    val events by viewModel.events.collectAsState(initial = emptyList())
    SearchableEventList(events = events)
}


@Composable
fun TicketItem(event: EventEntity) {
    val urlMapped = event.imageUrl.firstOrNull()?.url ?: ""
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (urlMapped.isNotEmpty()) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(urlMapped)
                            .build()
                    ),
                    contentDescription = "Imagem do Evento",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.baseline_image_24),
                    contentDescription = ""
                )
            }

            Spacer(Modifier.width(8.dp))
            Text(
                text = event.name,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
fun SearchableEventList(events: List<EventEntity>) {
    var searchTerm by remember { mutableStateOf("") }
    val filteredEvents = events.filter {
        searchTerm.isEmpty() || it.name.contains(searchTerm, ignoreCase = true)
    }

    Column {
        TextField(
            value = searchTerm,
            onValueChange = { searchTerm = it },
            label = { Text("Search for Events") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyColumn {
            items(filteredEvents) { event ->
                TicketItem(event)
            }
        }
    }
}
