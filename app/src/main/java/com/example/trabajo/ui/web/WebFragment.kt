package com.example.trabajo.ui.web


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trabajo.databinding.FragmentWebBinding

class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val webViewModel =
            ViewModelProvider(this).get(WebViewModel::class.java)

        _binding = FragmentWebBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //ACA SE PROGRAMA LAS FUNCIONALIDADES DE LA VISTA

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}