package com.inq.cleanexample.core.domain

import android.content.Context
import com.inq.cleanexample.data.UserDataPrefs
import com.inq.cleanexample.domain.usecase.AcquireUserTokenCase

/**
 * Это граница, через которую получает данные MainActivity (presentation)
 */
class MainPresentationBoundary constructor(
    private val userTokenCase: AcquireUserTokenCase
) {
    /**
     * Метод boundary, который вызывает MainPresenter (presentation)
     * KFunction - это некоторый "общий" код, который позволяет реализовать механизм колбеков.
     * Таким механизмом может выступать также
     * - rx
     * - стандартные [java.util.Observable] + [java.util.Observer]
     * - какие-нибудь [java.util.concurrent.Future] и прочее
     *
     * В этом же классе производится маппинг данных в тип, который хотел бы получить presentation-слой
     */
    fun acquireUserToken(onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        userTokenCase.readToken(onSuccess, onFailure)
    }

    /**
     * Так выглядел бы код без DI :)
     */
    class Factory {
        fun create(ctx: Context): MainPresentationBoundary {
            return MainPresentationBoundary(
                AcquireUserTokenCase.Factory().create(
                    UserDataSourceBoundary(
                        UserDataPrefs(
                            ctx.getSharedPreferences("user_data_prefs", Context.MODE_PRIVATE)
                        )
                    )
                )
            )
        }
    }
}
