package com.dmendanyo.myplaces.commons

import com.dmendanyo.myplaces.eventbus.Event


data class LoaderEvent(val shouldShowLoader: Boolean) : Event
