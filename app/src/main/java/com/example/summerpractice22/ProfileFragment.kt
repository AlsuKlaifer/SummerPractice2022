package com.example.summerpractice22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class ProfileFragment: Fragment(R.layout.fragment_profile) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = getView()?.findViewById<Button>(R.id.btn_news)
        button?.setOnClickListener{view ->
            var bundle = bundleOf("Error" to this::class.toString())
            view.findNavController().navigate(R.id.action_profileFragment_to_newsFragment, bundle)
        }
    }
}