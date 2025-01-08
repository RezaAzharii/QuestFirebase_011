package com.example.pertemuafirebasedb.di

import com.example.pertemuafirebasedb.repository.NetworkRepositoryMhs
import com.example.pertemuafirebasedb.repository.RepositoryMhs
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer{
    val repositoryMhs: RepositoryMhs
}

class MahasiswaContainer: AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repositoryMhs: RepositoryMhs by lazy {
        NetworkRepositoryMhs(firestore)
    }
}