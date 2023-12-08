package com.example.mobilelaba1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.example.mobilelaba1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var sendButton: Button

    companion object {
        const val SECOND_ACTIVITY_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            val textToSend = editText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT_TO_SEND", textToSend)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val modifiedText = data?.getStringExtra("MODIFIED_TEXT")
                editText.setText(modifiedText)
            }
        }
    }
}