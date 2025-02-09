package com.packt.whatspackt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.packt.whatspackt.ui.navigation.MainNavigation
import com.packt.whatspackt.ui.theme.WhatsPacktTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsPacktTheme {
                val navHostController = rememberNavController()
                MainNavigation(navHostController)
            }
        }
    }
}
