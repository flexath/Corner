package com.flexath.corner.features.auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.flexath.corner.R
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.features.auth.presentation.screens.common.CustomFilledButton
import com.flexath.corner.features.auth.presentation.screens.model.WelcomeScreenConst.firstRowPeopleImageList
import com.flexath.corner.features.auth.presentation.screens.model.WelcomeScreenConst.secondRowPeopleImageList
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.dimens
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getFont
import com.flexath.corner.ui.theme.getTypography

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onClickContinueButton: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            welcomeToCornerTextRef,
            makeCornerYoursTextRef,
            letFindPeopleTextRef,
            horizontalLineRef,
            peopleImagesUpperRef,
            peopleImagesLowerRef,
            continueButtonRef
        ) = createRefs()

        Text(
            text = stringResource(R.string.lbl_welcome_to_corner),
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.ExtraBold,
                fontFamily = getFont(CustomFont.Charter)
            ),
            color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(welcomeToCornerTextRef) {
                top.linkTo(parent.top,margin = dimens.mediumPadding3)
                start.linkTo(parent.start,margin = dimens.mediumPadding5)
                end.linkTo(parent.end,margin = dimens.mediumPadding5)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        )

        Text(
            text = stringResource(R.string.lbl_make_corner_yours),
            style = getTypography(CustomFont.Noe).displayMedium.copy(
                fontWeight = FontWeight.SemiBold,
                lineHeight = 40.sp,
            ),
            color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(makeCornerYoursTextRef) {
                top.linkTo(welcomeToCornerTextRef.bottom,margin = dimens.doubleExtraLargePadding10)
                start.linkTo(parent.start,margin = dimens.mediumPadding5)
                end.linkTo(parent.end,margin = dimens.mediumPadding5)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        )

        Text(
            text = stringResource(R.string.lbl_let_s_find_people_to_follow_based_on_your_interests),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = getFont(CustomFont.Charter)
            ),
            color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(letFindPeopleTextRef) {
                top.linkTo(makeCornerYoursTextRef.bottom, margin = dimens.largePadding2)
                start.linkTo(parent.start, margin = dimens.mediumPadding5)
                end.linkTo(parent.end, margin = dimens.mediumPadding5)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        )

        HorizontalDivider(
            thickness = dimens.smallPadding0,
            color = getAppColor(AppColors.STROKE_COLOR),
            modifier = Modifier.constrainAs(horizontalLineRef) {
                top.linkTo(letFindPeopleTextRef.bottom, margin = dimens.largePadding2)
                start.linkTo(parent.start, margin = dimens.mediumPadding5)
                end.linkTo(parent.end, margin = dimens.mediumPadding5)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        LazyRow(
            modifier = Modifier.constrainAs(peopleImagesUpperRef) {
                top.linkTo(horizontalLineRef.bottom,margin = dimens.doubleExtraLargePadding10)
                start.linkTo(parent.start,margin = dimens.mediumPadding5)
                end.linkTo(parent.end,margin = dimens.mediumPadding5)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        ) {
            items(count = 1) {
                firstRowPeopleImageList.forEachIndexed { _, image ->
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "People's cover photos",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(horizontal = dimens.smallPadding4)
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(getAppColor(AppColors.TEXT_COLOR_SECONDARY))
                    )
                }
            }
        }

        LazyRow(
            modifier = Modifier.constrainAs(peopleImagesLowerRef) {
                top.linkTo(peopleImagesUpperRef.bottom,margin = dimens.largePadding2)
                start.linkTo(parent.start,margin = dimens.mediumPadding5)
                end.linkTo(parent.end,margin = dimens.mediumPadding5)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        ) {
            items(count = 1) {
                secondRowPeopleImageList.forEachIndexed { _, image ->
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "People's cover photos",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(horizontal = dimens.smallPadding4)
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(getAppColor(AppColors.TEXT_COLOR_SECONDARY))
                    )
                }
            }
        }

        CustomFilledButton(
            modifier = Modifier.constrainAs(continueButtonRef) {
                bottom.linkTo(parent.bottom, margin = dimens.largePadding2)
                start.linkTo(parent.start, margin = dimens.mediumPadding5)
                end.linkTo(parent.end, margin = dimens.mediumPadding5)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            },
            text = stringResource(R.string.lbl_continue),
            isEnabled = true,
            onClick = {
                onClickContinueButton()
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(
        modifier = Modifier.fillMaxSize(),
        onClickContinueButton = {

        }
    )
}