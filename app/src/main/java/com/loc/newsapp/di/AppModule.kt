package com.loc.newsapp.di

import javax.inject.Singleton

import android.app.Application

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.loc.newsapp.data.manager.LocalUserManagerImpl
import com.loc.newsapp.domain.manager.LocalUserManager

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)
}
