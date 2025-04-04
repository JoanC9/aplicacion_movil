package com.example.trabajo.ui.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.trabajo.R
import java.net.CookieManager

class WebFragment : Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_web, container, false)

        // Encuentra el WebView en el diseño
        val webView: WebView = root.findViewById(R.id.webView)

        // Habilita la ejecución de JavaScript (necesario para LinkedIn)
        webView.settings.javaScriptEnabled = true

        // Hace que el WebView abra los enlaces dentro de la app en lugar del navegador
        webView.webViewClient = WebViewClient()

        // Carga la página de LinkedIn
        webView.loadUrl("https://www.linkedin.com/in/joan-cruz-b3346a262/")
        

        return root
    }
}
