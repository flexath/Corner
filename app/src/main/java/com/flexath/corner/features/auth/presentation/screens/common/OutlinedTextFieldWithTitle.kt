package com.flexath.corner.features.auth.presentation.screens.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.dimens
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getTypography

@Composable
fun OutlinedTextFieldWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    query: String,
    onQueryChange: (String) -> Unit
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = getTypography(CustomFont.Charter).bodyLarge,
            color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
            maxLines = 1,
        )

        Spacer(modifier = Modifier.height(dimens.mediumPadding1))

        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = getAppColor(AppColors.TEXT_FIELD_STROKE_COLOR),
                    style = getTypography(CustomFont.Charter).bodyMedium,
                    maxLines = 1
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                unfocusedTextColor = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                cursorColor = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                errorCursorColor = getAppColor(AppColors.ALERT_COLOR),
                focusedContainerColor = getAppColor(AppColors.COLOR_BACKGROUND),
                unfocusedContainerColor = getAppColor(AppColors.TEXT_FIELD_UNFOCUSED_BACKGROUND),
                focusedBorderColor = getAppColor(AppColors.TEXT_FIELD_STROKE_COLOR),
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OutlinedTextFieldWithTitleWithTitle() {
    OutlinedTextFieldWithTitle(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.dimens.mediumPadding5),
        title = "Your full name",
        placeholder = "Input your first name and last name",
        query = "",
        onQueryChange = {

        }
    )
}