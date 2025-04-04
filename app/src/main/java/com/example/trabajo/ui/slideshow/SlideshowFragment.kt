package com.example.trabajo.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.trabajo.R

class SlideshowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)

        // Encontramos el WebView dentro del fragmento
        val webView: WebView = root.findViewById(R.id.video)

        // Código del video de YouTube
        val video = """
            <iframe width="100%" height="100%" 
            src="https://www.youtube.com/embed/PyCqsdykn8o?si=22U6VlzqS7jApJi7" 
            title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; 
            clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
            referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
        """.trimIndent()

        // Configuración del WebView
        webView.settings.javaScriptEnabled = true
        webView.settings.pluginState = WebSettings.PluginState.ON
        webView.webChromeClient = WebChromeClient()
        webView.loadData(video, "text/html", "utf-8")

        return root
    }
}
