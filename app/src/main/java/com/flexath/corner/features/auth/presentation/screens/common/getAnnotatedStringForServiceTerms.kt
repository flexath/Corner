package com.flexath.corner.features.auth.presentation.screens.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.flexath.corner.R
import com.flexath.corner.ui.theme.textColorPrimary

@Composable
fun getAnnotatedStringForServiceTerms(modifier: Modifier = Modifier): AnnotatedString {
    return buildAnnotatedString {
        append("By signing up, you agree to our ")

        pushStringAnnotation(
            tag = "TERMS_OF_SERVICE",
            annotation = stringResource(R.string.lbl_terms_of_service)
        )
        withStyle(
            style = SpanStyle(
                color = textColorPrimary,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Terms of Service")
        }
        pop()

        append(" and acknowledge that our ")

        pushStringAnnotation(
            tag = "PRIVACY_POLICY",
            annotation = "Privacy Policy"
        )
        withStyle(
            style = SpanStyle(
                color = textColorPrimary,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Privacy Policy")
        }
        pop()

        append(" applies to you.")
    }
}