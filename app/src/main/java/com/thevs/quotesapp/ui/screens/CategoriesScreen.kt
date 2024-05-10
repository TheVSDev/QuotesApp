package com.thevs.quotesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.thevs.quotesapp.ui.Routes
import com.thevs.quotesapp.ui.components.BaseButton
import com.thevs.quotesapp.ui.components.Title
import com.thevs.quotesapp.viewmodel.MainViewModel

@Composable
fun CategoriesScreen(navController: NavHostController, viewModel: MainViewModel) {
    LaunchedEffect(Unit) {
        viewModel.loadCategories()
    }
    val categories = viewModel.categories.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            BaseButton({ navController.navigate(Routes.HomeScreen.route) }, "", "ArrowBack")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Title(title = "List of categories")
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            itemsIndexed(categories) { _, category ->
                Text(
                    text = category.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

    }
}
