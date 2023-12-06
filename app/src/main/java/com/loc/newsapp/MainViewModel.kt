package com.loc.newsapp

import javax.inject.Inject

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.loc.newsapp.domain.usecases.AppEntryUseCases
import com.loc.newsapp.presentation.navigation.Route
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {
    var splashCondition = mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            startDestination = if (shouldStartFromHomeScreen) {
                Route.NewsNavigation.route
            } else {
                Route.AppStartNavigation.route
            }

            delay(300)

            splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}
