package com.flexath.corner.features.auth.presentation.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargePadding5
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding2
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding5
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding6
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding1
import com.flexath.corner.core.presentation.screens.common.TopAppBarWithNavButtonAndTitle
import com.flexath.corner.features.auth.presentation.screens.common.CustomFilledButton
import com.flexath.corner.features.auth.presentation.screens.common.OutlinedTextFieldWithTitle
import com.flexath.corner.features.auth.presentation.screens.common.getAnnotatedStringForServiceTerms
import com.flexath.corner.features.auth.presentation.states.CreateAccountFormState
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimary

@OptIn(ExperimentalMaterial3Api::class)
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
                    .padding(horizontal = SmallPadding1),
                title = "",
                onNavigateBack = {
                    onNavigateBack()
                }
            )

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .constrainAs(appNameWithLogo) {
                        top.linkTo(topAppBarRef.bottom, margin = LargePadding5)
                        start.linkTo(parent.start, margin = MediumPadding5)
                        end.linkTo(parent.end, margin = MediumPadding5)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.corner),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(Dimens.SmallPadding2))

                Text(
                    text = stringResource(id = R.string.app_name),
                    style = getTypography(CustomFont.Charter).displaySmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = textColorPrimary,
                    modifier = Modifier.padding(top = Dimens.SmallPadding2)
                )
            }

            Text(
                text = stringResource(R.string.lbl_create_your_account),
                style = getTypography(CustomFont.Charter).headlineLarge.copy(
                    fontWeight = FontWeight.Normal
                ),
                color = textColorPrimary,
                modifier = Modifier.constrainAs(headlineTextRef) {
                    top.linkTo(appNameWithLogo.bottom, margin = LargePadding2)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            )

            OutlinedTextFieldWithTitle(
                modifier = Modifier.constrainAs(fullNameTextFieldWithTitleRef) {
                    top.linkTo(headlineTextRef.bottom, margin = LargePadding2)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
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
                    top.linkTo(fullNameTextFieldWithTitleRef.bottom, margin = LargePadding6)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
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
                    top.linkTo(emailTextFieldWithTitleRef.bottom, LargePadding6)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
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
                style = getTypography(CustomFont.Charter).bodyMedium,
                color = textColorPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(agreeTermsOfServiceRef) {
                    top.linkTo(createAccountButtonRef.bottom, margin = ExtraLargePadding5)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )
        }

        Spacer(modifier = Modifier.height(LargePadding2))
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