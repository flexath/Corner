package com.flexath.corner.features.auth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding5
import com.flexath.corner.core.presentation.screens.common.TopAppBarWithNavButtonAndTitle
import com.flexath.corner.core.presentation.screens.common.writerCardList
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.features.auth.presentation.screens.common.CustomFilledButton
import com.flexath.corner.features.auth.presentation.screens.model.WriterCardDummyList
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getTypography

@Composable
fun RecommendedForYouScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onClickFinishButton: () -> Unit
) {

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
                    .padding(vertical = Dimens.MediumPadding1),
                contentAlignment = Alignment.Center
            ) {
                CustomFilledButton(
                    text = stringResource(R.string.lbl_finish),
                    isEnabled = true,
                    onClick = {
                        onClickFinishButton()
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
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Spacer(modifier = modifier.height(topPadding + (topPadding/2)))

                    Text(
                        text = stringResource(R.string.lbl_recommended_for_you),
                        style = getTypography(CustomFont.Charter).headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = getAppColor(AppColors.TEXT_COLOR_PRIMARY)
                    )

                    Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

                    Text(
                        text = stringResource(R.string.lbl_here_are_some_top_writers_based_on_your_interests),
                        style = getTypography(CustomFont.Charter).bodyLarge,
                        textAlign = TextAlign.Center,
                        color = getAppColor(AppColors.TEXT_COLOR_PRIMARY)
                    )

                    Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

                    HorizontalDivider(
                        thickness = Dimens.SmallPadding0,
                        color = getAppColor(AppColors.STROKE_COLOR),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = MediumPadding5)
                    )
                }

                writerCardList(
                    modifier = Modifier.fillMaxWidth(),
                    writerList = WriterCardDummyList.writerList,
                    onClickFollowButton = {

                    }
                )

                item {
                    Spacer(modifier = modifier.height(bottomPadding + SmallPadding5))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RecommendedForYouScreenPreview() {
    RecommendedForYouScreen(
        modifier = Modifier.fillMaxSize(),
        onNavigateBack = {

        },
        onClickFinishButton = {

        }
    )
}