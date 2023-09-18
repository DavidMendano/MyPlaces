package com.dmendanyo.myplaces.home

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmendanyo.domain.usecases.GetCategoriesUseCase
import com.dmendanyo.myplaces.commons.CategoryItemUiModel
import com.dmendanyo.myplaces.commons.LoaderEvent
import com.dmendanyo.myplaces.eventbus.EventBus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategories: GetCategoriesUseCase
): ViewModel() {

    private val _categories = MutableStateFlow<List<CategoryItemUiModel>>(listOf())
    val categories: StateFlow<List<CategoryItemUiModel>> = _categories

    init {
        viewModelScope.launch {
            EventBus.publish(LoaderEvent(true))
            getCategories.invoke()
                .collect{
                    _categories.value = it.map { category ->
                        CategoryItemUiModel(
                            category.id,
                            category.urlImage,
                            category.title,
                            category.subtitle
                        ) }
                }
            EventBus.publish(LoaderEvent(false))
        }
    }
}
