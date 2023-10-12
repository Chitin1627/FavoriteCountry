package com.example.favoritecity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.favoritecity.data.DataSource
import com.example.favoritecity.data.SmallDetail

@Composable
fun PlaceScreen(
    placeList: List<SmallDetail>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 16.dp
        )
    ) {
        items(placeList) {
            PlaceCard(it)
        }
    }
}

@Composable
fun PlaceCard(
    place: SmallDetail,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(
            topStart = 64.dp,
            topEnd = 64.dp,
            bottomStart = 64.dp,
            bottomEnd = 64.dp
        ),
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
            .fillMaxHeight(),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = place.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 32.dp,
                        start = 32.dp,
                        end = 32.dp
                    )
                    .sizeIn(
                        minHeight = 200.dp,
                        maxHeight = 200.dp
                    )
                    .clip(RoundedCornerShape(32.dp)),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(id = place.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun PlaceScreenPreview() {
    PlaceScreen(placeList = DataSource.cafeList)
}