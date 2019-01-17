package io.coroutines.cache

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.coroutines.cache.core.CachePolicy
import io.coroutines.cache.core.CoroutinesCache
import kotlinx.android.synthetic.main.activity_main.text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val coroutinesCache: CoroutinesCache by lazy {
        CoroutinesCache(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.Main) {
            val myAsyncText = coroutinesCache.asyncCache(
                {
                    async {
                        delay(3000)
                        "Test"
                    }
                },
                "Key",
                CachePolicy.LifeCache(10, TimeUnit.MINUTES)
            ).await()

            text.text = myAsyncText
        }
    }
}
