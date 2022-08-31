package binar.academy.chapter3topic1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi.*

class BMIActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        // Tombol Kembali ke MainActivity
        goHome_BMI.setOnClickListener {

            val menu = Intent(this, MainActivity :: class.java)
            startActivity(menu)

        }

        // Tombol Hitung BMI
        btn_hitungBMI.setOnClickListener {

            val umur = editUmur.text.toString()
            val tinggiBadan = editTB.text.toString()
            val beratBadan = editBB.text.toString()
            val BMI = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())

            hasilUmur.text = "$umur tahun"
            hasilTB.text = "$tinggiBadan cm"
            hasilBB.text = "$beratBadan kg"
            hasilBMI.text = String.format("%.1f", BMI)
            hasilKategori.text = kategoriBerat(BMI)

        }

        // Tombol Reset BMI
        btn_resetBMI.setOnClickListener {

            reset()

        }

    }

    // Method Perhitungan BMI
    private fun hitungBMI(tinggiTubuh: Double, beratTubuh: Double): Double {

        return beratTubuh / ((tinggiTubuh * tinggiTubuh) / 10000)
    }

    // Method Klasifikasi BMI
    private fun kategoriBerat(BMI: Double):String {

        val kategori: String
        if (BMI >= 0 && BMI < 16) {
            kategori = "Terlalu Kurus"
        } else if (BMI in (16.0..17.0)) {
            kategori = "Cukup Kurus"
        } else if (BMI > 17 && BMI <= 18.5) {
            kategori = "Sedikit Kurus"
        } else if (BMI > 18.5 && BMI <= 25) {
            kategori = "Normal"
        } else if (BMI > 25 && BMI <= 30) {
            kategori = "Gemuk"
        } else if (BMI > 30 && BMI <= 35) {
            kategori = "Obesitas Kelas I"
        } else if (BMI > 35 && BMI <= 40) {
            kategori = "Obesitas Kelas II"
        } else if (BMI > 40 && BMI <= 50) {
            kategori = "Obesitas Kelas III"
        } else kategori = "Wah ! Mulai perhatikan pola makananmu ya :)"

        return kategori

    }

    // Method untuk Tombol Reset BMI
    private fun reset() {

        editUmur.setText("")
        editTB.setText("")
        editBB.setText("")

        hasilUmur.text = ""
        hasilTB.text = ""
        hasilBB.text = ""
        hasilBMI.text = ""
        hasilKategori.text = ""

    }
}