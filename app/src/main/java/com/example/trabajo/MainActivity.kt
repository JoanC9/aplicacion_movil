package com.example.trabajo


import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.trabajo.Downloader.AndroidDownloader
import com.example.trabajo.databinding.ActivityMainBinding
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        var snackbar: Snackbar? = null;
        binding.appBarMain.fab.setOnClickListener { view ->

            if(snackbar?.isShown() == true){
                // Cerrar el snackbar si estaba abierto al hacer click en el boton
                snackbar?.dismiss()
            }else {
                snackbar = Snackbar.make(view, "Descargar hoja de vida? ", Snackbar.LENGTH_LONG)
                    .setDuration(10000)// Duración en milisegundos (10 segundos)
                    .setAction("Descargar") { descargarCV() }
                    .setAnchorView(R.id.fab)
                    snackbar?.setBackgroundTint(ContextCompat.getColor(this, R.color.teal_200))
                    snackbar?.setTextColor(ContextCompat.getColor(this, R.color.black))
                    snackbar?.setActionTextColor(ContextCompat.getColor(this, R.color.white))

                    snackbar?.addCallback(object: Snackbar.Callback(){
                        // Dar la apariencia por defecto al boton cuando se cierra el  snackbar
                        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                            super.onDismissed(transientBottomBar, event)

                            val newBackgrounColor = ContextCompat.getColor(this@MainActivity, R.color.teal_200)
                            view.backgroundTintList = ColorStateList.valueOf(newBackgrounColor)
                            binding.appBarMain.fab.setImageResource(R.drawable.file_download_outline)
                        }
                    })

                    snackbar?.show()

                    // Dar la apariencia de "cerrar" al boton cuando se abre el snackbar
                    val newBackgrounColor = "#f56464".toColorInt()
                    view.backgroundTintList = ColorStateList.valueOf(newBackgrounColor)
                    binding.appBarMain.fab.setImageResource(R.drawable.close)

            }
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_web
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun descargarCV(){
        Log.d("descargarCV", "Descargando CV");
        val downloader = AndroidDownloader(this)
        downloader.descargarArchivo("https://www.sbs.ox.ac.uk/sites/default/files/2019-01/cv-template.pdf")
    }
}
