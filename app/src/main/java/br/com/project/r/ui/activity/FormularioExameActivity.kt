package br.com.project.r.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.project.r.R
import br.com.project.r.dao.ExamesDao
import br.com.project.r.databinding.ActivityFormularioExameBinding
import br.com.project.r.model.Cliente
import java.math.BigDecimal

class FormularioExameActivity :
    AppCompatActivity(R.layout.activity_formulario_exame) {


    private val binding by lazy { ActivityFormularioExameBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((binding.root))
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {

        val botaoSalvar = binding.activityFormularioExameBotaoSalvar
        val dao = ExamesDao()
        botaoSalvar.setOnClickListener {
            val exameNovo = criaExame()

            dao.adiciona(exameNovo)
            finish()

        }

    }

    private fun criaExame(): Cliente {
        val campoNome = binding.activityFormularioExameNome
        val nome = campoNome.text.toString()
        val campoDescricao = binding.activityFormularioExameDescricao
        val descricao = campoDescricao.text.toString()
        val campoHorario = binding.activityFormularioExameHorario
        val horario = campoHorario.text.toString()
        val campoSolicitante = binding.activityFormularioExameSolicitante
        val solicitante = campoSolicitante.text.toString()
        val campoValor = binding.activityFormularioExameValor
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Cliente(
            paciente = nome,
            descricao = descricao,
            horario = horario,
            solicitante = solicitante,
            valor = valor
        )
    }
}