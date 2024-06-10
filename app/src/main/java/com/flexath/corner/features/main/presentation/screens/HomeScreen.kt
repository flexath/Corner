package com.flexath.corner.features.main.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding2
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding2
import com.flexath.corner.core.presentation.screens.extensions.isScrolled
import com.flexath.corner.features.main.data.remote.dto.dummy.dummyPostList
import com.flexath.corner.features.main.presentation.screens.common.getPostList
import com.flexath.corner.features.main.presentation.screens.widget.BecomeAFriendDialog
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorBackground
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimary

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    dialogIsShown: Boolean,
    onDismissDialog: () -> Unit,
    onClickLearnMoreDialog: () -> Unit,
    onClickPost: () -> Unit
) {
    val lazyListState = rememberLazyListState()

    if (dialogIsShown) {
        BecomeAFriendDialog(
            onDismiss = {
                onDismissDialog()
            },
            onClickLearnMore = {
                onClickLearnMoreDialog()
            }
        )
    }

    Scaffold(
        modifier = modifier.background(colorBackground),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(durationMillis = 300)
                    )
                    .background(color = colorBackground)
                    .height(
                        height = if (lazyListState.isScrolled()) 0.dp else 144.dp
                    )
                    .padding(bottom = LargePadding2),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.lbl_home),
                        style = getTypography(CustomFont.Inter).titleLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        textAlign = TextAlign.Center,
                        color = textColorPrimary,
                        modifier = Modifier.padding(start = MediumPadding5)
                    )

                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier.padding(end = SmallPadding2)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = "Notification Bell"
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        val topPadding = paddingValues.calculateTopPadding()

        val animatedPadding by animateDpAsState(
            targetValue = if (lazyListState.isScrolled()) 0.dp else 124.dp,
            label = "Padding",
            animationSpec = tween(durationMillis = 300)
        )

        var tabSelectedIndex by remember {
            mutableIntStateOf(0)
        }

        Column(
            modifier = Modifier.padding(top = topPadding)
        ) {

            CategoryScrollableTabRow(
                tabSelectedIndex = tabSelectedIndex,
                onTabSelect = {
                    tabSelectedIndex = it
                }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorBackground),
                state = lazyListState
            ) {
                getPostList(
                    modifier = Modifier.fillMaxWidth(),
                    postList = dummyPostList,
                    onClickPost = {
                        onClickPost()
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryScrollableTabRow(
    modifier: Modifier = Modifier,
    tabSelectedIndex: Int,
    onTabSelect: (Int) -> Unit
) {
    val textList = listOf(
        "Android",
        "Ios",
        "Flutter",
        "React Native",
        "Ionic",
        "Web Development",
        "Javascript",
        "PHP",
        "Leetcode"
    )

    ScrollableTabRow(
        edgePadding = 0.dp,
        selectedTabIndex = tabSelectedIndex,
        containerColor = colorBackground,
        contentColor = textColorPrimary,
        indicator = {
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(it[tabSelectedIndex])
                    .padding(horizontal = 20.dp)
                    .height(2.dp)
                    .background(color = textColorPrimary)
            )
        },
        modifier = modifier
    ) {
        textList.forEachIndexed { index, category ->
            Tab(
                selected = index == tabSelectedIndex,
                onClick = {
                    onTabSelect(index)
                },
                modifier = Modifier.padding(vertical = MediumPadding5)
            ) {
                Text(
                    text = category,
                    style = getTypography(CustomFont.Inter).bodyMedium.copy(
                        fontWeight = if (index == tabSelectedIndex) {
                            FontWeight.Medium
                        } else {
                            FontWeight.Light
                        }
                    ),
                    color = textColorPrimary
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier.fillMaxSize(),
        dialogIsShown = false,
        onDismissDialog = {

        },
        onClickLearnMoreDialog = {

        },
        onClickPost = {

        }
    )
}