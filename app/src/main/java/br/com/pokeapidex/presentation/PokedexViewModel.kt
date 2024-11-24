package br.com.pokeapidex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.pokeapidex.domain.interactor.GetSinglePokemonUseCase
import br.com.pokeapidex.domain.model.SinglePokemon
import kotlinx.coroutines.flow.Flow

class PokedexViewModel(private val useCase: GetSinglePokemonUseCase) : ViewModel() {

    fun getPokemonFlow(): Flow<PagingData<SinglePokemon>> {
        return useCase.execute().cachedIn(viewModelScope)
    }

}