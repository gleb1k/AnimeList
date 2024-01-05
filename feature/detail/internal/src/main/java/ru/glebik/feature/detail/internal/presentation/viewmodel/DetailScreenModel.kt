package ru.glebik.core.widget.template

import ru.glebik.core.presentation.MviScreenModel
import ru.glebik.feature.detail.internal.presentation.viewmodel.DetailStore


class DetailScreenModel(
    private val store: DetailStore,
) : MviScreenModel<DetailStore.Intent, DetailStore.State, DetailStore.Label>(
    store
) {

    fun navigate(id: Int) = store.accept(DetailStore.Intent.NavigateTo(id))

    fun load(id: Int) = store.accept(DetailStore.Intent.Load(id))

}
