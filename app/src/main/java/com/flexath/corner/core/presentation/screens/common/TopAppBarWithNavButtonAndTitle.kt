package com.flexath.corner.core.presentation.screens.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.flexath.corner.R
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithNavButtonAndTitle(
    modifier: Modifier = Modifier,
    title: String,
    onNavigateBack: () -> Unit
) {
    TopAppBar(
        title = {
            if(title.isNotBlank()) {
                Text(
                    text = title,
                    style = getTypography(CustomFont.Charter).titleSmall.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavigateBack()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.navigate_back),
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TopAppBarWithNavButtonAndTitlePreview() {
    TopAppBarWithNavButtonAndTitle(
        modifier = Modifier.fillMaxWidth(),
        title = "Welcome to Medium",
        onNavigateBack = {

        }
    )
}