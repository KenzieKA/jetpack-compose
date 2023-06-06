package kenz.jetpacktumblr.di

object Injection {
    fun provideRepository(): TumblrRepository {
        return TumblrRepository.getInstance()
    }
}