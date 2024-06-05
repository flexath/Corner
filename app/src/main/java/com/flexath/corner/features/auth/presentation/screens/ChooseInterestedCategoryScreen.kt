package com.flexath.corner.features.auth.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding10
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding1
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding3
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding2
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding4
import com.flexath.corner.core.presentation.screens.common.TopAppBarWithNavButtonAndTitle
import com.flexath.corner.features.auth.presentation.constants.ChooseInterestedCategoryScreenConst
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

    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            topAppBarRef,
            scrollableColumnRef,
            continueButtonRef
        ) = createRefs()

        TopAppBarWithNavButtonAndTitle(
            modifier = Modifier
                .constrainAs(topAppBarRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(horizontal = Dimens.SmallPadding1),
            title = stringResource(id = R.string.lbl_welcome_to_corner),
            onNavigateBack = {
                onNavigateBack()
            }
        )

        Column(
            modifier = Modifier.constrainAs(scrollableColumnRef) {
                    top.linkTo(topAppBarRef.bottom, margin = LargePadding10)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                }.verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.lbl_what_are_you_interested_in),
                style = getTypography(CustomFont.Charter).titleLarge.copy(
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
                ChooseInterestedCategoryScreenConst.categoryList.forEachIndexed { index, category ->
                    var isSelected by remember {
                        mutableStateOf(false)
                    }
                    SuggestionChip(
                        onClick = {
                            isSelected = !isSelected
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
        }

        Box(
            modifier = Modifier
                .constrainAs(continueButtonRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                }
                .shadow(elevation = 2.dp)
                .background(colorBackground)
                .padding(vertical = MediumPadding1),
            contentAlignment = Alignment.Center
        ) {
            CustomFilledButton(
                text = stringResource(R.string.lbl_create_account),
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