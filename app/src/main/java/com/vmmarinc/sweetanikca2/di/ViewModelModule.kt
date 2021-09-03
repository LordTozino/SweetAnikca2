package com.vmmarinc.sweetanikca2.di

import com.vmmarinc.sweetanikca2.data.repositories.CommentRepository
import com.vmmarinc.sweetanikca2.ui.viewmodels.CommentViewModel
import com.vmmarinc.sweetanikca2.ui.viewmodels.HomeViewModel
import com.vmmarinc.sweetanikca2.ui.viewmodels.ProductViewModel
import com.vmmarinc.sweetanikca2.ui.viewmodels.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        CommentViewModel(get())
    }
    viewModel {
        ProductViewModel(get())
    }
    viewModel {
        SplashViewModel(get(),get(),get())
    }

}