package org.example.greeting

import android.app.Application
import modules
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                appModule,
                modules
            )
        }
    }
}