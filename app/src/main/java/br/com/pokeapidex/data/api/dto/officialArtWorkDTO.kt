package br.com.pokeapidex.data.api.dto

import com.google.gson.annotations.SerializedName

data class OfficialArtWorkDTO(
    @SerializedName("front_default") val frontDefault: String? = null
)