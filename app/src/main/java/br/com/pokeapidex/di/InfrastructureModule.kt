package br.com.pokeapidex.di

import br.com.pokeapidex.data.api.PokemonApi
import br.com.pokeapidex.util.Constants
import br.com.pokeapidex.data.datasource.PokedexPagingSource
import br.com.pokeapidex.data.datasource.PokemonRepositoryImpl
import br.com.pokeapidex.domain.repository.PokemonRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun infrastructureModule() = module {
    factory { provideRetrofit() }
    factory { providePokemonApi(get()) }
    factory { PokedexPagingSource(get()) }
    factory<PokemonRepository> { PokemonRepositoryImpl(get()) }
}

private fun providePokemonApi(retrofit: Retrofit): PokemonApi {
    return retrofit.create(PokemonApi::class.java)
}

private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().run {
        addConverterFactory(GsonConverterFactory.create())
        baseUrl(Constants.BASE_URL)
        build()
    }
}