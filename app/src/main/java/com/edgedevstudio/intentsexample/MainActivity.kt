package com.edgedevstudio.intentsexample

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ShareCompat
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
                val textToShare = stringFromImplicitIntentEditTextView
                val mimeType = "text/plain"
                val subject = "Subject of Content to Share" // you would need a "subject" if a user selects an email app to fulfill the intent
                val context = this
                ShareCompat.IntentBuilder.from(context)
                        .setType(mimeType)
                        .setSubject(subject)
                        .setText(textToShare)
                        .startChooser()
            } else
                showToastMsg("Input some text to launch an Implicit Intent")
        }

    }

    private fun showToastMsg(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
