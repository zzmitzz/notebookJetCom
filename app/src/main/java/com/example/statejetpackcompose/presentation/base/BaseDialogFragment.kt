package com.ghtk.ecom.base

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Base class for all [Fragment] instances
 */
abstract class BaseDialogFragment<VB : ViewBinding> : DialogFragment() {

    private var _binding: VB? = null
    abstract val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> VB

    private var isSetupViewCompleted: Boolean = false

    protected val SIZE_WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT.toFloat()
    protected val SIZE_MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT.toFloat()

    protected var isFullWith = false
    protected var isFullHeight = false

    protected val binding : VB
        get() = requireNotNull(_binding)

    // value between 0 and 1
    protected abstract fun setWidth(): Float

    // value between 0 and 1
    protected abstract fun setHeight(): Float

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindLayout.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

    }

    abstract fun prepareView(savedInstanceState: Bundle?)



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
