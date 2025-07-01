package klyuch.fastvote.app.di

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.request.CachePolicy
import klyuch.fastvote.app.di.modules.coreModule
import klyuch.fastvote.app.di.modules.homeModule
import klyuch.fastvote.app.di.modules.votesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                coreModule,
                votesModule,
                homeModule
            )
        }
    }

    override fun newImageLoader() = ImageLoader(this)
        .newBuilder()
        .diskCachePolicy(CachePolicy.DISABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .crossfade(true)
        .build()
}