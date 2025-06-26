package klyuch.echovote.app.di.modules

import klyuch.echovote.home.ui.view_models.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
}