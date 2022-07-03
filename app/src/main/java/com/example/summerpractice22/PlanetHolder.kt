package com.example.summerpractice22

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.summerpractice22.databinding.ItemPlanetBinding

class PlanetHolder(
    private val binding: ItemPlanetBinding,
    private val glide: RequestManager,
    private val onItemClick: (Planet) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    fun onBind(planet: Planet) {
        with(binding) {
            tvName.text = planet.name
            tvSystem.text = planet.system
            root.setOnClickListener {
                onItemClick(planet)
            }

            /*glide
                .load(planet.picture)
                .placeholder(R.drawable.test_planet)
                .error(R.drawable.test_planet)
                .into(ivCover)*/
        }
    }
}
