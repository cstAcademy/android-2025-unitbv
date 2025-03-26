package com.cst.cstacademy2025unitbv.models

enum class MediaType(val id: Int ) {
    PODCAST(0),
    IMAGE(1),
    VIDEO(2),
    TEXT(3)
}

sealed class MediaModel(
    val type: MediaType
)


class PodcastModel(): MediaModel(MediaType.PODCAST)