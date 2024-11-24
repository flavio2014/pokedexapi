package br.com.pokeapidex.data.mapper

import br.com.pokeapidex.data.api.dto.SinglePokemonDTO
import br.com.pokeapidex.data.api.dto.SlotTypeDTO
import br.com.pokeapidex.domain.model.SinglePokemon
import br.com.pokeapidex.domain.model.Type
import br.com.pokeapidex.util.emptyString
import br.com.pokeapidex.util.zeroNumber

fun SlotTypeDTO.toModel() = Type(
    name = typeDTO.name ?: emptyString()
)

fun List<SlotTypeDTO>.toModel(): List<Type> {
    val types = mutableListOf<Type>()
    types.add(this.first().toModel())
    this.first().let { firstType ->
        this.last().let { secondType ->
            if(secondType != firstType) {
            } else {
                types.add(Type(emptyString()))
            }
        }
    }
    return types.toList()
}

fun SinglePokemonDTO.toModel() = SinglePokemon(
    name = name ?: emptyString(),
    id = id ?: zeroNumber(),
    imageUrl = sprites.other.officialArtworkDTO.frontDefault ?: emptyString(),
    types = types.toModel()
)