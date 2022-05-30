package com.example.testloginform.di


import com.example.testloginform.presentation.MainPresenter
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class])

interface AppComponent {

    fun injectPresenter(mainPresenter : MainPresenter)

}