package com.flexath.corner.core.domain.usecases

import javax.inject.Inject

data class AppEntryUseCase @Inject constructor(
    val saveAppEntry: SaveAppEntryUseCase,
    val readAppEntry: ReadAppEntryUseCase
)