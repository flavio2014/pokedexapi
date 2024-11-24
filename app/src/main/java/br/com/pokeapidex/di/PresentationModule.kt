package br.com.pokeapidex.di

import br.com.pokeapidex.presentation.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun presentationModule() = module {
    viewModel { PokedexViewModel(get()) }
}