package com.example.wallpaper.model

data class PexelsResponse(
    val photos: List<Photo>
)

data class Photo(
    val id: Int,
    val src: Src,
    val photographer: String
)

data class Src(
    val original: String,
    val medium: String
)
