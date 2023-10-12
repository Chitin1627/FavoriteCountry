package com.example.favoritecity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.favoritecity.data.SmallDetail


@Composable
fun CategoryScreen(
    categories: List<SmallDetail>,
    onValueSelect: (SmallDetail)->Unit,
    onClick: ()->Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(categories) {
            CategoryCard(
                category = it,
                onClick = {
                    onValueSelect(it)
                    onClick()
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    category: SmallDetail,
    onClick: ()->Unit,
    modifier : Modifier = Modifier
)
{
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        onClick = {
            onClick()
        },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = modifier
                .sizeIn(minHeight = 60.dp)
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 12.dp)
                    .clip(CircleShape)
                    .size(45.dp)
            )
            
            Text(
                text = stringResource(id = category.title),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 12.dp)
            )
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    //CategoryCard(cardTitle = R.string.coffee, cardImage = R.drawable.coffee_category, onClick = {})
}

