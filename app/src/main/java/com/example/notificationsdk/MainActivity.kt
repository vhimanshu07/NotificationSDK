package com.example.notificationsdk

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notificationhelpersdk.NotificationHelper
import com.example.notificationsdk.ui.theme.NotificationSDKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = CounterNotificationService(applicationContext)
        setContent {
            NotificationSDKTheme {
                Column(Modifier.fillMaxSize()) {
                    Button(onClick = {
                        service.showNotification(Counter.value)
                    }) {
                        Text("Show Notification")
                    }
                    val intent = Intent(applicationContext, SecondActivity::class.java)
                    Button(onClick = {
                        NotificationHelper.showNotification(
                            applicationContext,
                            "This is SDK notification",
                            "Open to check it",
                            intent,
                            2
                        )
                    }) {
                        Text("Show Notification using SDK")
                    }

                }
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
    NotificationSDKTheme {
        Greeting("Android")
    }
}