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
import com.example.student_study_app.models.RegisterUserRequest
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import kotlin.random.Random

class RegisterPageActivity:AppCompatActivity() {
    //private decliration of elements
    private var btnSubmit: Button? = null
    private var teFname: TextInputEditText? = null
    private var teLname: TextInputEditText? = null
    private var teEmail: TextInputEditText? = null
    private var tePassword: TextInputEditText? = null
    private var teConfirmPassword: TextInputEditText? = null
    private var tvText: TextView? = null
    private  var isChecked: Boolean?=false

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //View by id of elements
        btnSubmit = findViewById(R.id.signUpButton)
        teFname = findViewById(R.id.firstNametext)
        teLname = findViewById(R.id.lastNametext)
        teEmail = findViewById(R.id.emailtext)
        tePassword = findViewById(R.id.passwordtext)
        teConfirmPassword = findViewById(R.id.confirmPasswordtext)
        //remove element
        tvText = findViewById(R.id.wwe)

        btnSubmit?.setOnClickListener{
            if(AccoutnValidationObject.ValidateRegisterInputs(teLname?.text.toString(),teEmail?.text.toString(),tePassword?.text.toString(),teConfirmPassword?.text.toString(),teFname?.text.toString())){

                val RegUser = RegisterUserRequest(teEmail?.text.toString(),tePassword?.text.toString(),teFname?.text.toString(),teLname?.text.toString(),combineStringsWithRandomNumberAtEnd(teFname?.text.toString(),teLname?.text.toString()))
                lifecycleScope.launch{
                    val response = RetrofitInstance.api.RegisterUser(RegUser)
                    if (response.isSuccessful) {
                        isChecked = true;
                        qdasd(RegUser)
                    }
                }
            }
            else{
                Toast.makeText(this, "Please, fill details", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun combineStringsWithRandomNumberAtEnd(str1: String, str2: String, randomDigits: Int = 6): String {
        val randomNumber = (1..randomDigits).map { Random.nextInt(0, 10) }.joinToString("")
        return "$str1$str2$randomNumber"
    }

    fun qdasd(RegUser:RegisterUserRequest){
        if(isChecked == true){
            Toast.makeText(this, "Registration succesful", Toast.LENGTH_SHORT).show()
            AccoutnValidationObject.saveToFile(this,"TestUsername.txt",RegUser.username)
            val intent = Intent(this, QuizzesPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}