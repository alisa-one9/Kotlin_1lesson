package com.example.kotlin_1lesson

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import com.example.kotlin_1lesson.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var viewBinding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        reciveData()
        viewBinding.btnGoFirstPage.setOnClickListener {
            startFirstActivity()
        }

        this.title = "SecondActicity"
    }

    private fun reciveData() {
        val text: String? = intent.getStringExtra(Keys.TEXT_KEY)
        viewBinding.editTextInput2.setText(text)
    }

    private fun startFirstActivity() {
        if (viewBinding.editTextInput2.text.isNullOrEmpty()) {
            Toast.makeText(
                this, "Введите имя в поле",
                Toast.LENGTH_SHORT).show()
        } else {
            sendToFirstActivity()
        }
    }

    private fun sendToFirstActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Keys.TEXT_KEY,viewBinding.editTextInput2.text.toString())
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

}


