package binar.academy.chapter3topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_basic.*

class BasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        // Tombol Kembali ke MainActivity
        goHome_Jumlah.setOnClickListener {

            val menu = Intent(this, MainActivity :: class.java)
            startActivity(menu)

        }

        // Tombol Hitung Penjumlahan
        btn_hitungJumlah.setOnClickListener {

            val angkaPertama = editAngka1.text.toString()
            val angkaKedua = editAngka2.text.toString()
            val jumlah = Penjumlahan(angkaPertama.toDouble(), angkaKedua.toDouble())

            hasilPenjumlahan.text = String.format("%.0f", jumlah)

        }

        // Tombol Reset Penjumlahan
        btn_resetJumlah.setOnClickListener {

            reset()

        }

    }

    // Method Penjumlahan
    private fun Penjumlahan(satu : Double, dua : Double) : Double {

        return satu + dua

    }

    // Method Tombol Reset
    private fun reset() {

        editAngka1.setText("")
        editAngka2.setText("")

    }

}