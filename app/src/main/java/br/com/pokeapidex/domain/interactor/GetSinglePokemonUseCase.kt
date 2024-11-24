package br.com.pokeapidex.domain.interactor

import br.com.pokeapidex.domain.repository.PokemonRepository

class GetSinglePokemonUseCase(private val repository: PokemonRepository) {

    fun execute() = repository.getSinglePokemon()
}