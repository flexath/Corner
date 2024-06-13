package com.flexath.corner.features.auth.presentation.screens.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.flexath.corner.core.presentation.constants.Dimens
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getTypography

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
        contentPadding = PaddingValues(vertical = Dimens.SmallPadding4),
        colors = ButtonDefaults.buttonColors(
            containerColor = getAppColor(AppColors.COLOR_PRIMARY),
            disabledContainerColor = getAppColor(AppColors.TEXT_FIELD_UNFOCUSED_BACKGROUND),
        ),
        enabled = isEnabled,
        modifier = modifier

    ) {
        Text(
            text = text,
            style = getTypography(CustomFont.Charter).bodyMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = if (isEnabled) {
                getAppColor(AppColors.COLOR_ON_PRIMARY)
            } else {
                getAppColor(AppColors.TEXT_COLOR_PRIMARY)
            },
            maxLines = 1
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CustomFilledButtonPreview() {
    CustomFilledButton(
        modifier = Modifier.fillMaxWidth().padding(MediumPadding5),
        text = "Continue",
        isEnabled = true,
        onClick = {

        }
    )
}