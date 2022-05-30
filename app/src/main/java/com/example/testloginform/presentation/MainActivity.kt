package com.example.testloginform.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.testloginform.R
import com.example.testloginform.databinding.ActivityMainBinding
import com.example.testloginform.di.DaggerAppComponent
import com.example.testloginform.di.DataModule
import com.example.testloginform.domain.models.UserModel
import com.example.testloginform.domain.usecases.GetUserUseCase
import com.example.testloginform.domain.usecases.SaveUserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var getUser: GetUserUseCase

    @Inject
    lateinit var saveUser: SaveUserUseCase

    private val component by lazy {
        DaggerAppComponent.builder()
            .dataModule(DataModule(this))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btGetData.setOnClickListener {
            lifecycleScope.launch {
                loading()
                val user = getUser.getUser()
                binding.tvGetData.text =
                    getString(R.string.get_user, user.firstName, user.lastName)
            }
        }

        binding.btSaveData.setOnClickListener {
            lifecycleScope.launch {
                loading()
                val firstName = binding.etFirstName.text.toString()
                val lastName = binding.etLastName.text.toString()
                val user = UserModel(firstName, lastName)
                saveUser.saveUser(user)
            }
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