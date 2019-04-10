package nz.co.ventego_creative.rg4a_3_0_6_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import main.java.com.mindscapehq.android.raygun4android.RaygunClient
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RaygunClient.init(getApplicationContext());
        RaygunClient.attachExceptionHandler();

        val crashButton = findViewById(R.id.crashButton) as Button
        val sendButton = findViewById(R.id.sendButton) as Button

        sendButton.setOnClickListener {
            val tw = HashMap<String,String>()
            tw["secondkey"] = "secondvalue"
            RaygunClient.send(Exception("This is a test exception"), null, tw)
        }

        crashButton.setOnClickListener {
            val i = 3 / 0
            Log.d("RG4A_3_0_6_test", "This is here purely so that our division by zero calculation in i gets used and not optimised away in a release build: $i")
        }
    }


}
