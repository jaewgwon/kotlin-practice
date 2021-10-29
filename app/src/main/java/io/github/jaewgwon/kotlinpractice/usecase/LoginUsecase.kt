package io.github.jaewgwon.kotlinpractice.usecase

import android.util.Log
import io.github.jaewgwon.kotlinpractice.model.User
import io.github.jaewgwon.kotlinpractice.repository.UserRepository
import io.github.jaewgwon.kotlinpractice.ui.dto.UserDto
import io.reactivex.rxjava3.subjects.BehaviorSubject

class LoginUsecase(private val userDto: UserDto, private val repository: UserRepository): BaseUsecase {
    private val result: BehaviorSubject<Any> = BehaviorSubject.create()

    override fun execute(): BehaviorSubject<Any> = loginProcess()

    private fun loginProcess(): BehaviorSubject<Any> {
        repository
            .find(userDto.userId)
            .subscribe(
                { validateUser(it as User) },
                { result.onError(Error(it.message)) }
            )
        return result
    }

    private fun validateUser(user: User) {
        if(user.password == userDto.password) result.onNext("STATUS_LOGIN_SUCCESS")
        else result.onError(Error("ERR_WRONG_PASSWORD"))
    }

}