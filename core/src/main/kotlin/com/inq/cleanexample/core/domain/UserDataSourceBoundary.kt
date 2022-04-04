package com.inq.cleanexample.core.domain

import com.inq.cleanexample.data.UserDataPrefs
import com.inq.cleanexample.domain.data.UserDataSourceApi
import javax.inject.Inject

/**
 * Это boundary, которая направлена в сторону data-слоя
 * Она реализует [UserDataSourceApi], который объявлен в domain слое
 */
class UserDataSourceBoundary @Inject constructor(
    private val source: UserDataPrefs
) : UserDataSourceApi {

    /**
     * Аналогично другой boundary [MainPresentationBoundary]
     * этот метод может получить данные (в нашем случае токен) из любого источника данных, какой мы ни передадим сюда
     * обработать его (например, проверить, очистить, конверитровать в требуемую модель для domain-слоя)
     * и отдать в domain-слой
     */
    override fun readToken(): String = source.getToken()
}