package com.example.testloginform.app

import android.app.Application
import com.example.testloginform.di.AppComponent
import com.example.testloginform.di.DaggerAppComponent
import com.example.testloginform.di.DataModule

class App: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .dataModule(DataModule(this))
            .build()
    }
}