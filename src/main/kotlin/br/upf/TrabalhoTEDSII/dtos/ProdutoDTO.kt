package com.trabalho.Trabalho.de.TEDS.II.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ProdutoDTO(
    @field:NotBlank(message = "Produto sempre deve ter um nome!")
    val nome: String,
    @field:NotNull(message = "Produto deve ter uma quantidade")
    val quantidade: Int,
    @field:NotBlank(message = "Produto deve ter um valor")
    val valor: Double,
)
