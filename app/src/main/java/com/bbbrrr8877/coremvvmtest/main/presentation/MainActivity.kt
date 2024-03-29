package com.bbbrrr8877.coremvvmtest.main.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import com.bbbrrr8877.coremvvmtest.R
import com.github.johnnysc.coremvvm.presentation.BackPress
import com.github.johnnysc.coremvvm.presentation.FragmentFactory
import com.github.johnnysc.coremvvm.sl.ProvideViewModel

class MainActivity : BackPress.Activity<MainViewModel>(), ProvideViewModel {

    private lateinit var fragmentFactory: FragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentFactory = BaseFragmentFactory(R.id.container, supportFragmentManager)

        viewModel = provideViewModel(MainViewModel::class.java, this)

        viewModel.observeNavigation(this) { navigationScreen ->
            fragmentFactory.fragment(navigationScreen)
        }

        val progress = findViewById<View>(R.id.progressLayout)

        viewModel.observeProgress(this) {visibility ->
            visibility.apply(progress)
        }
    }



    override fun <T : androidx.lifecycle.ViewModel> provideViewModel(
        clazz: Class<T>,
        owner: ViewModelStoreOwner
    ): T = (application as ProvideViewModel).provideViewModel(clazz, owner)

}