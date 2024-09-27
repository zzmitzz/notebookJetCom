package com.ghtk.ecom.base.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface MVI<ViewState, Action, Mutation, Event> {
    val viewStateFlow: Flow<ViewState>
    val eventFlow: Flow<Event>

    fun CoroutineScope.process(action: Action)
    fun handleMutation(mutation: Mutation)
}
