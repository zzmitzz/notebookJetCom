package com.ghtk.ecom.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified ViewState, reified Action, reified Mutation, reified Event> ViewModel.model(
    actionProcessor: ActionProcessor<Action, Mutation, Event>,
    reducer: Reducer<Mutation, ViewState>,
    dispatcherProvider: CoroutineDispatcher,
    initialState: ViewState,
) =
    ModelProperty(
        viewModel = this,
        actionProcessor = actionProcessor,
        reducer = reducer,
        dispatcherProvider = dispatcherProvider,
        viewMutableStateFlow = MutableStateFlow(initialState),
        eventChannel = Channel(Channel.BUFFERED),
    )

class ModelProperty<ViewState, Action, Mutation, Event>(
    private val viewModel: ViewModel,
    private val actionProcessor: ActionProcessor<Action, Mutation, Event>,
    private val reducer: Reducer<Mutation, ViewState>,
    private val dispatcherProvider: CoroutineDispatcher,
    private val viewMutableStateFlow: MutableStateFlow<ViewState>,
    private val eventChannel: Channel<Event>,
) : ReadOnlyProperty<Any, Model<ViewState, Action, Mutation, Event>> {
    override fun getValue(
        thisRef: Any,
        property: KProperty<*>,
    ): Model<ViewState, Action, Mutation, Event> =
        Model(
            actionProcessor = actionProcessor,
            reducer = reducer,
            coroutineScope = viewModel.viewModelScope,
            dispatcherProvider = dispatcherProvider,
            viewMutableStateFlow = viewMutableStateFlow,
            eventChannel = eventChannel,
        )
}
