package com.example.trabajo.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trabajo.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridView: GridView = binding.gridview

        // Corregir: Usar el layout correcto para los items del grid
        val adapter = ImageAdapter(requireContext(), galleryViewModel.images)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Intent(activity, DetailActivity::class.java).apply {
                putExtra("IMAGE_RES", galleryViewModel.images[position])
                startActivity(this)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Clase Adapter corregida
    class ImageAdapter(
        private val context: android.content.Context,
        private val images: List<Int>
    ) : android.widget.BaseAdapter() {

        override fun getCount(): Int = images.size

        override fun getItem(position: Int): Any = images[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            // Corregir: Usar el layout item_image en lugar de activity_detail
            val imageView = convertView as? android.widget.ImageView ?: LayoutInflater.from(context)
                .inflate(com.example.trabajo.R.layout.item_image, parent, false) as android.widget.ImageView

            imageView.setImageResource(images[position])
            return imageView
        }
    }
}