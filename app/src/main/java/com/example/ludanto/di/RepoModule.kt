package com.example.ludanto.di

import com.example.ludanto.data.repository.AuthRepositoryImpl
import com.example.ludanto.data.repository.MusicRepositoryImpl
import com.example.ludanto.domain.repository.AuthRepository
import com.example.ludanto.domain.repository.MusicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    @Singleton
    fun bindAuthRepository(impl: AuthRepositoryImpl) : AuthRepository

    @Binds
    @Singleton
    fun bindMusicRepository(impl: MusicRepositoryImpl) : MusicRepository
}