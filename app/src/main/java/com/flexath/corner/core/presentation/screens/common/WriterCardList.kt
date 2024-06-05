package com.flexath.corner.core.presentation.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.widthIn
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
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding1
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding3
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding2
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding3
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding4
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding5
import com.flexath.corner.features.auth.presentation.constants.Writer
import com.flexath.corner.features.auth.presentation.constants.WriterCardDummyList
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorOnPrimary
import com.flexath.corner.ui.theme.colorPrimary
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimary
import com.flexath.corner.ui.theme.textColorSecondary
import com.flexath.corner.ui.theme.textFieldStrokeColor
import com.flexath.corner.ui.theme.textFieldUnFocusedBackground

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
                .background(textColorSecondary)
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
                    textFieldStrokeColor
                } else {
                    Color.Transparent
                }
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowed) {
                    Color.Transparent
                } else {
                    textColorPrimary
                }
            ),
            modifier = Modifier.constrainAs(followButtonRef) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }.defaultMinSize(minHeight = 1.dp)
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
                    colorPrimary
                } else {
                    colorOnPrimary
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