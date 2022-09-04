package binar.academy.chapter3topic1.topic2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import binar.academy.chapter3topic1.MainActivity
import binar.academy.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_bmi2.*

class BMI2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi2)

        // Tombol Kembali ke MainActivity dengan Implicit Intent
        goHome_BMI2.setOnClickListener {

            implicitIntent()

        }

        // Tombol Hitung dengan Explicit Intent
        btn_intentBMI.setOnClickListener {

            explicitIntent()

        }

        // Tombol Hitung dengan Bundle
        btn_bundleBMI.setOnClickListener {

            bundleIntent()

        }

        // Tombol Hitung dengan Serializable
        btn_serializableBMI.setOnClickListener {

            serializable()

        }

        // Tombol Hitung dengan Parcelable
        btn_parcelableBMI.setOnClickListener {

            parcelable()

        }

        // Tombol Reset BMI
        btn_resetBMI2.setOnClickListener {

            reset()

        }

    }

    private fun implicitIntent() {

        val menu = Intent(this, MainActivity :: class.java)
        startActivity(menu)

    }

    private fun explicitIntent() {

        val umur = editUmur2.text.toString()
        val tinggiBadan = editTB2.text.toString()
        val beratBadan = editBB2.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)

        val inten = Intent(this, HasilActivity :: class.java)
        inten.putExtra("age", umur)
        inten.putExtra("height", tinggiBadan)
        inten.putExtra("weight", beratBadan)
        inten.putExtra("ideal", String.format("%2.f", bmi))
        inten.putExtra("category", kategori)
        startActivity(inten)

    }

    private fun bundleIntent() {

        val umur = editUmur2.text.toString()
        val tinggiBadan = editTB2.text.toString()
        val beratBadan = editBB2.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)

        val bundling = Bundle()
        val menu = Intent(this, HasilActivity :: class.java)
        bundling.putString("age", umur)
        bundling.putString("height", tinggiBadan)
        bundling.putString("weight", beratBadan)
        bundling.putString("ideal", String.format("%2.f", bmi))
        bundling.putString("category", kategori)

        menu.putExtras(bundling)
        startActivity(menu)

    }

    private fun serializable() {

        val umur = editUmur2.text.toString()
        val tinggiBadan = editTB2.text.toString()
        val beratBadan = editBB2.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)

        val inten = Intent(this, HasilActivity :: class.java)
        val serialization = HitungSerializable(umur, tinggiBadan, beratBadan, String.format("%2.f", bmi), kategori)
        inten.putExtra("dataser", serialization)
        startActivity(inten)

    }

    private fun parcelable() {

        val umur = editUmur2.text.toString()
        val tinggiBadan = editTB2.text.toString()
        val beratBadan = editBB2.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)

        val inten = Intent(this, HasilActivity :: class.java)
        val parcelization = HitungParcelable(umur, tinggiBadan, beratBadan, String.format("%2.f", bmi), kategori)
        inten.putExtra("datapar", parcelization)
        startActivity(inten)

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

        editUmur2.setText("")
        editTB2.setText("")
        editBB2.setText("")

    }
}