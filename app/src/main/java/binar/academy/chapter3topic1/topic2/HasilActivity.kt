package binar.academy.chapter3topic1.topic2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import binar.academy.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_hasil.*

class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        gotExplicit()
        gotBundle()
        gotSerializable()
        gotParcelable()

    }

    fun gotExplicit() {

        val dataUmur = intent.getStringExtra("age")
        val dataTB = intent.getStringExtra("height")
        val dataBB = intent.getStringExtra("weight")
        val dataIdeal = intent.getStringExtra("ideal")
        val dataCategory = intent.getStringExtra("category")

        hasilUmur_dua.text = dataUmur
        hasilTB_dua.text = dataTB
        hasilBB_dua.text = dataBB
        hasilBMI_dua.text = dataIdeal
        hasilKategori_dua.text = dataCategory

    }

    fun gotBundle() {

       val bundle = intent.extras
        hasilUmur_dua.setText(bundle!!.getString("age"))
        hasilTB_dua.setText(bundle.getString("height"))
        hasilBB_dua.setText(bundle.getString("weight"))
        hasilBMI_dua.setText(bundle.getString("ideal"))
        hasilKategori_dua.setText(bundle.getString("category"))

    }

    fun gotSerializable() {

        val dataser = intent.getSerializableExtra("dataser") as HitungSerializable

        hasilUmur_dua.text = dataser.dataUmur
        hasilTB_dua.text = dataser.dataTinggi
        hasilBB_dua.text = dataser.dataBerat
        hasilBMI_dua.text = dataser.dataIdeal
        hasilKategori_dua.text = dataser.dataCategori

    }

    fun gotParcelable() {

        val datapar = intent.getParcelableExtra("datapar") as HitungParcelable?

        hasilUmur_dua.text = datapar!!.dataUmur
        hasilTB_dua.text = datapar.dataTinggi
        hasilBB_dua.text = datapar.dataBerat
        hasilBMI_dua.text = datapar.dataIdeal
        hasilKategori_dua.text = datapar.dataCategori

    }
}