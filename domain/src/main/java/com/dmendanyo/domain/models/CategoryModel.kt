package com.dmendanyo.domain.models

data class CategoryModel(
    val id: Int,
    val urlImage: String,
    val title: String,
    val subtitle: String? = null,
)