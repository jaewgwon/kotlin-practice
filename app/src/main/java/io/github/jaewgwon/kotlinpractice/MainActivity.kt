package io.github.jaewgwon.kotlinpractice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import io.github.jaewgwon.kotlinpractice.ui.dto.UserDto
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        main_button_test.setOnClickListener {
            viewModel
                    .login(
                            UserDto(
                                    main_et_id.text.toString(),
                                    main_et_password.text.toString()
                            )
                    )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            Log.d("DEBUG", "Login success")
                            navigateToMain()
                        }, {
                            errorHandler(it)
                        }
                    )

            // -------------- ERROR ------------------------- SUCCESS ---------------------
            // subscribe() -> ERROR           subscribe() ->  SUCCESS
            // mutable, immutable
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun navigateToMain() {
        Toast.makeText(this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show()
    }

    private fun errorHandler(err: Throwable) {
        Toast.makeText(this, "ERROR: " + err.message.toString(), Toast.LENGTH_SHORT).show()
    }
}