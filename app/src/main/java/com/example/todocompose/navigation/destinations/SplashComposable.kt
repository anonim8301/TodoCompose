package com.example.todocompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.example.todocompose.ui.screens.splash.SplashScreen
import com.example.todocompose.utils.Constants.ANIMATION_SPEC_DURATION
import com.example.todocompose.utils.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { -it },
                animationSpec = tween(ANIMATION_SPEC_DURATION))
        }
    ) {
        SplashScreen(
            navigateToListScreen = navigateToListScreen
        )
    }
}