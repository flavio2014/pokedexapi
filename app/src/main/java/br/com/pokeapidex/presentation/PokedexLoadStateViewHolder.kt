package br.com.pokeapidex.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import br.com.pokeapidex.R
import br.com.pokeapidex.databinding.PokedexLoadStateFooterBinding
import br.com.pokeapidex.util.hideView
import br.com.pokeapidex.util.showView


class PokedexLoadStateViewHolder(
    private val binding: PokedexLoadStateFooterBinding,
    tryAgain: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.loadStateTryAgainButton.setOnClickListener { tryAgain.invoke() }
    }

    fun bind(loadState: LoadState) {
        when(loadState) {
            is LoadState.Loading -> {
                binding.loadStateProgressBar.showView()
                binding.loadStateErrorMessage.hideView()
                binding.loadStateTryAgainButton.hideView()
            }
            is LoadState.Error -> {
                binding.loadStateErrorMessage.showView()
                binding.loadStateTryAgainButton.showView()
                binding.loadStateProgressBar.hideView()
            }
            is LoadState.NotLoading -> {
                // Do nothing
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup, tryAgain: () -> Unit) : PokedexLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.pokedex_load_state_footer, parent, false)
            val binding = PokedexLoadStateFooterBinding.bind(view)
            return PokedexLoadStateViewHolder((binding), tryAgain)
        }
    }
}