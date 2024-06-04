package com.flexath.corner.features.auth.presentation.screens.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.flexath.corner.core.presentation.constants.Dimens
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorOnPrimary
import com.flexath.corner.ui.theme.colorPrimary
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimary
import com.flexath.corner.ui.theme.textFieldUnFocusedBackground

@Composable
fun CustomFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true
) {
    Button(
        onClick = {
            onClick()
        },
        shape = ButtonDefaults.outlinedShape,
        contentPadding = PaddingValues(vertical = Dimens.MediumPadding3),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorPrimary,
            disabledContainerColor = textFieldUnFocusedBackground,
        ),
        enabled = isEnabled,
        modifier = modifier

    ) {
        Text(
            text = text,
            style = getTypography(CustomFont.Charter).bodyLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = if (isEnabled) {
                colorOnPrimary
            } else {
                textColorPrimary
            },
            maxLines = 1
        )
    }
}