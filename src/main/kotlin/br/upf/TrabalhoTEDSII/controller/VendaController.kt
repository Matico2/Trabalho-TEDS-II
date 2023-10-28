package br.upf.TrabalhoTEDSII.controller

import com.trabalho.Trabalho.de.TEDS.II.model.Produto
import com.trabalho.Trabalho.de.TEDS.II.model.Venda
import com.trabalho.Trabalho.de.TEDS.II.service.VendaService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class VendaController(private val vendaService: VendaService) {
    @PostMapping("/venda")
    fun cadastrarVenda(@RequestBody vendaRequest: VendaRequest): Venda {
        val produto = vendaRequest.produto
        val quantidade = vendaRequest.quantidade
        return vendaService.cadastrarVenda(produto, quantidade)
    }
}

data class VendaRequest(val produto: Produto, val quantidade: Int)
