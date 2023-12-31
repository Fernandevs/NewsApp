package com.loc.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.loc.newsapp.presentation.navigation.NavGraph

import dagger.hilt.android.AndroidEntryPoint

import com.loc.newsapp.ui.theme.NewsAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition.value
            }
        }

        setContent {
            NewsAppTheme {
                Box(
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                    content = {
                        val startDestination = viewModel.startDestination
                        NavGraph(startDestination = startDestination)
                    }
                )
            }
        }
    }
}
