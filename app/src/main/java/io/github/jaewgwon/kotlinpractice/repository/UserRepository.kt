package io.github.jaewgwon.kotlinpractice.repository

import io.github.jaewgwon.kotlinpractice.model.BaseEntity
import io.github.jaewgwon.kotlinpractice.model.User
import io.reactivex.rxjava3.core.Single

class UserRepository: BaseRepository {
    override fun find(userId: Any): Single<BaseEntity> {
        if (userId == "test") { // guard if
            return Single.create {
                it.onSuccess(
                    User(
                    "test",
                    "test",
                    "test@test.com",
                    0
                    )
                )
            }
        }
        return Single.create {
            it.onError(
                Error("ERR_NO_DATA")
            )
        }
    }

    override fun findAll(): List<BaseEntity> {
        TODO("Not yet implemented")
    }

    override fun update(): Int {
        TODO("Not yet implemented")
    }

    override fun delete(): Int {
        TODO("Not yet implemented")
    }

    override fun create(): BaseEntity {
        TODO("Not yet implemented")
    }
}