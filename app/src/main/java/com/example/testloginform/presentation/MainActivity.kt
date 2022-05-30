package com.example.testloginform.presentation


import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.testloginform.R
import com.example.testloginform.databinding.ActivityMainBinding
import com.example.testloginform.domain.models.UserModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    @InjectPresenter
    lateinit var mPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btGetData.setOnClickListener {
            getUser()
        }

        binding.btSaveData.setOnClickListener {
            saveUser()
        }
    }

    override fun getUser() {
        lifecycleScope.launch {
            loading()
            val user = mPresenter.repository.getData()
            binding.tvGetData.text =
                getString(R.string.get_user, user.firstName, user.lastName)
        }
    }

    override fun saveUser() {
        lifecycleScope.launch {
            loading()
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val user = UserModel(firstName, lastName)
            mPresenter.repository.saveData(user)
        }
    }

    private suspend fun loading() {
        notVisibleElements()
        delay(1000)
        visibleElements()
    }

    private fun visibleElements() {
        binding.btGetData.isEnabled = true
        binding.etFirstName.isEnabled = true
        binding.etLastName.isEnabled = true
        binding.btSaveData.isEnabled = true
        binding.progressBar.isVisible = false
    }

    private fun notVisibleElements() {
        binding.btGetData.isEnabled = false
        binding.etFirstName.isEnabled = false
        binding.etLastName.isEnabled = false
        binding.btSaveData.isEnabled = false
        binding.progressBar.isVisible = true
    }
}