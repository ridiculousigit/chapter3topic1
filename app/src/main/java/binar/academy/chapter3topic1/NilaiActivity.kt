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

        btn_hitungNilai.setOnClickListener {

            var namaMahasiswa = editNama.text.toString()
            var nimMahasiswa = editNIM.text.toString()
            var uasMahasiswa = editUAS.text.toString()
            var utsMahasiswa = editUTS.text.toString()
            var tugasMahasiswa = editTugas.text.toString()
            var total = hitungTotal(uasMahasiswa.toDouble(), utsMahasiswa.toDouble(), tugasMahasiswa.toDouble())

            hasilNama.text = "${editNama.text}"
            hasilNIM.text = "${editNIM.text}"
            hasilUAS.text = "${editUAS.text}"
            hasilUTS.text = "${editUTS.text}"
            hasilTugas.text = "${editTugas.text}"
            hasilTotal.text = String.format("%.1f", total)
        }

        btn_resetNilai.setOnClickListener {

            reset()

        }

    }

    fun hitungTotal(UAS : Double, UTS : Double, Tugas : Double) : Double {

        var hasilTotal = UAS + UTS + Tugas

        return hasilTotal

    }



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