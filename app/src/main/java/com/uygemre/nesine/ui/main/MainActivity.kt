package com.uygemre.nesine.ui.main

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.uygemre.nesine.ui.main.viewmodel.MainActivityViewModel
import com.uygemre.nesine.base.BaseActivity
import com.uygemre.nesine.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainActivityViewModel>(ActivityMainBinding::inflate) {

    override val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}