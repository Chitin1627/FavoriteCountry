package com.example.favoritecity.data

import com.example.favoritecity.R

object DataSource {
    val categories = listOf(
        SmallDetail(R.string.coffee, R.drawable.coffee_category),
        SmallDetail(R.string.restaurant, R.drawable.restaurant_image),
        SmallDetail(R.string.kid_friendly, R.drawable.kid_friendly_image),
        SmallDetail(R.string.parks, R.drawable.park_image),
        SmallDetail(R.string.shopping_centre, R.drawable.shopping_image)
    )

    val cafeList = listOf(
        SmallDetail(R.string.tim_wendeloe, R.drawable.tim_wendeloe),
        SmallDetail(R.string.kaffebrenneriet, R.drawable.kaffebrenneriet),
        SmallDetail(R.string.united_bakeries, R.drawable.united_bakeries),
        SmallDetail(R.string.godt_brod_grunerlokka, R.drawable.godt_brod_grunerlokka),
        SmallDetail(R.string.fragnance_of_the_heart, R.drawable.fragrance_of_the_heart)
    )
}