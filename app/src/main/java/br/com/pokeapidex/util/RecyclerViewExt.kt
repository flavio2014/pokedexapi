package br.com.pokeapidex.util

import  androidx.recyclerview.widget.RecyclerView

fun RecyclerView.showView() {
    visibility = RecyclerView.VISIBLE
}

fun RecyclerView.hideView() {
    visibility = RecyclerView.GONE
}