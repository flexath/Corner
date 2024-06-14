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
import androidx.compose.material3.MaterialTheme
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
import com.flexath.corner.core.presentation.screens.common.TopAppBarWithNavButtonAndTitle
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.features.auth.presentation.screens.common.CustomFilledButton
import com.flexath.corner.features.auth.presentation.screens.model.Category
import com.flexath.corner.features.auth.presentation.screens.model.ChooseInterestedCategoryScreenConst
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.dimens
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getFont

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

    val dimens = MaterialTheme.dimens

    LaunchedEffect(key1 = selectedCategoryList.size) {
        Log.i("CategoryList","List: ${selectedCategoryList.toList()}")
    }

    Scaffold(
        topBar = {
            TopAppBarWithNavButtonAndTitle(
                modifier = Modifier.fillMaxWidth().background(getAppColor(AppColors.COLOR_BACKGROUND)),
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
                    .background(getAppColor(AppColors.COLOR_BACKGROUND))
                    .padding(vertical = dimens.mediumPadding1),
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
                        .padding(horizontal = dimens.mediumPadding5)
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
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = getFont(CustomFont.Charter)
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY)
            )

            Spacer(modifier = Modifier.height(dimens.mediumPadding1))

            Text(
                text = stringResource(R.string.lbl_choose_three_or_more),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = getFont(CustomFont.Charter)
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY)
            )

            Spacer(modifier = Modifier.height(dimens.mediumPadding1))

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
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontFamily = getFont(CustomFont.Charter)
                                ),
                                textAlign = TextAlign.Center,
                                color = if (isSelected) {
                                    getAppColor(AppColors.COLOR_ON_PRIMARY)
                                } else {
                                    getAppColor(AppColors.TEXT_COLOR_PRIMARY)
                                },
                                maxLines = 1
                            )
                        },
                        border = BorderStroke(
                            width = 1.dp,
                            color = getAppColor(AppColors.STROKE_COLOR)
                        ),
                        colors = SuggestionChipDefaults.suggestionChipColors(
                            containerColor = if (isSelected) {
                                getAppColor(AppColors.COLOR_PRIMARY)
                            } else {
                                Color.Transparent
                            },
                            labelColor = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                            disabledContainerColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(dimens.mediumPadding3),
                        modifier = Modifier.padding(horizontal = dimens.smallPadding2)
                    )
                }
            }

            Spacer(modifier = modifier.height(bottomPadding + dimens.smallPadding5))
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