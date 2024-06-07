package com.flexath.corner.core.presentation.screens.extensions

import androidx.compose.foundation.lazy.LazyListState

fun LazyListState.isScrolled(): Boolean {
    return firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0
}