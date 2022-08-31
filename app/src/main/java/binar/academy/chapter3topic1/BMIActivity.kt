package binar.academy.chapter3topic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        btnHitung.setOnClickListener {

            var tinggiBadan = editTB.text.toString()
            var beratBadan = editBB.text.toString()
            var BMI = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())

            textHasilUmur.text = "${editUmur.text} tahun"
            textHasilTB.text = "$tinggiBadan cm"
            textHasilBB.text = "$beratBadan kg"
            textHasilBMI.text = String.format("%.1f", BMI)
            textHasilKategori.text = kategoriBerat(BMI)

        }

        btnReset.setOnClickListener {

            reset()
        }

    }

    fun hitungBMI(tinggiTubuh : Double, beratTubuh : Double) : Double {

        var BMI = beratTubuh / ((tinggiTubuh * tinggiTubuh) / 10000)

        return BMI
    }

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

    fun reset(){
        editUmur.setText("")
        editTB.setText("")
        editBB.setText("")

        textPreUmur.text = ""
        textPreTB.text = ""
        textPreBB.text = ""
        textPreBMI.text = ""
        textPreKategori.text = ""
    }
}