package ru.glebik.feature.home.internal.presentation.viewmodel

import ru.glebik.core.presentation.MviScreenModel


class MviHomeScreenModel(
    private val store: HomeStore,
) : MviScreenModel<HomeStore.Intent, HomeStore.State, HomeStore.Label>(
    store
) {

    init {
        loadRecommendations()
    }

    fun navigate(id: Int) = store.accept(HomeStore.Intent.NavigateToDetails(id))

    private fun loadRecommendations() = store.accept(HomeStore.Intent.LoadRecommendations)

}


//class HomeScreenModel(
//    private val store: HomeStore,
//) : ScreenModel {
//
//    private val _state = MutableStateFlow(HomeStore.State())
//    val state: StateFlow<HomeStore.State>
//        get() = _state.asStateFlow()
//
//    private val _label = MutableSharedFlow<HomeStore.Label?>()
//    val label: SharedFlow<HomeStore.Label?>
//        get() = _label.asSharedFlow()
//
//    private val binder: Binder
//
//    init {
//        binder = bind(Dispatchers.Main.immediate) {
//            store.states bindTo (::acceptState)
//            store.labels bindTo (::acceptLabel)
//        }
//        binder.start()
//
//        loadRecommendations()
//    }
//
//    private fun acceptState(state: HomeStore.State) {
//        _state.value = state
//    }
//
//    private fun acceptLabel(label: HomeStore.Label) {
//        screenModelScope.launch {
//            _label.emit(label)
//        }
//    }
//
//    fun navigate() = store.accept(HomeStore.Intent.NavigateToProfile)
//
//    private fun loadRecommendations() = store.accept(HomeStore.Intent.LoadRecommendations)
//
//    override fun onDispose() {
//        super.onDispose()
//
//        binder.stop()
//        store.dispose()
//    }
//}


