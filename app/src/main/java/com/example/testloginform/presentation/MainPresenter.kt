package com.example.testloginform.presentation




import com.example.testloginform.app.App
import com.example.testloginform.domain.UserModelRepository
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    @Inject
    lateinit var repository: UserModelRepository

    init {
        App.appComponent.injectPresenter(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.getUser()

        viewState.saveUser()
    }
}