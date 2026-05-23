package com.example.webapp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.webapp3.ui.Navigation
import com.example.webapp3.ui.theme.AppTheme
import com.example.webapp3.ui.viewmodel.SessionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val app = applicationContext as DemoData
            val sessionVm: SessionViewModel = viewModel(
                factory = SessionViewModel.Factory(app.sessionManager)
            )

            val isDarkModePref by sessionVm.isDarkMode.collectAsState()
            val darkTheme = isDarkModePref ?: isSystemInDarkTheme()

            AppTheme(darkTheme = darkTheme) {
                Navigation()
            }
        }
    }
}