package com.uygemre.nesine.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.viewbinding.ViewBinding
import com.devhoony.lottieproegressdialog.LottieProgressDialog

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(private val inflate: Inflate<VB>) :
    AppCompatDialogFragment() {

    abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = _binding

    protected var lottie: LottieProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater, container, false)
        return requireNotNull(binding?.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().intent?.let { _intent -> viewModel.handleIntent(_intent) }
        arguments?.let { _bundle -> viewModel.handleArguments(_bundle) }
        childFragmentManager.fragments.forEach {
            (it as? BaseFragment<*, *>)?.onNewIntent(requireActivity().intent)
        }

        lottie = LottieProgressDialog(
            context = this.requireContext(),
            isCancel = true,
            dialogWidth = null,
            dialogHeight = null,
            animationViewWidth = null,
            animationViewHeight = null,
            fileName = LottieProgressDialog.SAMPLE_1,
            title = null,
            titleVisible = null
        )
    }

    @CallSuper
    open fun onNewIntent(intent: Intent) {
        childFragmentManager.fragments.forEach {
            (it as? BaseFragment<*, *>)?.onNewIntent(intent)
        }
    }

    protected fun showProgress() {
        if (lottie?.isShowing == false)
            lottie?.show()
    }

    protected fun dismissProgress() {
        if (lottie?.isShowing == true)
            lottie?.dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}