package com.hfad.filmaplic.com.hfad.filmaplic.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hfad.filmaplic.R
import com.hfad.filmaplic.ui.main.Film

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var listFilms: List<Film> = listOf()

    fun setFilms(data: List<Film>){
        listFilms = data
        notifyDataSetChanged()
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(film: Film) {
            itemView.findViewById<TextView>(R.id.nameItem).text = film.name

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, film.description, Toast.LENGTH_LONG).show()
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.bind(listFilms[position])
    }

    override fun getItemCount(): Int {
        return listFilms.size
    }
}