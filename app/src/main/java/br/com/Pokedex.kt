package br.com.pokeapidex

import android.app.Application
import br.com.pokeapidex.di.inject

class Pokedex : Application() {

    override fun onCreate() {
        super.onCreate()
        inject()
    }
}