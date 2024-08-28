package com.pisces.piscesnews

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pisces.piscesnews.domain.usecases.app_entry.AppEntryUseCases
import com.pisces.piscesnews.presentation.navgrapgh.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    appEntryUseCases: AppEntryUseCases
):ViewModel() {


     var splashCondition by mutableStateOf(true)
         private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set
    init {

        appEntryUseCases.readAppEntry().onEach {shouldStartFromHomeScreen->
            if(shouldStartFromHomeScreen){
                startDestination= Route.NewsNavigator.route
            }
            else{
                startDestination = Route.AppStartNavigation.route
            }
            delay(400)
            splashCondition=false
        }.launchIn(viewModelScope)
    }

}