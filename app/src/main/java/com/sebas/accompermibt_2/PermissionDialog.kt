package com.sebas.accompermibt_2

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PermissionDialog (
    permission : String,
    isPermanentlyDeclined: Boolean,
    onDismiss: () -> Unit,
    onOkClick: () -> Unit,
    onGoToAppSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {

AlertDialog(onDismissRequest = onDismiss,
    title = { Text(text ="Permiso Requerido"  ) },
    text = {  Text(text = permission) },
    confirmButton = {  if (isPermanentlyDeclined) { onGoToAppSettingsClick() } else {onOkClick()} })
}
