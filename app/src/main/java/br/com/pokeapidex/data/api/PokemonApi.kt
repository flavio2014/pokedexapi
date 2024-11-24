package br.com.pokeapidex.data.api

import br.com.pokeapidex.data.api.dto.PokemonDTO
import br.com.pokeapidex.data.api.dto.SinglePokemonDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon/")
    suspend fun getPokemon(
        @Query("offset") offset: Int?
    ): Response<PokemonDTO>

    @GET("pokemon/{name}")
    suspend fun getSinglePokemon(
        @Path("name") name: String?
    ) : Response<SinglePokemonDTO>

}