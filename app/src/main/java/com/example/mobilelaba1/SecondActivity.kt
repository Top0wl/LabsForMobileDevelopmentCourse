package com.example.mobilelaba1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.mobilelaba1.R

class SecondActivity : AppCompatActivity() {

    private lateinit var receivedTextEditText: EditText
    private lateinit var editButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        receivedTextEditText = findViewById(R.id.receivedTextEditText)
        editButton = findViewById(R.id.editButton)

        val receivedText = intent.getStringExtra("TEXT_TO_SEND")
        receivedTextEditText.setText(receivedText)

        editButton.setOnClickListener {
            val modifiedText = receivedTextEditText.text.toString()
            val intent = Intent()
            intent.putExtra("MODIFIED_TEXT", modifiedText)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}