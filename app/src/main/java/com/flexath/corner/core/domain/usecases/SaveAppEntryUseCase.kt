package com.flexath.corner.core.domain.usecases

import com.flexath.corner.core.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntryUseCase @Inject constructor(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}