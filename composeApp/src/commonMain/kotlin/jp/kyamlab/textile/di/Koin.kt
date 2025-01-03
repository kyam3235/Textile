package jp.kyamlab.textile.di

import jp.kyamlab.textile.screen.GreetingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dataModule = module {
    // TODO add data components like below
    /* single {
        MuseumRepository(get(), get()).apply {
            initialize()
        }
    } */
}

val viewModelModule = module {
    viewModelOf(::GreetingViewModel)
}