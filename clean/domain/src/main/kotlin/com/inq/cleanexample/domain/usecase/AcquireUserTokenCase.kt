package com.inq.cleanexample.domain.usecase

import com.inq.cleanexample.domain.data.UserDataSourceApi
import com.inq.cleanexample.entity.RandomizedUserTokenGenerator
import javax.inject.Inject

/**
 * Это классический domain представитель UseCase или Interactor - как угодно
 */
class AcquireUserTokenCase @Inject constructor(
    private val tokenGenerator: RandomizedUserTokenGenerator,
    private val userDataSourceApi: UserDataSourceApi
) {

    fun readToken(onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        var token = userDataSourceApi.readToken()
        if (token.isEmpty()) token = tokenGenerator.randomizeToken()
        if (token.isEmpty()) onFailure.invoke(NullPointerException("Token is empty"))
        else onSuccess.invoke(token)
    }

    class Factory {
        fun create(dataSourceImpl: UserDataSourceApi): AcquireUserTokenCase {
            return AcquireUserTokenCase(RandomizedUserTokenGenerator(), dataSourceImpl)
        }
    }
}