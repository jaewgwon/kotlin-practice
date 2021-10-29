package io.github.jaewgwon.kotlinpractice.repository

import io.github.jaewgwon.kotlinpractice.model.BaseEntity
import io.reactivex.rxjava3.core.Single

interface BaseRepository {
    fun find(primaryKey: Any): Single<BaseEntity>
    fun findAll(): List<BaseEntity>
    fun update(): Int
    fun delete(): Int
    fun create(): BaseEntity
}