package com.sebas.accompermibt_2

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.sebas.accompermibt_2.ui.theme.AccomPermiBT_2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AccomPermiBT_2Theme {
                val versionSDK30 = listOf(android.Manifest.permission.BLUETOOTH)
                val versionSDK31 = listOf(android.Manifest.permission.BLUETOOTH_CONNECT, android.Manifest.permission.BLUETOOTH_SCAN)
                val multiplePermissionsState = rememberMultiplePermissionsState(
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) versionSDK31 else versionSDK30
                )
                Sample(multiplePermissionsState)
                }
            }
        }
    }
@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun Sample(multiplePermissionsState: MultiplePermissionsState) {
    if (multiplePermissionsState.allPermissionsGranted) {
        // If all permissions are granted, then show screen with the feature enabled
        Text("BT permissions Granted! Thank you!")
    } else {
        PermissionDialog(
            permission =if (isPermanentlyDeclined) {
                "Al parecer ud declino el permiso del Bluetooth, permanentemente " +
                        "Ud. puede ir a la configuracion del telefono y otorgar el permiso."
            } else {
                "Esta app requiere el Bluetooth para comunicarse con el vehiculo "
            }
                    isPermanentlyDeclined =!shouldShowRequestPermissionRationale(
                Manifest.permission.CAMERA
            ),
            onDismiss = {/*viewModel::dismissDialog*/},
            onOkClick = {/*  viewModel.dismissDialog()*/
            },
            onGoToAppSettingsClick = ::openAppSettings
        )
    }
}



fun Activity.openAppSettings() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    ).also(::startActivity)
}



//        Column {
//
//            Spacer(modifier = Modifier.height(8.dp))
//            Button(onClick = { multiplePermissionsState.launchMultiplePermissionRequest() }) {
//                Text("Request permissions")
//            }
