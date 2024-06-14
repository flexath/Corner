package com.flexath.corner.features.auth.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargeText10
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.features.auth.presentation.screens.common.getAnnotatedStringForServiceTerms
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.dimens
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getFont
import com.flexath.corner.ui.theme.getTypography

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onClickGoogleSignUpButton: () -> Unit,
    onClickFacebookSignUpButton: () -> Unit,
    onClickEmailSignUpButton: () -> Unit
) {
    val scrollState = rememberScrollState()
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        ConstraintLayout(
            modifier = modifier.padding(vertical = dimens.largePadding5)
        ) {
            val (
                appNameWithLogo,
                headlineTextRef,
                descriptionTextRef,
                googleSignUpButtonRef,
                facebookSignUpButtonRef,
                emailSignUpButtonRef,
                alreadyHaveAnAccountTextRef,
                agreeTermsOfServiceRef
            ) = createRefs()

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .constrainAs(appNameWithLogo) {
                        top.linkTo(parent.top)
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

                Spacer(modifier = Modifier.width(dimens.smallPadding2))

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
                text = stringResource(R.string.lbl_unlock_wisdom_and_insight),
                style = getTypography(CustomFont.Noe).displayLarge.copy(
                    fontSize = ExtraLargeText10,
                    lineHeight = 70.sp,
                    fontWeight = FontWeight.Normal
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(headlineTextRef) {
                    top.linkTo(appNameWithLogo.bottom, margin = dimens.extraLargePadding7)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = stringResource(R.string.lbl_fuel_your_potential_with_community_knowledge),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = getFont(CustomFont.Charter)
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                maxLines = 1,
                modifier = Modifier.constrainAs(descriptionTextRef) {
                    top.linkTo(headlineTextRef.bottom, margin = dimens.largePadding2)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                }
            )

            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.constrainAs(googleSignUpButtonRef) {
                    top.linkTo(descriptionTextRef.bottom, margin = dimens.extraLargePadding2)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
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
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = getFont(CustomFont.Charter)
                    ),
                    color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
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
                    top.linkTo(googleSignUpButtonRef.bottom, margin = dimens.mediumPadding1)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
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
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = getFont(CustomFont.Charter)
                    ),
                    color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
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
                    top.linkTo(facebookSignUpButtonRef.bottom, margin = dimens.mediumPadding1)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.matchParent
                    height = Dimension.wrapContent
                },
                onClick = {
                    onClickEmailSignUpButton()
                }
            ) {
                Icon(
                    painter = if (isSystemInDarkTheme()) {
                        painterResource(id = R.drawable.ic_mail_logo_dark)
                    } else {
                        painterResource(id = R.drawable.ic_mail_logo)
                    },

                    contentDescription = "Google Logo",
                    tint = Color.Unspecified
                )

                Text(
                    text = stringResource(R.string.lbl_sign_up_with_email),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = getFont(CustomFont.Charter)
                    ),
                    color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.constrainAs(alreadyHaveAnAccountTextRef) {
                    top.linkTo(emailSignUpButtonRef.bottom, margin = dimens.largePadding10)
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            ) {
                Text(
                    text = "Already have an account?",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = getFont(CustomFont.Charter)
                    ),
                    color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.width(dimens.smallPadding2))

                Text(
                    text = "Sign in",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = getFont(CustomFont.Charter)
                    ),
                    color = getAppColor(AppColors.COLOR_PRIMARY),
                    maxLines = 1,
                    modifier = Modifier.clickable {

                    }
                )
            }

            Text(
                text = getAnnotatedStringForServiceTerms(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = getFont(CustomFont.Charter)
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(agreeTermsOfServiceRef) {
                    top.linkTo(
                        alreadyHaveAnAccountTextRef.bottom,
                        margin = dimens.doubleExtraLargePadding10
                    )
                    start.linkTo(parent.start, margin = dimens.mediumPadding5)
                    end.linkTo(parent.end, margin = dimens.mediumPadding5)
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