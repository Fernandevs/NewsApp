package com.loc.newsapp.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

import com.loc.newsapp.presentation.onboarding.OnBoardingScreen
import com.loc.newsapp.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {
            navigation(
                route = Route.AppStartNavigation.route,
                startDestination = Route.OnBoardingScreen.route,
                builder = {
                    composable(
                        route = Route.OnBoardingScreen.route,
                        content = {
                            val viewModel: OnBoardingViewModel = hiltViewModel()

                            OnBoardingScreen(event = viewModel::onEvent)
                        }
                    )
                }
            )
            navigation(
                route = Route.NewsNavigation.route,
                startDestination = Route.NewsNavigationScreen.route,
                builder = {
                    composable(
                        route = Route.NewsNavigationScreen.route,
                        content = {
                            Text(text = "News Navigation Screen")
                        }
                    )
                }
            )
        }
    )
}
