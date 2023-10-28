package com.trabalho.Trabalho.de.TEDS.II.service

import br.upf.TrabalhoTEDSII.converters.ProdutoConverter
import com.trabalho.Trabalho.de.TEDS.II.model.Produto
import com.trabalho.Trabalho.de.TEDS.II.dtos.ProdutoResponseDTO
import com.trabalho.Trabalho.de.TEDS.II.model.ProdutoDTO
import com.trabalho.Trabalho.de.TEDS.II.repository.ProdutoRepository

import com.trabalho.Trabalho.de.TEDS.II.excepitions.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProdutoService<T>(private val repository: ProdutoRepository, private val converter: ProdutoConverter) {
    private val ERROR_MESSAGE = "Produto não encontrado"

    fun listar(nomeProduto: String?, paginacao: Pageable): Page<ProdutoResponseDTO> {
        val produtos = if (nomeProduto.isNullOrBlank()) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeProduto, paginacao)
        }

        return produtos.map(converter::toProdutoResponseDTO)
    }

    fun buscarPorId(id: Long): ProdutoResponseDTO {
        val produto = repository.findById(id)
            .orElseThrow { NotFoundException(ERROR_MESSAGE) }
        return converter.toProdutoResponseDTO(produto)
    }

    fun cadastrar(dto: ProdutoDTO): ProdutoResponseDTO {
        val produto = converter.toProduto(dto)
        val produtoSalvo = repository.save(produto)
        return converter.toProdutoResponseDTO(produtoSalvo)
    }

    fun atualizar(id: Long, dto: ProdutoDTO): ProdutoResponseDTO {
        val produto = repository.findById(id)
            .orElseThrow { NotFoundException(ERROR_MESSAGE) }
            .copy(
                nome = dto.nome,
                quantidade = dto.quantidade,
                valor = dto.valor
            )
        return converter.toProdutoResponseDTO(repository.save(produto))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun atualizarQuantidade(produto: Produto, quantidadeVendida: Int) {
        val produtoAtualizado = produto.copy(quantidade = produto.quantidade - quantidadeVendida)
        repository.save(produtoAtualizado)
    }
}
