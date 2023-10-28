package br.upf.TrabalhoTEDSII.converters

import com.trabalho.Trabalho.de.TEDS.II.dtos.ProdutoResponseDTO
import com.trabalho.Trabalho.de.TEDS.II.model.Produto
import com.trabalho.Trabalho.de.TEDS.II.model.ProdutoDTO
import org.springframework.stereotype.Component

@Component
class ProdutoConverter {

    fun toProduto(dto: ProdutoDTO): Produto {
        return Produto(
            nome = dto.nome,
            quantidade = dto.quantidade,
            valor = dto.valor
        )
    }

    fun toProdutoResponseDTO(produto: Produto): ProdutoResponseDTO {
        return ProdutoResponseDTO(
            id = produto.id!!,
            nome = produto.nome,
            quantidade = produto.quantidade,
            valor = produto.valor
        )
    }
}
