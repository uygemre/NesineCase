package com.uygemre.nesine.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

typealias Inflates<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseBottomSheetDialog<VB : ViewBinding>(private val inflate: Inflates<VB>) :
    BottomSheetDialogFragment() {

    private var _binding: VB? = null
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate.invoke(layoutInflater, container, false)
        return requireNotNull(binding?.root)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
