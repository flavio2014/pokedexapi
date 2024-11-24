package br.com.pokeapidex.di

import br.com.pokeapidex.domain.interactor.GetSinglePokemonUseCase
import org.koin.dsl.module

fun domainModule() = module {
    factory{ GetSinglePokemonUseCase(get()) }
}