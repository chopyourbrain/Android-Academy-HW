package ru.example.android_academy_hw

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ru.example.android_academy_hw.data.MovieRepository
import ru.example.android_academy_hw.presentation.fragment.MovieDetailsViewModel

class App : Application() {

    private val appModule = module {
        single { MovieRepository(context = get()) }
        viewModel { MovieDetailsViewModel(repo = get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}