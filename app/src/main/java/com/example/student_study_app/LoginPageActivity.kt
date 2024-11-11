package com.example.student_study_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.AccountValdiation.AccoutnValidationObject
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.LoginUserRequest
import com.example.student_study_app.models.RegisterUserRequest
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class LoginPageActivity:AppCompatActivity() {
    //private decliration of elements
    private var btnSubmit: Button? = null
    private var teEmail: TextInputEditText? = null
    private var tePassword: TextInputEditText? = null
    private  var isChecked: Boolean?=false

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //View by id of elements
        btnSubmit = findViewById(R.id.loginButton)
        teEmail = findViewById(R.id.emaiText)
        tePassword = findViewById(R.id.passwordText)

        btnSubmit?.setOnClickListener{
                if(AccoutnValidationObject.ValidateloginInputs(teEmail?.text.toString(),tePassword?.text.toString())){
                    val LoginUser = LoginUserRequest(teEmail?.text.toString(),tePassword?.text.toString())
                    lifecycleScope.launch{
                        val response = RetrofitInstance.api.loginUser(LoginUser)
                        if (response.isSuccessful) {
                            isChecked = true;
                            SuccessfulLogin(LoginUser)
                        }
                        else{
                            Toast.makeText(this@LoginPageActivity, "Login failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                Toast.makeText(this, "Please, fill details", Toast.LENGTH_SHORT).show()
                }
        }

    }
    fun SuccessfulLogin(RegUser:LoginUserRequest){
        if(isChecked == true){
            Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT).show()
            //AccoutnValidationObject.saveToFile(this,"TestUsername.txt",RegUser.username)
            val intent = Intent(this, QuizzesPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}