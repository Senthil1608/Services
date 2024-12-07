package com.example.servicesapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ServiceControls(
    onStartBasicService: () -> Unit,
    onStartForegroundService: () -> Unit,
    onBindBoundService: () -> Unit,
    onSendAidlData: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = onStartBasicService) {
            Text("Start Basic Service")
        }
        Button(onClick = onStartForegroundService) {
            Text("Start Foreground Service")
        }
        Button(onClick = onBindBoundService) {
            Text("Bind to Bound Service")
        }
        Button(onClick = onSendAidlData) {
            Text("Send Data via AIDL")
        }
    }
}