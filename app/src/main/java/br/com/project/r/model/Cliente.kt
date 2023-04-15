package br.com.project.r.model

import java.math.BigDecimal

data class Cliente(
        val paciente: String,
        val descricao: String,
        val solicitante: String,
        val horario: String,
        val valor: BigDecimal
)
