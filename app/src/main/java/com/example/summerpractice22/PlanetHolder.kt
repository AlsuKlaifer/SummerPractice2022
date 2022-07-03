package com.example.summerpractice22

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice22.databinding.ItemPlanetBinding

class PlayerHolder(
    val binding: ItemPlanetBinding,
    private val onItemClick: (Planet) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(player: Planet) {
        with(binding) {
            playerName.text = "#" + player.position + " " + player.name
            //Добавить номер и другие поля, возможно
            root.setOnClickListener {
                onItemClick(player)
            }
        }
    }
}
