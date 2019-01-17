package io.coroutines.cache.core

import java.util.concurrent.TimeUnit

sealed class CachePolicy {
    data class IgnoreCache(val fromSource: Boolean) : CachePolicy()
    data class LifeCache(val duration: Int, val timeUnit: TimeUnit) : CachePolicy()
}