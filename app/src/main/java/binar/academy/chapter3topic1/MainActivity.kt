package binar.academy.chapter3topic1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menu Pertama - Kalkulator
        menuKalkulator.setOnClickListener {
            val menu = Intent(this, BasicActivity :: class.java)
            startActivity(menu)
        }

        // Menu Pertama - Kalkulator BMI
        menuBMI.setOnClickListener {
            val menu = Intent(this, BMIActivity :: class.java)
            startActivity(menu)
        }

        // Menu Pertama - Kalkulator Nilai Siswa
        menuNilai.setOnClickListener {
            val menu = Intent(this, NilaiActivity :: class.java)
            startActivity(menu)
        }
    }
}