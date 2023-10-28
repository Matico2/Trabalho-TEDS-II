package com.trabalho.Trabalho.de.TEDS.II.service

import com.trabalho.Trabalho.de.TEDS.II.model.Produto
import com.trabalho.Trabalho.de.TEDS.II.model.Venda
import com.trabalho.Trabalho.de.TEDS.II.repository.VendaRepository
import org.springframework.stereotype.Service

@Service
class VendaService(
    private val vendaRepository: VendaRepository,
    private val produtoService: ProdutoService<Any?>, // Certifique-se de que ProdutoService seja injetado corretamente
) {
    fun cadastrarVenda(produto: Produto, quantidade: Int): Venda {
        val valorTotal = produto.valor * quantidade
        val venda = Venda(produto = produto, quantidade = quantidade, valorTotal = valorTotal)
        produtoService.atualizarQuantidade(produto, quantidade) // Atualiza a quantidade no produto
        return vendaRepository.save(venda)
    }
}
