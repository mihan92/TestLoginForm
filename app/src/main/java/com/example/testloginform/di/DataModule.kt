package com.example.testloginform.di

import android.content.Context
import com.example.testloginform.data.storage.SharedPrefStorage
import com.example.testloginform.data.storage.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
class DataModule(private val context: Context) {

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideStorage(sharedPreferences: SharedPreferences): SharedPrefStorage {
        return sharedPreferences
    }

}