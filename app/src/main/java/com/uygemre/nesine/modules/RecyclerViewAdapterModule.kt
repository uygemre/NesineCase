package com.uygemre.nesine.modules

import com.uygemre.nesine.adapter.CaseRecyclerViewAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RecyclerViewAdapterModule {

    @Provides
    fun provideAdapter(): CaseRecyclerViewAdapter {
        return CaseRecyclerViewAdapter()
    }
}