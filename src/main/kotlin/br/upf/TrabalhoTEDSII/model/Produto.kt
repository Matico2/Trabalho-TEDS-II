package com.trabalho.Trabalho.TEDS.II.model

import jakarta.persistence.*

@Entity
data class Produto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    var quantidade: Int,
    var valor: Double
) {
    @OneToMany(mappedBy = "produto")
    val vendas: MutableSet<Venda> = HashSet()
}
