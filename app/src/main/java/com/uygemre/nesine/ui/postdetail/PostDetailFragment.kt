package com.uygemre.nesine.ui.postdetail

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.uygemre.nesine.base.BaseBottomSheetDialog
import com.uygemre.nesine.constants.AppConstants.IMAGE_URL
import com.uygemre.nesine.databinding.FragmentPostDetailBinding
import com.uygemre.nesine.extensions.loadImage
import com.uygemre.nesine.viewholder.post.PostDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment(
    private val item: PostDTO,
    private val update: (item: PostDTO) -> Unit
) : BaseBottomSheetDialog<FragmentPostDetailBinding>(FragmentPostDetailBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        with(receiver = binding) {
            this?.edtTitle?.setText(item.title)
            this?.edtBody?.setText(item.body)
            this?.ivPostLogo?.loadImage(url = "${IMAGE_URL}${item.id}")
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

        val copyItem = item.copy()
        copyItem.title = binding?.edtTitle?.text?.toString()
        copyItem.body = binding?.edtBody?.text?.toString()
        update(copyItem)
    }
}