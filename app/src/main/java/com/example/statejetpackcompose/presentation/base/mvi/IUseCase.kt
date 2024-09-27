package com.ghtk.ecom.base.mvi

import kotlinx.coroutines.flow.Flow

interface IUseCase<in R, out T> {
    fun invoke(value: R? = null): Flow<T>
}
