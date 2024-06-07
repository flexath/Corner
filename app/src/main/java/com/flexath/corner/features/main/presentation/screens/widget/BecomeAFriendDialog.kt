package com.flexath.corner.features.main.presentation.screens.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding3
import com.flexath.corner.core.presentation.constants.Dimens.MediumPadding5
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding4
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.colorBackground
import com.flexath.corner.ui.theme.colorPrimary
import com.flexath.corner.ui.theme.getTypography
import com.flexath.corner.ui.theme.textColorPrimary

@Composable
fun BecomeAFriendDialog(
    onDismiss: () -> Unit,
    onClickLearnMore: () -> Unit
) {
    Dialog(
        onDismissRequest = {

        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(MediumPadding3))
                .background(color = colorBackground, shape = RoundedCornerShape(MediumPadding3))
        ) {
            val (
                profileImageRef,
                titleTextRef,
                descriptionTextRef,
                dialogButtonsRef
            ) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.dummy_profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .constrainAs(profileImageRef) {
                        top.linkTo(parent.top, margin = MediumPadding5)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.value(80.dp)
                        height = Dimension.value(80.dp)
                    }
                    .clip(CircleShape)
                    .border(width = 1.dp, color = Color.White, CircleShape)
            )

            Text(
                text = stringResource(R.string.lbl_become_a_friend_of_corner),
                style = getTypography(CustomFont.Inter).bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = textColorPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(titleTextRef) {
                    top.linkTo(profileImageRef.bottom, margin = MediumPadding5)
                    start.linkTo(parent.start, margin = MediumPadding3)
                    end.linkTo(parent.end, margin = MediumPadding3)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = stringResource(R.string.lbl_join_our_new_membership),
                style = getTypography(CustomFont.Inter).bodyMedium,
                color = textColorPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(descriptionTextRef) {
                    top.linkTo(titleTextRef.bottom, margin = MediumPadding5)
                    start.linkTo(parent.start, margin = MediumPadding3)
                    end.linkTo(parent.end, margin = MediumPadding3)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.constrainAs(dialogButtonsRef) {
                    top.linkTo(descriptionTextRef.bottom, margin = MediumPadding3)
                    bottom.linkTo(parent.bottom, margin = MediumPadding3)
                    end.linkTo(parent.end, margin = MediumPadding3)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            ) {
                TextButton(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.lbl_maybe_later),
                        style = getTypography(CustomFont.Inter).bodyMedium.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = textColorPrimary,
                        textAlign = TextAlign.Center,
                    )
                }

                Spacer(modifier = Modifier.width(SmallPadding4))

                TextButton(
                    onClick = {
                        onClickLearnMore()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.lbl_learn_more),
                        style = getTypography(CustomFont.Inter).bodyMedium.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = colorPrimary,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BecomeAFriendDialogPreview() {
    BecomeAFriendDialog(
        onDismiss = {

        },
        onClickLearnMore = {

        }
    )
}