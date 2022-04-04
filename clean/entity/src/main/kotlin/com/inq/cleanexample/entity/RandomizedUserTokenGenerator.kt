package com.inq.cleanexample.entity

import java.util.UUID

/**
 * Какой-то БЛ код, который может использовать кто угодно
 * Он не имеет никакого отношения к UseCase, он просто делает одну штуку, под которую заточен
 */
class RandomizedUserTokenGenerator {
    fun randomizeToken(): String = UUID.randomUUID().toString()
}