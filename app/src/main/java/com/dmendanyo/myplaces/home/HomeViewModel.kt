package com.dmendanyo.myplaces.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmendanyo.myplaces.commons.CategoryItemUiModel
import com.dmendanyo.myplaces.commons.LoaderEvent
import com.dmendanyo.myplaces.eventbus.EventBus
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _categories = MutableStateFlow<List<CategoryItemUiModel>>(listOf())
    val categories: StateFlow<List<CategoryItemUiModel>> = _categories

    init {
        viewModelScope.launch {
            EventBus.publish(LoaderEvent(true))
            delay(2000L)
            EventBus.publish(LoaderEvent(false))
        }

        _categories.value = listOf(
            CategoryItemUiModel(1, "", "Cities"),
            CategoryItemUiModel(2, "", "Restaurants"),
            CategoryItemUiModel(3, "", "Monuments"),
            CategoryItemUiModel(4, "", "Discos"),
        )
    }
}
