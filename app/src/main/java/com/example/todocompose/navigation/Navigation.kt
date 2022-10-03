package com.example.todocompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.todocompose.navigation.destinations.listComposable
import com.example.todocompose.navigation.destinations.splashComposable
import com.example.todocompose.navigation.destinations.taskComposable
import com.example.todocompose.ui.SharedViewModel
import com.example.todocompose.utils.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalAnimationApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {

        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTask = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel,
        )
    }
}