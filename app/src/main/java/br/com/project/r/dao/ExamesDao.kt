package br.com.project.r.dao

import br.com.project.r.model.Cliente
import java.math.BigDecimal

class ExamesDao {

    fun adiciona(cliente: Cliente) {
        clientes.add(cliente)
    }

    fun buscaTodos(): List<Cliente> {
        return clientes.toList()
    }

    companion object {
        private val clientes = mutableListOf<Cliente>(
            Cliente(
                paciente = "João Guilherme dos Santos",
                descricao = "Hemograma - Completo",
                horario = "19/05/23 - 08:00",
                solicitante = "Solicitante: Dr. Rodrigo Souza",
                valor = BigDecimal("50.00")
            ),
            Cliente(
                paciente = "Bruna dos Santos Silva",
                descricao = "Endoscopia - Digestiva",
                horario = "22/05/23 - 07:00",
                solicitante = "Solicitante: Dr. Roberto Batista",
                valor = BigDecimal("70.00")
            )
        )
    }

}