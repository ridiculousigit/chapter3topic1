package binar.academy.chapter3topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuBMI.setOnClickListener {
            var menu = Intent(this, BMIActivity :: class.java)
            startActivity(menu)
        }

        menuNilai.setOnClickListener {
            var menu = Intent(this, NilaiActivity :: class.java)
            startActivity(menu)
        }
    }
}