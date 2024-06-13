package com.flexath.corner.features.main.presentation.screens.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import coil.compose.AsyncImage
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargePadding5
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargePadding5_2x
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding10
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding4
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding5
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding9
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding1
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding4
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding2
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding4
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding5
import com.flexath.corner.core.presentation.screens.extensions.shimmerEffect
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
    postList: List<PostVO>,
    isLoading: Boolean,
    onClickPost: () -> Unit
) {
    items(
        count = postList.size
    ) {
        PostShimmer(
            isLoading = isLoading,
            modifier = Modifier.fillMaxWidth()
        ) {
            Post(
                modifier = modifier,
                post = postList[it],
                onClickPost = {
                    onClickPost()
                }
            )
        }

        if (it != postList.lastIndex) {
            HorizontalDivider()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Post(
    modifier: Modifier = Modifier,
    post: PostVO,
    onClickPost: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .padding(all = MediumPadding5)
            .clickable {
                onClickPost()
            }
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

        AsyncImage(
            model = R.drawable.dummy_profile,
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

        AsyncImage(
            model = R.drawable.dummy_post_cover,
            contentDescription = "Post Cover Photo",
            contentScale = ContentScale.Fit,
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

@Composable
fun PostShimmer(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    content: @Composable () -> Unit
) {
    if (isLoading) {
        ConstraintLayout(
            modifier = modifier
                .padding(all = MediumPadding5)
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

            Box(
                modifier = Modifier
                    .constrainAs(profileImageRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        width = Dimension.value(24.dp)
                        height = Dimension.value(24.dp)
                    }
                    .clip(CircleShape)
                    .border(width = 0.3.dp, color = strokeColor, shape = CircleShape)
                    .shimmerEffect()
            )

            Box(
                modifier = Modifier
                    .constrainAs(authorNameTextRef) {
                        top.linkTo(profileImageRef.top)
                        bottom.linkTo(profileImageRef.bottom)
                        start.linkTo(profileImageRef.end, margin = SmallPadding4)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.value(MediumPadding4)
                    }
                    .shimmerEffect()
            )

            Box(
                modifier = Modifier
                    .constrainAs(titleTextRef) {
                        top.linkTo(profileImageRef.bottom, margin = MediumPadding5)
                        start.linkTo(parent.start)
                        end.linkTo(postImageRef.start, margin = SmallPadding4)
                        width = Dimension.fillToConstraints
                        height = Dimension.value(LargePadding4)
                    }
                    .shimmerEffect()
            )

            Box(
                modifier = Modifier
                    .constrainAs(postImageRef) {
                        top.linkTo(titleTextRef.top)
                        end.linkTo(parent.end)
                        width = Dimension.ratio("16:9")
                        height = Dimension.value(50.dp)
                    }
                    .shimmerEffect()
            )

            Box(
                modifier = Modifier
                    .constrainAs(descriptionTextRef) {
                        top.linkTo(titleTextRef.bottom, margin = SmallPadding5)
                        start.linkTo(parent.start)
                        end.linkTo(postImageRef.start, margin = SmallPadding4)
                        width = Dimension.fillToConstraints
                        height = Dimension.value(LargePadding9)
                    }
                    .shimmerEffect()
            )

            Row(
                modifier = Modifier
                    .constrainAs(startSectionRowRef) {
                        top.linkTo(descriptionTextRef.bottom, margin = MediumPadding5)
                        start.linkTo(parent.start)
                        width = Dimension.value(ExtraLargePadding5_2x)
                        height = Dimension.value(SmallPadding5)
                    }
                    .shimmerEffect(),
                verticalAlignment = Alignment.CenterVertically
            ) {

            }

            Row(
                modifier = Modifier
                    .constrainAs(endSectionRowRef) {
                        top.linkTo(startSectionRowRef.top)
                        bottom.linkTo(startSectionRowRef.bottom)
                        end.linkTo(parent.end)
                        width = Dimension.value(ExtraLargePadding5)
                        height = Dimension.value(SmallPadding5)
                    }
                    .shimmerEffect(),
                verticalAlignment = Alignment.CenterVertically
            ) {

            }
        }
    } else {
        content()
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
            postList = dummyPostList,
            isLoading = true,
            onClickPost = {

            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PostShimmerPreview() {
    PostShimmer(isLoading = true) {

    }
}
