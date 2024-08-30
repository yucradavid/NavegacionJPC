package com.example.navegacionjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navegacionjpc.ui.presentation.components.MyAppDrawer
import com.example.navegacionjpc.ui.theme.LightColorScheme
import com.example.navegacionjpc.ui.theme.NavegacionJPCTheme
import com.example.navegacionjpc.ui.theme.ThemeType
import com.example.navegacionjpc.ui.theme.darkGreenScheme
import com.example.navegacionjpc.ui.theme.darkRedScheme
import com.example.navegacionjpc.ui.theme.lightGreenScheme
import com.example.navegacionjpc.ui.theme.lightRedScheme
import com.example.navegacionjpc.utils.conttexto
import com.example.navegacionjpc.utils.isNight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val themeType= remember{ mutableStateOf(ThemeType.RED) }
            val darkThemex= isNight()
            val darkTheme = remember { mutableStateOf(darkThemex)
            }
            val colorScheme=when(themeType.value){
                ThemeType.RED->{if (darkTheme.value) darkRedScheme else
                    lightRedScheme}
                ThemeType.GREEN->{if (darkTheme.value) darkGreenScheme else
                    lightGreenScheme}
                else->{lightGreenScheme}
            }
            conttexto.CONTEXTO_APPX=this
            NavegacionJPCTheme(colorScheme = colorScheme) {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/

                MyAppDrawer(darkMode =darkTheme , themeType = themeType)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavegacionJPCTheme(colorScheme = lightGreenScheme ) {
        Greeting("Android")
    }
}