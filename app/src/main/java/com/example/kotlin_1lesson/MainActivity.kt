package com.example.kotlin_1lesson

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin_1lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var list: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        this.title = "MainActivity"

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    checkEditText1(result.data)
                }
            }

        viewBinding.btnGoSecondPage.setOnClickListener {
            startSecondActivity()
        }
        viewBinding.btnGoRecycler.setOnClickListener{
            startRecyclerActivity()
        }


    }

    private fun checkEditText1(data: Intent?) {
        if(data != null){
            val text =data.getStringExtra(Keys.TEXT_KEY)
            viewBinding.editTextInput1.setText(text)
            list.add(text.toString())
        }

    }

    private fun startSecondActivity() {
        if (viewBinding.editTextInput1.text.isNullOrEmpty()) {
            Toast.makeText(this,"Введите текст, поле не может быть пустым", Toast.LENGTH_SHORT).show()
        }
        else send()
    }

    private fun send() {
        val intent =Intent(this, MainActivity2::class.java)
        intent.putExtra(Keys.TEXT_KEY,viewBinding.editTextInput1.text.toString())
        resultLauncher.launch(intent)
        list.add(viewBinding.editTextInput1.text.toString())
            }

    private fun startRecyclerActivity(){
       val intent = Intent(this,RecyclerActivity::class.java)
        intent.putExtra(Keys.TEXT_KEY,list)
        resultLauncher.launch(intent)

   }


}

class Keys {
    companion object{
        const val TEXT_KEY = "textFromSecondActivity"
    }

}






