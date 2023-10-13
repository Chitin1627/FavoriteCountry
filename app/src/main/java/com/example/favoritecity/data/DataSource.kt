package com.example.favoritecity.data

import com.example.favoritecity.R

object DataSource {
    val categories = listOf(
        SmallDetail(R.string.coffee, R.drawable.coffee_category),
        SmallDetail(R.string.restaurant, R.drawable.restaurant_image),
        SmallDetail(R.string.kid_friendly, R.drawable.kid_friendly_image),
        SmallDetail(R.string.parks, R.drawable.park_image),
        SmallDetail(R.string.northern_lights, R.drawable.northern_lights)
    )

    val cafeList = listOf(
        SmallDetail(R.string.tim_wendeloe, R.drawable.tim_wendeloe),
        SmallDetail(R.string.kaffebrenneriet, R.drawable.kaffebrenneriet),
        SmallDetail(R.string.united_bakeries, R.drawable.united_bakeries),
        SmallDetail(R.string.godt_brod_grunerlokka, R.drawable.godt_brod_grunerlokka),
        SmallDetail(R.string.fragnance_of_the_heart, R.drawable.fragrance_of_the_heart)
    )

    val restaurantList = listOf(
        SmallDetail(R.string.sabi_omakase_oslo, R.drawable.sabi_omakase_oslo),
        SmallDetail(R.string.statholdergarden, R.drawable.statholdergaarden),
        SmallDetail(R.string.eik_annen_etage, R.drawable.eik_annen_etage),
        SmallDetail(R.string.hos_thea, R.drawable.hos_thea),
        SmallDetail(R.string.maaemo, R.drawable.maaemo)
    )

    val kidFriendlyPlacesList = listOf(
        SmallDetail(R.string.dovrefjell_sunndalsfjella_national_park, R.drawable.dovrefjell_sunndalsfjella_national_park),
        SmallDetail(R.string.hunderfossen_familiepark, R.drawable.hunderfossen_familiepark),
        SmallDetail(R.string.viking_museum, R.drawable.viking_museum)
    )

    val parkList = listOf(
        SmallDetail(R.string.ovre_pasvik_national_park, R.drawable.ovre_pasvik_national_park),
        SmallDetail(R.string.varangerhalv_ya_national_park, R.drawable.varangerhalv_ya_national_park),
        SmallDetail(R.string.stringstabbursdalen_national_park, R.drawable.stabbursdalen_national_park),
        SmallDetail(R.string.dovrefjell_sunndalsfjella_national_park, R.drawable.dovrefjell_sunndalsfjella_national_park)
    )

    val northernLightsList = listOf(
        SmallDetail(R.string.lofoten, R.drawable.lofoten),
        SmallDetail(R.string.tromso, R.drawable.tromso),
        SmallDetail(R.string.svalbard, R.drawable.svalbard),
        SmallDetail(R.string.trondheim, R.drawable.trondheim)
    )
}