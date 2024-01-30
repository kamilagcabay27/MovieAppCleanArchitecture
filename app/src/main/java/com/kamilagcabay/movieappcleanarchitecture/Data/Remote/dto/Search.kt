package com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto

data class Search(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String
)