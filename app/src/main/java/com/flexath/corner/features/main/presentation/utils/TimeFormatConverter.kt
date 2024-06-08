package com.flexath.corner.features.main.presentation.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

object TimeFormatConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    fun formatMonthWithDay(date: LocalDateTime?) : String {
        return "${date?.month?.name?.get(0)?.uppercase()}${date?.month?.name?.slice(IntRange(1,date.month?.name?.lastIndex ?: -1))?.lowercase()} ${date?.dayOfWeek?.value}"
    }
}