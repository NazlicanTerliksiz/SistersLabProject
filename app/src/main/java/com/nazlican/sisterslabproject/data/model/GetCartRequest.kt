package com.nazlican.sisterslabproject.data.model

data class GetCartRequest(
    val message: String,
    val products: List<ProductXXX>,
    val status: Int
)