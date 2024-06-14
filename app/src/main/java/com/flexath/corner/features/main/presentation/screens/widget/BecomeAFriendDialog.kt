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
import androidx.compose.material3.MaterialTheme
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
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.ui.theme.CustomFont
import com.flexath.corner.ui.theme.dimens
import com.flexath.corner.ui.theme.getAppColor
import com.flexath.corner.ui.theme.getTypography

@Composable
fun BecomeAFriendDialog(
    onDismiss: () -> Unit,
    onClickLearnMore: () -> Unit
) {
    val dimens = MaterialTheme.dimens

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
                .clip(RoundedCornerShape(dimens.mediumPadding3))
                .background(color = getAppColor(AppColors.COLOR_BACKGROUND), shape = RoundedCornerShape(dimens.mediumPadding3))
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
                        top.linkTo(parent.top, margin = dimens.mediumPadding5)
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
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(titleTextRef) {
                    top.linkTo(profileImageRef.bottom, margin = dimens.mediumPadding5)
                    start.linkTo(parent.start, margin = dimens.mediumPadding3)
                    end.linkTo(parent.end, margin = dimens.mediumPadding3)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = stringResource(R.string.lbl_join_our_new_membership),
                style = MaterialTheme.typography.bodyMedium,
                color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(descriptionTextRef) {
                    top.linkTo(titleTextRef.bottom, margin = dimens.mediumPadding5)
                    start.linkTo(parent.start, margin = dimens.mediumPadding3)
                    end.linkTo(parent.end, margin = dimens.mediumPadding3)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.constrainAs(dialogButtonsRef) {
                    top.linkTo(descriptionTextRef.bottom, margin = dimens.mediumPadding3)
                    bottom.linkTo(parent.bottom, margin = dimens.mediumPadding3)
                    end.linkTo(parent.end, margin = dimens.mediumPadding3)
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
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = getAppColor(AppColors.TEXT_COLOR_PRIMARY),
                        textAlign = TextAlign.Center,
                    )
                }

                Spacer(modifier = Modifier.width(dimens.smallPadding4))

                TextButton(
                    onClick = {
                        onClickLearnMore()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.lbl_learn_more),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = getAppColor(AppColors.COLOR_PRIMARY),
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