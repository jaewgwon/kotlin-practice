package io.github.jaewgwon.kotlinpractice.usecase

import io.github.jaewgwon.kotlinpractice.model.BaseEntity
import io.github.jaewgwon.kotlinpractice.ui.dto.BaseDto
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

interface BaseUsecase {
    fun execute(): BehaviorSubject<Any>
}