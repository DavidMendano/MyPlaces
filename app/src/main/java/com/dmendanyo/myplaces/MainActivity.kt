package com.dmendanyo.myplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.dmendanyo.myplaces.commons.LoaderComponent
import com.dmendanyo.myplaces.extensions.subscribeLoader
import com.dmendanyo.myplaces.main.MainScreen
import com.dmendanyo.myplaces.ui.theme.MyPlacesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowLoader = mutableStateOf(true)
        lifecycleScope.subscribeLoader { shouldShowLoader.value = it }
        setContent {
            MyPlacesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val showLoader by remember { shouldShowLoader }
                    Box {
                        MainScreen()
                        if (showLoader) {
                            LoaderComponent()
                        }
                    }
                }
            }
        }
    }
}
