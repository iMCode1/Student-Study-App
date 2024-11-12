package com.example.student_study_app.AccountValdiation

import android.content.Context
import java.io.File

object AccoutnValidationObject {
    //Confirms password if password matches
    private fun passwordsMatch(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

    // Checks if valid
    private fun isValidPassword(password: String, minLength: Int = 8): Boolean {
        if (password.length < minLength) return false
        val hasUppercase = password.any { it.isUpperCase() }
        val hasLowercase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecialChar = password.any { !it.isLetterOrDigit() }
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar
    }

    // Checks if the input is not null and not blank
    private fun isNotNullOrBlank(input: String?): Boolean {
        return !input.isNullOrBlank()
    }

    // Checks if the input is a valid email format
    private fun isValidEmail(input: String?): Boolean {
        return input != null && android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }

    // Combined function to verify all conditions
    fun ValidateRegisterInputs(
        inLname: String?,
        inEmail: String,
        inPassword: String,
        inConfirmPassword: String,
        inFname: String
    ): Boolean {
        return isNotNullOrBlank(inLname) && isNotNullOrBlank(inFname) && isValidEmail(inEmail) && isValidPassword(
            inPassword
        ) && passwordsMatch(inPassword, inConfirmPassword)
    }

    fun ValidateloginInputs(inEmail: String, inPassword: String): Boolean {
        return isValidEmail(inEmail) && isValidPassword(inPassword)
    }

    fun saveToFile(context: Context, filename: String, content: String) {
        context.openFileOutput(filename, Context.MODE_PRIVATE).use { output ->
            output.write(content.toByteArray())
        }
    }

    fun readFromFile(context: Context, filename: String): String? {
        return try {
            context.openFileInput(filename).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun SignOut(context: Context, filename: String) {
        context.deleteFile(filename)
    }

    fun CheckIfExists(context: Context, filename: String):Boolean {
        val file = File(context.filesDir, filename)
        return file.exists()
    }
}