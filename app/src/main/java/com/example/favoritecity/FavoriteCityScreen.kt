package com.example.favoritecity

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.favoritecity.data.DataSource
import com.example.favoritecity.data.SmallDetail
import com.example.favoritecity.ui.AppViewModel
import com.example.favoritecity.ui.StartScreen
import com.example.favoritecity.ui.CategoryScreen
import com.example.favoritecity.ui.PlaceScreen

enum class FavoriteCityScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Category(title = R.string.choose_category),
    Place(title = R.string.choose_place)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteCityApp() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = FavoriteCityScreen.valueOf(
        backStackEntry?.destination?.route ?: FavoriteCityScreen.Start.name
    )
    val viewModel: AppViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            if(!uiState.isShowingStartScreen) {
                CityAppBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry!=null,
                    navigateUp = {
                        navController.navigateUp()
                        viewModel.updateStartScreenBool(navController.previousBackStackEntry==null)
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = FavoriteCityScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(route = FavoriteCityScreen.Start.name) {
                StartScreen(onClick = {
                    viewModel.updateStartScreenBool(false)
                    navController.navigate(FavoriteCityScreen.Category.name) }
                )
            }

            composable(route = FavoriteCityScreen.Category.name) {
                CategoryScreen(
                    categories = DataSource.categories,
                    onValueSelect = { viewModel.updateCategory(it) },
                    onClick = { navController.navigate(FavoriteCityScreen.Place.name) }
                )
            }

            composable(route = FavoriteCityScreen.Place.name) {
                uiState.categoryChosen?.title?.let { it1 -> stringResource(id = it1) }
                    ?.let { it2 -> Log.d("Category", it2) }
                val placeChosenList: List<SmallDetail>
                val categoryChosen = uiState.categoryChosen?.title
                placeChosenList = when(categoryChosen) {
                    R.string.coffee -> DataSource.cafeList
                    R.string.restaurant -> DataSource.restaurantList
                    else -> listOf()
                }
                PlaceScreen(placeList = placeChosenList)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    currentScreen: FavoriteCityScreen,
    canNavigateBack: Boolean,
    navigateUp: ()->Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        )
    )
}