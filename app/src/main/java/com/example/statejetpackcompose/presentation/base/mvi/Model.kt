package com.ghtk.ecom.base.mvi

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class Model<ViewState, Action, Mutation, Event>(
    private val actionProcessor: ActionProcessor<Action, Mutation, Event>,
    private val reducer: Reducer<Mutation, ViewState>,
    private val coroutineScope: CoroutineScope,
    private val dispatcherProvider: CoroutineDispatcher,
    private val viewMutableStateFlow: MutableStateFlow<ViewState>,
    private val eventChannel: Channel<Event>,
) {
    val viewStateFlow: Flow<ViewState> = viewMutableStateFlow
    val eventFlow: Flow<Event> = eventChannel.receiveAsFlow()

    fun process(action: Action) {
        coroutineScope.launch(dispatcherProvider) {
            actionProcessor(action)
                .collect { (mutation, event) ->
                    mutation?.let(::handleMutation)
                    event?.let(eventChannel::trySend)
                }
        }
    }

    private fun handleMutation(mutation: Mutation) {
        viewMutableStateFlow.update { currentState -> reducer(mutation, currentState) }
    }
}
