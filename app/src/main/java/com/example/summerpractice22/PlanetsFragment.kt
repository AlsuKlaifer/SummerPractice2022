package com.example.summerpractice22

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.summerpractice22.databinding.FragmentPlanetsBinding

class PlanetsFragment : Fragment(R.layout.fragment_planets) {

    private var _binding: FragmentPlanetsBinding? = null
    private val binding get() = _binding!!

    private var adapter: PlanetAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlanetsBinding.bind(view)
        initAdapter()
//        initPref()
    }

    private fun initAdapter() {
        adapter = PlanetAdapter(
            PlanetRepository.planet,
            Glide.with(this)
        ) {
            binding.root.showSnackbar("Planet id: ${it.id}")
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("id", it.id)
            }
            startActivity(intent)
        }
        binding.tvTitle.setOnClickListener {
            PlanetRepository.planet.removeAt(0)
            adapter?.updateData(PlanetRepository.planet)
        }
        binding.rvPlanet.adapter = adapter
        binding.rvPlanet.layoutManager = GridLayoutManager(requireContext(), 1)

    }

    private fun initPref() {
        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
        val value = pref.getString("PREF_TEXT", "error").orEmpty()
        binding.root.showSnackbar(value)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_TEXT = "amazing"

        fun createBundle(text: String): Bundle {
            val bundle = Bundle()
            bundle.putString(
                ARG_TEXT,
                text
            )
            return bundle
        }
    }
}