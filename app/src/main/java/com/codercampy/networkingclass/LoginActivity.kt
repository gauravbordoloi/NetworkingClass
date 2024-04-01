package com.codercampy.networkingclass

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.codercampy.networkingclass.databinding.ActivityLoginBinding
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            login()

        }

    }

    private fun login() {

        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.editText?.text.toString().trim()

        val queue = Volley.newRequestQueue(this)
        val url = "http://api-hospiton-dev.ap-south-1.elasticbeanstalk.com:8080/auth/login"

// Request a string response from the provided URL.
        val stringRequest = JsonObjectRequest(
            Request.Method.POST,
            url,
            JSONObject().apply {
                put("username", username)
                put("password", password)
                put("auth_type", "AUTH_TYPE_CLINIC")
            },
            { response ->
                Log.e("Purab Message", response.toString())
                Toast.makeText(this, response.getString("message"), Toast.LENGTH_SHORT).show()
            },
            {
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)

    }

}