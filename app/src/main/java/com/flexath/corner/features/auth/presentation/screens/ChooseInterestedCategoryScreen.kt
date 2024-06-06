package com.flexath.corner.features.auth.presentation.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding1
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding3
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding2
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding5
import com.flexath.corner.core.presentation.screens.common.TopAppBarWithNavButtonAndTitle
import com.flexath.corner.features.auth.presentation.screens.model.Category
import com.flexath.corner.features.auth.presentation.screens.model.ChooseInterestedCategoryScreenConst
import com.flexath.corner.features.auth.presentation.screens.common.CustomFilledButton
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorBackground
import com.flexath.corner.ui.theme.colorOnPrimary
import com.flexath.corner.ui.theme.colorPrimary
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.strokeColor
import com.flexath.corner.ui.theme.textColorPrimary

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChooseInterestedCategoryScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onClickContinueButton: () -> Unit
) {
    val scrollState = rememberScrollState()
    val selectedCategoryList = remember {
        mutableStateListOf<Category>()
    }

    LaunchedEffect(key1 = selectedCategoryList.size) {
        Log.i("CategoryList","List: ${selectedCategoryList.toList()}")
    }

    Scaffold(
        topBar = {
            TopAppBarWithNavButtonAndTitle(
                modifier = Modifier.fillMaxWidth().background(colorBackground),
                title = stringResource(id = R.string.lbl_welcome_to_corner),
                onNavigateBack = {
                    onNavigateBack()
                }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 2.dp)
                    .background(colorBackground)
                    .padding(vertical = MediumPadding1),
                contentAlignment = Alignment.Center
            ) {
                CustomFilledButton(
                    text = stringResource(R.string.lbl_continue),
                    isEnabled = true,
                    onClick = {
                        onClickContinueButton()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MediumPadding5)
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        val topPadding = it.calculateTopPadding()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(topPadding + (topPadding/2)))
            
            Text(
                text = stringResource(R.string.lbl_what_are_you_interested_in),
                style = getTypography(CustomFont.Charter).headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = textColorPrimary
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = stringResource(R.string.lbl_choose_three_or_more),
                style = getTypography(CustomFont.Charter).bodyLarge,
                color = textColorPrimary
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            FlowRow(
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.Center
            ) {
                ChooseInterestedCategoryScreenConst.categoryList.forEachIndexed { _, category ->
                    var isSelected by remember {
                        mutableStateOf(false)
                    }
                    SuggestionChip(
                        onClick = {
                            isSelected = !isSelected
                            if(isSelected) {
                                selectedCategoryList.add(category)
                            } else {
                                selectedCategoryList.remove(category)
                            }
                        },
                        label = {
                            Text(
                                text = category.name,
                                style = getTypography(CustomFont.Charter).bodyLarge,
                                textAlign = TextAlign.Center,
                                color = if (isSelected) {
                                    colorOnPrimary
                                } else {
                                    textColorPrimary
                                },
                                maxLines = 1
                            )
                        },
                        border = BorderStroke(
                            width = 1.dp,
                            color = strokeColor
                        ),
                        colors = SuggestionChipDefaults.suggestionChipColors(
                            containerColor = if (isSelected) {
                                colorPrimary
                            } else {
                                Color.Transparent
                            },
                            labelColor = textColorPrimary,
                            disabledContainerColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(MediumPadding3),
                        modifier = Modifier.padding(horizontal = SmallPadding2)
                    )
                }
            }

            Spacer(modifier = modifier.height(bottomPadding + SmallPadding5))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ChooseInterestedCategoryScreenPreview() {
    ChooseInterestedCategoryScreen(
        modifier = Modifier.fillMaxSize(),
        onNavigateBack = {

        },
        onClickContinueButton = {

        }
    )
}