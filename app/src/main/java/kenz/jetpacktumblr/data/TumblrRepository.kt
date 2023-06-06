package kenz.jetpacktumblr.data

import kenz.jetpacktumblr.model.FakeTumblrDataSource
import kenz.jetpacktumblr.model.Tumblr
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class RewardRepository {
    private val tumblr = mutableListOf<Tumblr>()

    fun getAllTumblrs(): Flow<List<Tumblr>> {
        return flowOf(tumblr)
    }

    fun getTumblrById(tumblrId: Long): Tumblr {
        return tumblr.first {
            it.id == tumblrId
        }
    }

    companion object {
        @Volatile
        private var instance: RewardRepository? = null

        fun getInstance(): RewardRepository =
            instance ?: synchronized(this) {
                RewardRepository().apply {
                    instance = this
                }
            }
    }
}