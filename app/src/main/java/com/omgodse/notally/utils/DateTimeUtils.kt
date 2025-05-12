package com.omgodse.notally.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

object DateTimeUtils {
    // 单例的格式化器（线程安全）
    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年M月d日EEEEHH:mm:ss")

    // 获取当前格式化时间（全局调用）
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentFormattedTime(date: Date): String {
        val localDateTime = date.toInstant()
            //.atZone(ZoneId.of("Asia/Shanghai"))
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
        return localDateTime.format(formatter)
    }
}