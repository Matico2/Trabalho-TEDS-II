package br.upf.TrabalhoTEDSII.controller

import com.trabalho.Trabalho.de.TEDS.II.dtos.ProdutoResponseDTO
import com.trabalho.Trabalho.de.TEDS.II.model.ProdutoDTO
import com.trabalho.Trabalho.de.TEDS.II.service.ProdutoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/produtos")
class ProdutoController(private val service: ProdutoService<Any?>) {

    @GetMapping
    fun listar(@RequestParam(required = false) nomeProduto: String?,
               @PageableDefault(size = 10) paginacao: Pageable
    ): Page<ProdutoResponseDTO> {
        return service.listar(nomeProduto, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ProdutoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody produto: ProdutoDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProdutoResponseDTO> {
        val produtoResponse = service.cadastrar(produto)
        val uri = uriBuilder.path("/produtos/${produtoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(produtoResponse)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long,
                  @RequestBody produto: ProdutoDTO): ProdutoResponseDTO {
        return service.atualizar(id, produto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
