package com.flexath.corner.features.auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.DoubleExtraLargePadding10
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargePadding2
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargePadding7
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargeText10
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding10
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding2
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding5
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding1
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding2
import com.flexath.corner.features.auth.presentation.screens.common.getAnnotatedStringForServiceTerms
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorPrimary
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimary

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onClickGoogleSignUpButton: () -> Unit,
    onClickFacebookSignUpButton: () -> Unit,
    onClickEmailSignUpButton: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        ConstraintLayout(
            modifier = modifier.padding(vertical = LargePadding5)
        ) {
            val (
                appNameWithLogo,
                headlineTextRef,
                descriptionTextRef,
                googleSignUpButtonRef,
                facebookSignUpButtonRef,
                emailSignUpButtonRef,
                alreadyHaveAnAccountRef,
                agreeTermsOfServiceRef
            ) = createRefs()

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .constrainAs(appNameWithLogo) {
                        top.linkTo(parent.top)
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

                Spacer(modifier = Modifier.width(SmallPadding2))

                Text(
                    text = stringResource(id = R.string.app_name),
                    style = getTypography(CustomFont.Charter).displaySmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = textColorPrimary,
                    modifier = Modifier.padding(top = SmallPadding2)
                )
            }

            Text(
                text = stringResource(R.string.lbl_unlock_wisdom_and_insight),
                style = getTypography(CustomFont.Noe).displayLarge.copy(
                    fontSize = ExtraLargeText10,
                    lineHeight = 70.sp,
                    fontWeight = FontWeight.Normal
                ),
                color = textColorPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(headlineTextRef) {
                    top.linkTo(appNameWithLogo.bottom, margin = ExtraLargePadding7)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = stringResource(R.string.lbl_fuel_your_potential_with_community_knowledge),
                style = getTypography(CustomFont.Charter).bodyLarge,
                color = textColorPrimary,
                maxLines = 1,
                modifier = Modifier.constrainAs(descriptionTextRef) {
                    top.linkTo(headlineTextRef.bottom, margin = LargePadding2)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                }
            )

            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.constrainAs(googleSignUpButtonRef) {
                    top.linkTo(descriptionTextRef.bottom, margin = ExtraLargePadding2)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                },
                onClick = {
                    onClickGoogleSignUpButton()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google_logo),
                    contentDescription = "Google Logo",
                    tint = Color.Unspecified
                )

                Text(
                    text = stringResource(R.string.lbl_sign_up_with_google),
                    style = getTypography(CustomFont.Charter).bodyLarge,
                    color = textColorPrimary,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
            }

            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.constrainAs(facebookSignUpButtonRef) {
                    top.linkTo(googleSignUpButtonRef.bottom, margin = MediumPadding1)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                },
                onClick = {
                    onClickFacebookSignUpButton()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_facebook_logo),
                    contentDescription = "Google Logo",
                    tint = Color.Unspecified
                )

                Text(
                    text = stringResource(R.string.lbl_sign_up_with_facebook),
                    style = getTypography(CustomFont.Charter).bodyLarge,
                    color = textColorPrimary,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
            }

            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.constrainAs(emailSignUpButtonRef) {
                    top.linkTo(facebookSignUpButtonRef.bottom, margin = MediumPadding1)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                },
                onClick = {
                    onClickEmailSignUpButton()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_mail_logo),
                    contentDescription = "Google Logo",
                    tint = Color.Unspecified
                )

                Text(
                    text = stringResource(R.string.lbl_sign_up_with_email),
                    style = getTypography(CustomFont.Charter).bodyLarge,
                    color = textColorPrimary,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.constrainAs(alreadyHaveAnAccountRef) {
                    top.linkTo(emailSignUpButtonRef.bottom, margin = LargePadding10)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            ) {
                Text(
                    text = "Already have an account?",
                    style = getTypography(CustomFont.Charter).bodyLarge,
                    color = textColorPrimary,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.width(SmallPadding2))

                Text(
                    text = "Sign in",
                    style = getTypography(CustomFont.Charter).bodyLarge,
                    color = colorPrimary,
                    maxLines = 1,
                    modifier = Modifier.clickable {

                    }
                )
            }

            Text(
                text = getAnnotatedStringForServiceTerms(),
                style = getTypography(CustomFont.Charter).bodyMedium,
                color = textColorPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(agreeTermsOfServiceRef) {
                    top.linkTo(alreadyHaveAnAccountRef.bottom, margin = DoubleExtraLargePadding10)
                    start.linkTo(parent.start, margin = MediumPadding5)
                    end.linkTo(parent.end, margin = MediumPadding5)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        modifier = Modifier.fillMaxSize(),
        onClickGoogleSignUpButton = {

        },
        onClickFacebookSignUpButton = {

        },
        onClickEmailSignUpButton = {

        }
    )
}