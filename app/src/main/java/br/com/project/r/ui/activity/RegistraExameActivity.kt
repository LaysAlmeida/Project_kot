package br.com.project.r.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.project.r.dao.ExamesDao
import br.com.project.r.databinding.ActivityRegistraExameBinding
import br.com.project.r.ui.recyclerview.adapter.ListaExamesAdapter

class RegistraExameActivity : AppCompatActivity() {

    private val dao = ExamesDao()
    private val adapter = ListaExamesAdapter(context = this, clientes = dao.buscaTodos())

    private val binding by lazy {

        ActivityRegistraExameBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecycleView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = binding.activityRegistraExamesFab
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioExameActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecycleView() {
        val recyclerView = binding.activityRegistraExamesRecyclerView
        recyclerView.adapter = adapter
    }

}