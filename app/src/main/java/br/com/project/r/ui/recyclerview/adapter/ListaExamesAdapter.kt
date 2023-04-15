package br.com.project.r.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.project.r.databinding.ExameItemBinding
import br.com.project.r.model.Cliente
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ListaExamesAdapter(
    private val context: Context,
    clientes: List<Cliente>
) : RecyclerView.Adapter<ListaExamesAdapter.ViewHolder>() {

    private val exames = clientes.toMutableList()

    class ViewHolder(private val binding: ExameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(cliente: Cliente) {
            val paciente = binding.exameItemCliente
            paciente.text = cliente.paciente
            val descricao = binding.exameItemDescricao
            descricao.text = cliente.descricao
            val horario = binding.exameItemHorario
            horario.text = cliente.horario
            val solicitante = binding.exameItemSolicitante
            solicitante.text = cliente.solicitante
            val valor = binding.exameItemValor
            val valorEmMoeda: String = formataParaMoedaBrasileira(cliente.valor)
            valor.text = valorEmMoeda
        }

        private fun formataParaMoedaBrasileira(valor: BigDecimal): String {
            val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return formatador.format(valor)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ExameItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exame = exames[position]
        holder.vincula(exame)
    }

    override fun getItemCount(): Int = exames.size

    fun atualiza(clientes: List<Cliente>) {
        this.exames.clear()
        this.exames.addAll(clientes)
        notifyDataSetChanged()
    }

}
