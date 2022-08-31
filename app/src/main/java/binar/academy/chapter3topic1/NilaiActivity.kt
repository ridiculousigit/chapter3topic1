package binar.academy.chapter3topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_nilai.*

class NilaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

        // Tombol Kembali ke MainActivity
        goHome_Nilai.setOnClickListener {

            var menu = Intent(this, MainActivity :: class.java)
            startActivity(menu)

        }

        // Tombol Hitung Nilai
        btn_hitungNilai.setOnClickListener {

            var namaMahasiswa = editNama.text.toString()
            var nimMahasiswa = editNIM.text.toString()
            var uasMahasiswa = editUAS.text.toString()
            var utsMahasiswa = editUTS.text.toString()
            var tugasMahasiswa = editTugas.text.toString()
            var total = hitungTotal(uasMahasiswa.toDouble(), utsMahasiswa.toDouble(), tugasMahasiswa.toDouble())
            var rerata = hitungRerata(total)
            var kriteria = kriteriaNilai(rerata)
            var kategori = kategoriNilai(kriteria)

            hasilNama.text = "$namaMahasiswa"
            hasilNIM.text = "$nimMahasiswa"
            hasilUAS.text = "$uasMahasiswa"
            hasilUTS.text = "$utsMahasiswa"
            hasilTugas.text = "$tugasMahasiswa"
            hasilTotal.text = "$total"
            hasilRerata.text = "$rerata"
            hasilKriteria.text = "$kriteria"
            hasilKategori.text = "$kategori"

        }

        // Tombol Reset Nilai
        btn_resetNilai.setOnClickListener {

            reset()

        }

    }

    // Method Perhitungan Total
    fun hitungTotal(UAS : Double, UTS : Double, Tugas : Double) : Double {

        return UAS + UTS + Tugas

    }

    // Method Perhitungan Rata - Rata
    fun hitungRerata(Total : Double) : Double {

        return Total / 3

    }

    // Method Penentuan Kriteria Nilai
    fun kriteriaNilai(rataRata : Double) : String {

        val kriteria : String
        if (rataRata >= 0 && rataRata <= 60) {
            kriteria = "F"
        } else if (rataRata >= 61 && rataRata <= 70) {
            kriteria = "D"
        } else if (rataRata >= 71 && rataRata <= 80) {
            kriteria = "C"
        } else if (rataRata >= 81 && rataRata <= 90) {
            kriteria = "B"
        } else if (rataRata >= 91 && rataRata <= 100) {
            kriteria = "A"
        } else kriteria = "Kriteria Nilai Tidak Valid"

        return kriteria

    }

    // Method Penentuan Kategori Nilai
    fun kategoriNilai(kriteria : String) : String {

        val kategori : String
        if (kriteria == "A" ||kriteria == "B" ||kriteria == "C") {
            kategori = "Lulus"
        } else kategori = "Tidak Lulus"

        return kategori

    }

    // Method Tombol Reset Nilai
    fun reset() {

        editNama.setText("")
        editNIM.setText("")
        editUAS.setText("")
        editUTS.setText("")
        editUAS.setText("")
        editTugas.setText("")

        hasilNama.text = ""
        hasilNIM.text = ""
        hasilUAS.text = ""
        hasilUTS.text = ""
        hasilUTS.text = ""
        hasilTugas.text = ""
        hasilTotal.text = ""
        hasilRerata.text = ""
        hasilKriteria.text = ""
        hasilStatus.text = ""

    }
}