package com.inq.cleanexample.data

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Источник данных. В нашем случае - это shared preferences
 * Можно накрыть его интерфейсом и предоставить несколько реализаций, которые будут подменяться
 *
 * В таком случае, нам надо будет отдать в boundary интерфейс, а реализацию той или иной имплементации интерфейса
 * предоставить в MainPresentationBoundary.Factory
 */
class UserDataPrefs @Inject constructor(
    private val prefs: SharedPreferences
) {
    fun getToken(): String = prefs.getString("user_token", "") ?: ""
}