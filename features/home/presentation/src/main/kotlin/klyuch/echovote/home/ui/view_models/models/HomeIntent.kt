package klyuch.echovote.home.ui.view_models.models

import klyuch.echovote.core.ui.view_models.models.AppIntent

sealed class HomeIntent : AppIntent() {
    data object OnScreenOpened : HomeIntent()
}