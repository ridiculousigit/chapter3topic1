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

            val menu = Intent(this, MainActivity :: class.java)
            startActivity(menu)

        }

        // Tombol Hitung Nilai
        btn_hitungNilai.setOnClickListener {

            val namaMahasiswa = editNama.text.toString()
            val nimMahasiswa = editNIM.text.toString()
            val uasMahasiswa = editUAS.text.toString()
            val utsMahasiswa = editUTS.text.toString()
            val tugasMahasiswa = editTugas.text.toString()
            val total = hitungTotal(uasMahasiswa.toDouble(), utsMahasiswa.toDouble(), tugasMahasiswa.toDouble())
            val rerata = hitungRerata(total)
            val kriteria = kriteriaNilai(rerata)
            val kategori = kategoriNilai(kriteria)

            hasilNama.text = namaMahasiswa
            hasilNIM.text = nimMahasiswa
            hasilUAS.text = uasMahasiswa
            hasilUTS.text = utsMahasiswa
            hasilTugas.text = tugasMahasiswa
            hasilTotal.text = String.format("%.0f", total)
            hasilRerata.text = String.format("%.1f", rerata)
            hasilKriteria.text = kriteria
            hasilStatus.text = kategori

        }

        // Tombol Reset Nilai
        btn_resetNilai.setOnClickListener {

            reset()

        }

    }

    // Method Perhitungan Total
    private fun hitungTotal(UAS : Double, UTS : Double, Tugas : Double) : Double {

        return UAS + UTS + Tugas

    }

    // Method Perhitungan Rata - Rata
    private fun hitungRerata(hitungTotal : Double) : Double {

        return hitungTotal / 3

    }

    // Method Penentuan Kriteria Nilai
    private fun kriteriaNilai(hitungRerata : Double) : String {

        val kriteria : String = when (hitungRerata) {
            in 0.0..60.0 -> {
                "F"
            }
            in 61.0..70.0 -> {
                "D"
            }
            in 71.0..80.0 -> {
                "C"
            }
            in 81.0..90.0 -> {
                "B"
            }
            in 91.0..100.0 -> {
                "A"
            }
            else -> "Kriteria Nilai Tidak Valid"
        }

        return kriteria

    }

    // Method Penentuan Kategori Nilai
    private fun kategoriNilai(kriteriaNilai : String) : String {

        val kategori : String = when (kriteriaNilai) {
            "A" -> {
                "Lulus"
            }
            "B" -> {
                "Lulus"
            }
            "C" -> {
                "Lulus"
            }
            else -> "Tidak Lulus"
        }

        return kategori

    }

    // Method Tombol Reset Nilai
    private fun reset() {

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