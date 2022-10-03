package com.example.todocompose.navigation.destinations

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.todocompose.ui.SharedViewModel
import com.example.todocompose.ui.screens.list.ListScreen
import com.example.todocompose.utils.Action
import com.example.todocompose.utils.Constants.LIST_ARGUMENT_KEY
import com.example.todocompose.utils.Constants.LIST_SCREEN
import com.example.todocompose.utils.toAction
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.listComposable(
    navigateToTask: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel,
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { NavBackStackEntry ->
        val action = NavBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        var myAction by rememberSaveable {
            mutableStateOf(Action.NO_ACTION)
        }
        LaunchedEffect(key1 = myAction) {
            if (action != myAction) {
                myAction = action
                sharedViewModel.action.value = action
            }
        }

        val dbAction by sharedViewModel.action

        ListScreen(
            action = dbAction,
            navigateToTaskScreen = navigateToTask,
            sharedViewModel = sharedViewModel
        )
    }
}