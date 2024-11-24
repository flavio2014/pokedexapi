package br.com.pokeapidex.presentation

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.pokeapidex.databinding.PokemonCardBinding
import br.com.pokeapidex.domain.model.SinglePokemon
import br.com.pokeapidex.util.showIf
import coil.load

class PokemonViewHolder(
    binding: PokemonCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val image = binding.pokemonImage
    private val name = binding.pokemonName
    private val id = binding.pokemonId
    private val firstType = binding.firstPokemonType
    private val secondType = binding.secondPokemonType

    fun bind(singlePokemon: SinglePokemon) {
        loadPokemonImage(image, singlePokemon.imageUrl)
        name.text = singlePokemon.name
        id.text = singlePokemon.id.toString()
        firstType.text = singlePokemon.types.first().name
        secondType.text = singlePokemon.types.last().name
        secondType.apply {
            showIf(text.isNotEmpty())
        }
    }

    private fun loadPokemonImage(image: ImageView, imageUrl: String) {
        image.load(imageUrl)
    }
}