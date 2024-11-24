package br.com.pokeapidex.domain.repository

import androidx.paging.PagingData
import br.com.pokeapidex.domain.model.SinglePokemon
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {

    fun getSinglePokemon(): Flow<PagingData<SinglePokemon>>
}