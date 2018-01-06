package com.example.gabrielrosa.retrofitwithkotlin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.gabrielrosa.retrofitwithkotlin.apidatasource.ApiDataSourceImpl
import com.example.gabrielrosa.retrofitwithkotlin.databinding.LoginActBinding
import com.example.gabrielrosa.retrofitwithkotlin.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var binding: LoginActBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_act)

        binding?.handler = this
        val a = UserResponse("Gabe")
        binding?.userName!!.text  = a.name

    }

    fun clicked(view: View) {
        val valueTyped = binding?.userNumberEditText!!.getText().toString()
        var intValue   = 1
        if (valueTyped.isNotBlank() && valueTyped.isNotEmpty()) {
             intValue = Integer.parseInt(binding?.userNumberEditText!!.getText().toString())
        }

        val call = ApiDataSourceImpl().apiDataSource().user(intValue)
        call.enqueue(object : Callback<UserResponse?> {
            override fun onResponse(call: Call<UserResponse?>?, response: Response<UserResponse?>?) {
                response?.let {
                    binding?.userName!!.text = it.body()?.name
                }
            }

            override fun onFailure(call: Call<UserResponse?>?, t: Throwable?) {
                Toast.makeText(applicationContext, "Failed",Toast.LENGTH_SHORT).show()
            }
        })

    }
}
