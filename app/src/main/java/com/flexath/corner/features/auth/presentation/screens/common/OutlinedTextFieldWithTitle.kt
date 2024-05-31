package com.flexath.corner.features.auth.presentation.screens.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargePadding4
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding1
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.alertColor
import com.flexath.corner.ui.theme.colorBackground
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimary
import com.flexath.corner.ui.theme.textColorSecondary
import com.flexath.corner.ui.theme.textFieldStrokeColor
import com.flexath.corner.ui.theme.textFieldUnFocusedBackground

@Composable
fun OutlinedTextFieldWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    query: String,
    onQueryChange: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = getTypography(CustomFont.Charter).bodyLarge,
            color = textColorPrimary,
            maxLines = 1,
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = textColorSecondary,
                    style = getTypography(CustomFont.Charter).bodyMedium,
                    maxLines = 1
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = textColorPrimary,
                unfocusedTextColor = textColorPrimary,
                cursorColor = textColorPrimary,
                errorCursorColor = alertColor,
                focusedContainerColor = colorBackground,
                unfocusedContainerColor = textFieldUnFocusedBackground,
                focusedBorderColor = textFieldStrokeColor,
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth().height(ExtraLargePadding4)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OutlinedTextFieldWithTitleWithTitle() {
    OutlinedTextFieldWithTitle(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MediumPadding5),
        title = "Your full name",
        placeholder = "Input your first name and last name",
        query = "",
        onQueryChange = {

        }
    )
}