package com.kd.dishi

import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.kd.dishi.curators.viewmodel.CuratorViewModel
import com.kd.dishi.home.viewmodel.HomeViewModel
import com.kd.dishi.recipes.viewmodel.RecipeViewModel

object AppVMProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel()
        }

        initializer {
            CuratorViewModel(
                this.createSavedStateHandle()
            )
        }

        initializer {
            RecipeViewModel(
                this.createSavedStateHandle()
            )
        }
    }
}