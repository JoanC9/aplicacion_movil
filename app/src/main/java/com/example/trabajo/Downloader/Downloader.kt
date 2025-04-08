package com.example.trabajo.Downloader

interface Downloader {
    fun descargarArchivo(url: String): Long
}