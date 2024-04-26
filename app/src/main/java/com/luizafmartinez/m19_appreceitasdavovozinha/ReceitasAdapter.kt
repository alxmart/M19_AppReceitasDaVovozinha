package com.luizafmartinez.m19_appreceitasdavovozinha

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ReceitasAdapter: RecyclerView.Adapter<ReceitasAdapter.ReceitasViewHolder>() {

    private var listaReceitas: List<ReceitaDataClass> = listOf()
    //private var listaReceitas = listOf<ReceitaDataClass()

    fun adicionarItensLista(listaItens: List<ReceitaDataClass>) {
        listaReceitas = listaItens
        notifyDataSetChanged()
    }

    inner class ReceitasViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder( itemView ) {
         private var textTitulo: TextView = itemView.findViewById(R.id.textTituloReceita)
         private var textDetalhe: TextView = itemView.findViewById(R.id.textDetalheReceita)
         private var imgReceita: ImageView = itemView.findViewById(R.id.imageReceita)

        fun bind(receita: ReceitaDataClass) {
            textTitulo.text = receita.titulo
            textDetalhe.text = receita.descricao
            imgReceita.setImageDrawable(
                ContextCompat.getDrawable( itemView.context, receita.imagem )
            )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitasViewHolder {
        // Converter XML para objeto View

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rv_item_receita, parent, false)

        return ReceitasViewHolder( itemView )
    }

    override fun getItemCount(): Int {
        return listaReceitas.size
    }

    // Cria a conexão entre o layout e os dados
    override fun onBindViewHolder(holder: ReceitasViewHolder, position: Int) {
        /*val item = listaReceitas[position]
        holder.textTitulo.text = item*/
        val receita = listaReceitas[position]
        //holder.textTitulo.text = receita.titulo
        holder.bind(receita)
    }
}