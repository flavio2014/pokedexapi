package br.com.pokeapidex.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.pokeapidex.data.api.PokemonApi
import br.com.pokeapidex.util.Constants.PAGE_SIZE
import br.com.pokeapidex.domain.model.SinglePokemon
import br.com.pokeapidex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonRepositoryImpl(private val api: PokemonApi) : PokemonRepository {

    override fun getSinglePokemon(): Flow<PagingData<SinglePokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = { PokedexPagingSource(api) }
        ).flow
    }
}