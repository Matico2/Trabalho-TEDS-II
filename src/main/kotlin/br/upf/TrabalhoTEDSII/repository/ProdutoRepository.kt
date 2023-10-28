package com.trabalho.Trabalho.de.TEDS.II.repository

import com.trabalho.Trabalho.de.TEDS.II.model.Produto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository: JpaRepository<Produto, Long> {
    fun findByNome(nomeProduto: String, paginacao: Pageable): Page<Produto>
}
