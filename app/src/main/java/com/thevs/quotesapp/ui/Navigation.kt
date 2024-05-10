package com.thevs.quotesapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thevs.quotesapp.ui.screens.CategoriesScreen
import com.thevs.quotesapp.ui.screens.RandomQuoteDetailsScreen
import com.thevs.quotesapp.ui.screens.HomeScreen
import com.thevs.quotesapp.viewmodel.MainViewModel


sealed class Routes(val route: String) {
    data object HomeScreen : Routes("homeScreen")
    data object CategoriesScreen : Routes("categoriesScreen")
    data object RandomQuoteDetailsScreen : Routes("randomQuoteDetailsScreen")
}

@Composable
fun AppNavigation() {
    val navHostController = rememberNavController()
    val viewModel: MainViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = Routes.HomeScreen.route) {
        composable(Routes.HomeScreen.route) {
            viewModel.loadQuotes()
            HomeScreen(viewModel, navHostController)
        }
        composable(Routes.CategoriesScreen.route) {
            CategoriesScreen(navHostController, viewModel)
        }
        composable(Routes.RandomQuoteDetailsScreen.route) {
            RandomQuoteDetailsScreen(navHostController)
        }
    }
}
