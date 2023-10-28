package com.trabalho.Trabalho.de.TEDS.II.repository

import com.trabalho.Trabalho.de.TEDS.II.model.Venda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VendaRepository: JpaRepository<Venda, Long>
