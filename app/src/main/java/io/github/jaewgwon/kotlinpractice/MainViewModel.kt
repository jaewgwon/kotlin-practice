package io.github.jaewgwon.kotlinpractice

import androidx.lifecycle.ViewModel
import io.github.jaewgwon.kotlinpractice.repository.UserRepository
import io.github.jaewgwon.kotlinpractice.ui.dto.UserDto
import io.github.jaewgwon.kotlinpractice.usecase.LoginUsecase
import io.reactivex.rxjava3.subjects.BehaviorSubject

class MainViewModel: ViewModel() {
    private val userRepository: UserRepository = UserRepository()
    fun login(user: UserDto): BehaviorSubject<Any> {
        val usecase = LoginUsecase(user, userRepository)
        return usecase.execute() // Observable
    }
}