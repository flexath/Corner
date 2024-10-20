package com.flexath.corner.features.auth.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.flexath.corner.R
import com.flexath.corner.core.presentation.screens.common.TopAppBarWithNavButtonAndTitle
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.features.auth.presentation.screens.common.CustomFilledButton
import com.flexath.corner.features.auth.presentation.screens.common.OutlinedTextFieldWithTitle
import com.flexath.corner.features.auth.presentation.screens.common.getAnnotatedStringForServiceTerms
import com.flexath.corner.features.auth.presentation.states.CreateAccountFormState
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.dimens
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getFont

@Composable
fun CreateAccountScreen(
    modifier: Modifier = Modifier,
    createAccountFormState: CreateAccountFormState,
    onNavigateBack: () -> Unit,
    onClickCreateAccountButton: () -> Unit,
    onFullNameChanged: (query: String) -> Unit,
    onEmailChanged: (query: String) -> Unit
) {
    val scrollState = rememberScrollState()
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        ConstraintLayout(
            modifier = modifier
        ) {
            val (
                topAppBarRef,
                appNameWithLogo,
                headlineTextRef,
                fullNameTextFieldWithTitleRef,
                emailTextFieldWithTitleRef,
                createAccountButtonRef,
                agreeTermsOfServiceRef
            ) = createRefs()

            TopAppBarWithNavButtonAndTitle(
                modifier = Modifier
                    .constrainAs(topAppBarRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .padding(horizontal = dimens.smallPadding1),
                title = "",
                onNavigateBack = {
                    onNavigateBack()
                }
            )

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .constrainAs(appNameWithLogo) {
                        top.linkTo(topAppBarRef.bottom, margin = dimens.largePadding5)
                        start.linkTo(parent.start, margin = dimens.mediumPadding5)
                        end.linkTo(parent.end, margin = dimens.mediumPadding5)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = R.drawable.logo,
                    contentDescription = "App Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(dimens.smallPadding4))

                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = getFont(CustomFont.Charter)
                    ),
                    color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                    modifier = Modifier.padding(top = dimens.smallPadding2)
                )
            }

            Text(
                text = stringResource(R.string.lbl_create_your_account),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Normal,
                    fontFamily = getFont(CustomFont.Charter)
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                modifier = Modifier.constrainAs(headlineTextRef) {
                    top.linkTo(appNameWithLogo.bottom, margin = dimens.largePadding2)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            )

            OutlinedTextFieldWithTitle(
                modifier = Modifier.constrainAs(fullNameTextFieldWithTitleRef) {
                    top.linkTo(headlineTextRef.bottom, margin = dimens.largePadding2)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                },
                title = stringResource(R.string.lbl_your_full_name),
                placeholder = stringResource(R.string.lbl_input_your_first_name_and_last_name),
                query = createAccountFormState.fullName,
                onQueryChange = {
                    onFullNameChanged(it)
                }
            )

            OutlinedTextFieldWithTitle(
                modifier = Modifier.constrainAs(emailTextFieldWithTitleRef) {
                    top.linkTo(fullNameTextFieldWithTitleRef.bottom, margin = dimens.largePadding6)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                },
                title = stringResource(R.string.lbl_your_email),
                placeholder = stringResource(R.string.lbl_flexath11_gmail_com),
                query = createAccountFormState.email,
                onQueryChange = {
                    onEmailChanged(it)
                }
            )

            CustomFilledButton(
                modifier = Modifier.constrainAs(createAccountButtonRef) {
                    top.linkTo(emailTextFieldWithTitleRef.bottom, dimens.largePadding6)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                },
                text = stringResource(R.string.lbl_create_account),
                isEnabled = true,
                onClick = {
                    onClickCreateAccountButton()
                }
            )

            Text(
                text = getAnnotatedStringForServiceTerms(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = getFont(CustomFont.Charter)
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(agreeTermsOfServiceRef) {
                    top.linkTo(createAccountButtonRef.bottom, margin = dimens.extraLargePadding5)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )
        }

        Spacer(modifier = Modifier.height(dimens.largePadding2))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CreateAccountScreenPreview() {
    CreateAccountScreen(
        modifier = Modifier.fillMaxSize(),
        createAccountFormState = CreateAccountFormState(),
        onNavigateBack = {

        },
        onClickCreateAccountButton = {

        },
        onFullNameChanged = {

        },
        onEmailChanged = {

        }
    )
}