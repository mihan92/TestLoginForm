package com.example.testloginform.di

import com.example.testloginform.presentation.MainActivity
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class])

interface AppComponent {

    fun inject(mainActivity: MainActivity)
}