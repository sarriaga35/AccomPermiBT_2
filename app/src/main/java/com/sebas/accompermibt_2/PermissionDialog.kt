package com.sebas.accompermibt_2

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PermissionDialog (
    permission : String,
    isPermanentlyDeclined: Boolean,
    onDismiss: () -> Unit,
    onOkClick: () -> Unit,
    onGoToAppSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    AlertDialog(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = stringResource(R.string.permision),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()

            )
        },

        text = {
            Text(
                text = permission,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()

            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
//            if (isPermanentlyDeclined) {
//                onGoToAppSettingsClick()
//            } else {
//                onOkClick()
//            }
            TextButton(
                onClick = { onOkClick},
                elevation = ButtonDefaults.elevatedButtonElevation(2.dp)
            ) {
                Text(
                    text = stringResource(R.string.confirmation),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismiss },
                elevation = ButtonDefaults.elevatedButtonElevation(2.dp)
            ) {
                Text(
                    text = stringResource(R.string.dimiss),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    )
}
