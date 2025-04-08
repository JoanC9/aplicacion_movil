package com.example.trabajo.Downloader
import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class AndroidDownloader(
    private val context: Context
): Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun descargarArchivo(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("application/pdf")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("Hoja_de_vida.pdf")
            //.addRequestHeader()
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Hoja_de_vida.pdf")

        return downloadManager.enqueue(request)
    }
}