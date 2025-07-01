package klyuch.fastvote.app.di.modules

import klyuch.fastvote.home.ui.view_models.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
}