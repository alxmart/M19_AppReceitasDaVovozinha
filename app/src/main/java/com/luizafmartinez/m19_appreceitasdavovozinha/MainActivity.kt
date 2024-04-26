package com.luizafmartinez.m19_appreceitasdavovozinha

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerReceitas: RecyclerView

    private lateinit var adapter: ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerReceitas = findViewById(R.id.rvReceitas)

        val listaReceitas = listOf(
            ReceitaDataClass(R.drawable.carne1, "Escondidinho de Camarão", "20 min"),
            ReceitaDataClass(R.drawable.carne2, "Panqueca de carne moída", "30 min"),
            ReceitaDataClass(R.drawable.carne3, "Rocambole de carne moída", "40 min"),
            ReceitaDataClass(R.drawable.carne4, "Escondidinho de carne seca", "25 min"),
            ReceitaDataClass(R.drawable.carne1, "Escondidinho de Camarão2", "20 min"),
            ReceitaDataClass(R.drawable.carne2, "Panqueca de carne moída2", "30 min"),
            ReceitaDataClass(R.drawable.carne3, "Rocambole de carne moída2", "40 min"),
            ReceitaDataClass(R.drawable.carne4, "Escondidinho de carne seca2", "25 min"),
            ReceitaDataClass(R.drawable.carne1, "Escondidinho de Camarão3", "20 min"),
            ReceitaDataClass(R.drawable.carne2, "Panqueca de carne moída3", "30 min"),
            ReceitaDataClass(R.drawable.carne3, "Rocambole de carne moída3", "40 min"),
            ReceitaDataClass(R.drawable.carne4, "Escondidinho de carne seca3", "25 min"),
            ReceitaDataClass(R.drawable.carne1, "Escondidinho de Camarão4", "20 min"),
            ReceitaDataClass(R.drawable.carne2, "Panqueca de carne moída4", "30 min"),
            ReceitaDataClass(R.drawable.carne3, "Rocambole de carne moída4", "40 min"),
            ReceitaDataClass(R.drawable.carne4, "Escondidinho de carne seca4", "25 min")
        )

        adapter = ReceitasAdapter{ receita ->
            Toast.makeText(this, "${receita.titulo}", Toast.LENGTH_SHORT).show()
        }

        adapter.adicionarItensLista(listaReceitas)

        recyclerReceitas.adapter = adapter
        recyclerReceitas.layoutManager = LinearLayoutManager(this)
    }
}