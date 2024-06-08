package com.flexath.corner.features.main.presentation.screens.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding1
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding2
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding4
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding5
import com.flexath.corner.features.main.data.remote.dto.dummy.PostVO
import com.flexath.corner.features.main.data.remote.dto.dummy.dummyPostList
import com.flexath.corner.features.main.presentation.utils.TimeFormatConverter
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorBackground
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.starColor
import com.flexath.corner.ui.theme.strokeColor
import com.flexath.corner.ui.theme.textColorPrimary

@RequiresApi(Build.VERSION_CODES.O)
fun LazyListScope.getPostList(
    modifier: Modifier,
    postList: List<PostVO>
) {
    items(
        count = postList.size
    ) {
        Post(
            modifier = modifier,
            post = postList[it]
        )

        if (it != postList.lastIndex) {
            HorizontalDivider()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Post(
    modifier: Modifier = Modifier,
    post: PostVO
) {
    ConstraintLayout(
        modifier = modifier.padding(all = MediumPadding5)
    ) {
        val (
            profileImageRef,
            authorNameTextRef,
            titleTextRef,
            descriptionTextRef,
            postImageRef,
            startSectionRowRef,
            endSectionRowRef
        ) = createRefs()

        val guideLine50 = createGuidelineFromStart(0.6f)

        Image(
            painter = painterResource(id = R.drawable.dummy_profile),
            contentDescription = "Author Profile Image",
            modifier = Modifier
                .constrainAs(profileImageRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(24.dp)
                    height = Dimension.value(24.dp)
                }
                .clip(CircleShape)
                .border(width = 0.3.dp, color = strokeColor, shape = CircleShape)
        )

        Text(
            text = post.authorName ?: "Author Name",
            style = getTypography(CustomFont.Inter).bodyMedium,
            color = textColorPrimary,
            modifier = Modifier.constrainAs(authorNameTextRef) {
                top.linkTo(profileImageRef.top)
                bottom.linkTo(profileImageRef.bottom)
                start.linkTo(profileImageRef.end, margin = SmallPadding4)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Text(
            text = post.title ?: "Post Title",
            style = getTypography(CustomFont.Inter).titleLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            color = textColorPrimary,
            modifier = Modifier.constrainAs(titleTextRef) {
                top.linkTo(profileImageRef.bottom, margin = MediumPadding5)
                start.linkTo(parent.start)
                end.linkTo(postImageRef.start, margin = SmallPadding4)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Image(
            painter = painterResource(id = R.drawable.dummy_post_cover),
            contentDescription = "Post Cover Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.constrainAs(postImageRef) {
                top.linkTo(titleTextRef.top)
                end.linkTo(parent.end)
                width = Dimension.ratio("16:9")
                height = Dimension.value(50.dp)
            }
        )

        Text(
            text = post.content ?: "Post Content",
            style = getTypography(CustomFont.Inter).bodyLarge,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            color = textColorPrimary,
            modifier = Modifier.constrainAs(descriptionTextRef) {
                top.linkTo(titleTextRef.bottom, margin = SmallPadding5)
                start.linkTo(parent.start)
                end.linkTo(postImageRef.start, margin = SmallPadding4)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        )

        Row(
            modifier = Modifier.constrainAs(startSectionRowRef) {
                top.linkTo(descriptionTextRef.bottom, margin = MediumPadding5)
                start.linkTo(parent.start)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "Compass Icon",
                tint = starColor
            )

            Spacer(modifier = Modifier.width(MediumPadding1))

            Text(
                text = TimeFormatConverter.formatMonthWithDay(post.createdDate),
                style = getTypography(CustomFont.Inter).bodyMedium,
                color = textColorPrimary
            )

            Spacer(modifier = Modifier.width(MediumPadding1))

            Icon(
                painter = painterResource(id = R.drawable.ic_hand),
                contentDescription = "Compass Icon"
            )

            Spacer(modifier = Modifier.width(SmallPadding2))

            Text(
                text = post.likeCount.toString()
            )
        }

        Row(
            modifier = Modifier.constrainAs(endSectionRowRef) {
                top.linkTo(startSectionRowRef.top)
                bottom.linkTo(startSectionRowRef.bottom)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_minus_circle),
                    contentDescription = "Minus with Outlined Icon"
                )
            }

            Spacer(modifier = Modifier.width(SmallPadding2))

            IconButton(onClick = {
                
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_three_dots),
                    contentDescription = "Minus with Outlined Icon"
                )
            }


        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GetPostListPreview() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorBackground)
    ) {
        getPostList(
            modifier = Modifier.fillMaxWidth(),
            postList = dummyPostList
        )
    }
}
