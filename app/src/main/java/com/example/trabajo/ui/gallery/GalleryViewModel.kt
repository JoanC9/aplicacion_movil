package com.example.trabajo.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trabajo.R

class GalleryViewModel : ViewModel() {
    val images = listOf(
        R.drawable.n1,
        R.drawable.n2,
        R.drawable.n3,
        R.drawable.n4,
    )
}