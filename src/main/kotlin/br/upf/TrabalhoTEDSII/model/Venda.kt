package com.trabalho.Trabalho.de.TEDS.II.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Venda(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val produto: Produto, // Relacionamento com o produto
    val quantidade: Int,
    val valorTotal: Double
)
