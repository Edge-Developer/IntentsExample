package com.edgedevstudio.intentsexample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_KEY = "intent_extra_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val explicitIntentEditText = findViewById<TextView>(R.id.editText1)
        val explicitIntentButton = findViewById<Button>(R.id.button1)
        explicitIntentButton.setOnClickListener { v ->
            val destinationClass = ChildActivity::class.java
            val context = this
            val intent = Intent(context, destinationClass)
            val stringFromExplicitIntentEditTextView = explicitIntentEditText.text.toString()
            if (stringFromExplicitIntentEditTextView.trim().length > 1) {
                intent.putExtra(INTENT_KEY, stringFromExplicitIntentEditTextView)
                startActivity(intent)
            } else
                showToastMsg("Input some text to launch an Explicit Intent")
        }

        val implicitIntentEditText = findViewById<TextView>(R.id.editText2)
        val implicitIntentButton = findViewById<Button>(R.id.button2)
        implicitIntentButton.setOnClickListener { v ->
            val stringFromImplicitIntentEditTextView = implicitIntentEditText.text.toString()
            stringFromImplicitIntentEditTextView.trim()
            if (stringFromImplicitIntentEditTextView.length > 1) {
                val shareBody = stringFromImplicitIntentEditTextView
                val sharingImplicitIntent = Intent(Intent.ACTION_SEND)
                sharingImplicitIntent.setType("text/plain")
                sharingImplicitIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
                sharingImplicitIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingImplicitIntent, "Title of Share Dialog"))
            } else
                showToastMsg("Input some text to launch an Implicit Intent")
        }

    }

    private fun showToastMsg(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
