package com.flexath.corner.core.presentation.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding4
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding5
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.features.auth.presentation.screens.model.Writer
import com.flexath.corner.features.auth.presentation.screens.model.WriterCardDummyList
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorBackgroundDarkMode
import com.flexath.corner.ui.theme.colorBackgroundLightMode
import com.flexath.corner.ui.theme.colorPrimaryDarkMode
import com.flexath.corner.ui.theme.colorPrimaryLightMode
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimaryDarkMode
import com.flexath.corner.ui.theme.textColorPrimaryLightMode
import com.flexath.corner.ui.theme.textColorSecondaryLightMode

fun LazyListScope.writerCardList(
    modifier: Modifier,
    writerList: List<Writer>,
    onClickFollowButton: () -> Unit
) {
    items(
        count = writerList.size
    ) { index ->
        var isFollowed by remember {
            mutableStateOf(false)
        }

        WriterCard(
            modifier = modifier
                .padding(vertical = SmallPadding4, horizontal = MediumPadding5),
            writer = writerList[index],
            isFollowed = isFollowed,
            onClickFollowButton = {
                isFollowed = it
            }
        )
    }
}

@Composable
fun WriterCard(
    modifier: Modifier = Modifier,
    writer: Writer,
    isFollowed: Boolean,
    onClickFollowButton: (Boolean) -> Unit
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            coverImageRef,
            nameTextRef,
            descriptionTextRef,
            followButtonRef
        ) = createRefs()

        Image(
            painter = painterResource(id = writer.coverPhoto),
            contentDescription = "People's cover photos",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(coverImageRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(40.dp)
                    height = Dimension.value(40.dp)
                }
                .clip(CircleShape)
                .background(getAppColor(AppColors.TEXT_COLOR_SECONDARY))
        )

        Text(
            text = writer.name,
            style = getTypography(CustomFont.Charter).bodyLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.constrainAs(nameTextRef) {
                top.linkTo(parent.top)
                start.linkTo(coverImageRef.end, margin = SmallPadding5)
                end.linkTo(followButtonRef.start, margin = SmallPadding5)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Text(
            text = writer.description,
            style = getTypography(CustomFont.Charter).bodyMedium.copy(
                fontWeight = FontWeight.Normal
            ),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.constrainAs(descriptionTextRef) {
                top.linkTo(nameTextRef.bottom)
                start.linkTo(coverImageRef.end, margin = SmallPadding5)
                end.linkTo(followButtonRef.start, margin = SmallPadding5)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Button(
            onClick = {
                onClickFollowButton(!isFollowed)
            },
            shape = ButtonDefaults.outlinedShape,
            border = BorderStroke(
                width = 1.dp,
                color = if(isFollowed) {
                    getAppColor(AppColors.TEXT_FIELD_STROKE_COLOR)
                } else {
                    Color.Transparent
                }
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowed) {
                    if(!isSystemInDarkTheme()) {
                        Color.Transparent
                    } else {
                        Color.Transparent
                    }
                } else {
                    if(!isSystemInDarkTheme()) {
                        colorBackgroundDarkMode
                    } else {
                        colorBackgroundLightMode
                    }
                }
            ),
            modifier = Modifier
                .constrainAs(followButtonRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .defaultMinSize(minHeight = 1.dp)
        ) {
            Text(
                text = if (isFollowed) {
                    stringResource(R.string.lbl_following)
                } else {
                    stringResource(id = R.string.lbl_follow)
                },
                style = getTypography(CustomFont.Charter).bodyMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = if (isFollowed) {
                    if(!isSystemInDarkTheme()) {
                        colorPrimaryLightMode
                    } else {
                        colorPrimaryDarkMode
                    }
                } else {
                    if(!isSystemInDarkTheme()) {
                        textColorPrimaryDarkMode
                    } else {
                        textColorPrimaryLightMode
                    }
                },
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WriterCardListPreview() {
    LazyColumn {
        writerCardList(
            modifier = Modifier.fillMaxWidth(),
            writerList = WriterCardDummyList.writerList,
            onClickFollowButton = {

            }
        )
    }
}