package com.inq.cleanexample.domain.data

/**
 * Это так называемый интерфейс API, который абстрагирует модуль domain от всего остального мира,
 * предполагая, что реализацию этого API сделает разработчик, к которому он попал в руки
 *
 * Разработчик должен реализовать этот интерфейс и предоставить все необходимые ему данные
 */
interface UserDataSourceApi {
    fun readToken(): String
}