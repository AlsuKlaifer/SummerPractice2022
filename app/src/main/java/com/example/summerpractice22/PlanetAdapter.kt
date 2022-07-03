package com.example.summerpractice22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice22.databinding.ItemPlanetBinding

class PlanetAdapter(private val list: List<Planet>, function: () -> Unit): RecyclerView.Adapter<PlanetHolder>() {

        val playersList = ArrayList<Planet>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetHolder = PlanetHolder(
            ItemPlanetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        override fun onBindViewHolder(holder: PlanetHolder, position: Int) {
            holder.onBind(playersList[position])
        }

        override fun getItemCount(): Int {
            return playersList.size
        }

    }