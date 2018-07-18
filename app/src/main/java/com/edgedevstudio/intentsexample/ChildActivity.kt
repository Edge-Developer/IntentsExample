package com.edgedevstudio.intentsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.edgedevstudio.intentsexample.MainActivity.Companion.INTENT_KEY

class ChildActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        val textView = findViewById<TextView>(R.id.child_activity_text_view)

        val intent4rmMainActivity = intent
        if (intent4rmMainActivity != null){
            val string4rmExplicitIntent = intent4rmMainActivity.getStringExtra(INTENT_KEY)
            textView.setText(string4rmExplicitIntent)
        }
    }
}
