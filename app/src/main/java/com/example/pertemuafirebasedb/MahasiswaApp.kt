package com.example.pertemuafirebasedb

import android.app.Application
import com.example.pertemuafirebasedb.di.MahasiswaContainer

class MahasiswaApp: Application(){
    lateinit var container: MahasiswaContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}