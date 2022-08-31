package binar.academy.chapter3topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_bmi.view.*

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        // Tombol Kembali ke MainActivity
        goHome_BMI.setOnClickListener {
            var menu = Intent(this, MainActivity :: class.java)
            startActivity(menu)
        }

        // Tombol Hitung BMI
        btn_hitungBMI.setOnClickListener {

            var tinggiBadan = editTB.text.toString()
            var beratBadan = editBB.text.toString()
            var BMI = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())

            hasilUmur.text = "${editUmur.text} tahun"
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
    fun hitungBMI(tinggiTubuh : Double, beratTubuh : Double) : Double {

        var BMI = beratTubuh / ((tinggiTubuh * tinggiTubuh) / 10000)

        return BMI
    }

    // Method Klasifikasi BMI
    fun kategoriBerat(BMI: Double):String {

        val kategori: String
        if (BMI < 16 && BMI > 0) {
            kategori = "Terlalu Kurus"
        } else if (BMI >= 16 && BMI <= 17) {
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
    fun reset(){
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