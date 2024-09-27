package com.ghtk.ecom.base.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MVIDelegate<ViewState, Action, Mutation, Event> internal constructor(
    initialUiState: ViewState,
    val reducer: Reducer<Mutation, ViewState>,
    val actionProcessor: ActionProcessor<Action, Mutation, Event>
) : MVI<ViewState, Action, Mutation, Event> {

    private val _viewMutableStateFlow = MutableStateFlow(initialUiState)
    override val viewStateFlow: StateFlow<ViewState> = _viewMutableStateFlow.asStateFlow()

    private val _eventChannel by lazy { Channel<Event>(Channel.BUFFERED) }
    override val eventFlow: Flow<Event> by lazy { _eventChannel.receiveAsFlow() }

    override fun CoroutineScope.process(action: Action) {
        this.launch {
            actionProcessor(action)
                .collect { (mutation, event) ->
                    mutation?.let(::handleMutation)
                    event?.let(_eventChannel::trySend)
                }
        }
    }

    override fun handleMutation(mutation: Mutation) {
        _viewMutableStateFlow.update { currentState -> reducer(mutation, currentState) }
    }
}

fun <ViewState, Action, Mutation, Event> reduxMvi(
    actionProcessor: ActionProcessor<Action, Mutation, Event>,
    reducer: Reducer<Mutation, ViewState>,
    initialUiState: ViewState
): MVI<ViewState, Action, Mutation, Event> = MVIDelegate(initialUiState, reducer, actionProcessor)
