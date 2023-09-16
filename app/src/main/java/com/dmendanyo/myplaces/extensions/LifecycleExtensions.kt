package com.dmendanyo.myplaces.extensions

import androidx.lifecycle.LifecycleCoroutineScope
import com.dmendanyo.myplaces.commons.LoaderEvent
import com.dmendanyo.myplaces.eventbus.EventBus
import kotlinx.coroutines.launch

fun LifecycleCoroutineScope.subscribeLoader(onEvent: (Boolean) -> Unit) {
    this.launch {
        EventBus.subscribe<LoaderEvent> { onEvent(it.shouldShowLoader) }
    }
}
