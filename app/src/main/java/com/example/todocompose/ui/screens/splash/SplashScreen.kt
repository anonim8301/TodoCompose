package com.example.todocompose.ui.screens.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.todocompose.R
import com.example.todocompose.ui.theme.SPLASHSCREEN_LOGO_SIZE
import com.example.todocompose.ui.theme.splashScreenBackgroundColor
import com.example.todocompose.ui.theme.topAppBarContentColor
import com.example.todocompose.utils.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToListScreen: () -> Unit,
) {
    // Logo
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val offsetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp, animationSpec = tween(1000)
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(1000)
    )
    // Text
    var showText by remember {
        mutableStateOf(false)
    }
    val alphaStateForText by animateFloatAsState(
        targetValue = if (showText) 1f else 0f,
        animationSpec = tween(1000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(SPLASH_SCREEN_DELAY)
        navigateToListScreen()
    }
    LaunchedEffect(key1 = startAnimation) {
        delay(1100L)
        showText = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashScreenBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .alpha(alphaStateForText)
                .padding(bottom = 200.dp),
            text = "Todo App",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.topAppBarContentColor,
            fontWeight = FontWeight.Bold
        )
        Image(
            modifier = Modifier
                .size(SPLASHSCREEN_LOGO_SIZE)
                .offset(y = offsetState)
                .alpha(alphaState),
            painter = painterResource(id = getLogo()),
            contentDescription = stringResource(id = R.string.splash_screen_icon)
        )
    }
}

@Composable
fun getLogo(): Int {
    return if (isSystemInDarkTheme()) R.drawable.ic_logo_dark else R.drawable.ic_logo_dark
}