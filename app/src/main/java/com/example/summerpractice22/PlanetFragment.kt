package com.example.summerpractice22
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice22.R
import com.example.summerpractice22.databinding.FragmentPlanetsBinding
import com.google.android.material.snackbar.Snackbar

class PlanetFragment : Fragment(R.layout.fragment_music) {

    private var _binding: FragmentPlanetsBinding? = null
    private val binding get() = _binding!!

    private var adapter: SongAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlanetsBinding.bind(view)

        adapter = SongAdapter(SongRepository.songs) {
            findNavController().navigate(R.id.action_musicFragment_to_songInfFragment,
                SongInfFragment.createBundle(it.id.toString()))
        }

        binding.rvMusic.adapter = adapter

        with(binding) {
            btnMusic.setOnClickListener {
                findNavController().navigate(
                    R.id.action_musicFragment_to_firstFragment,
                    MainFragment.createBundle(tvScreenName.text.toString())
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}