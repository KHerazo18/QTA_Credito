package com.example.qta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import java.lang.Math.pow
import kotlin.math.pow
import android.widget.Toast;

class cuota (val VP: Int, val EA: Double, val a: Int ){
    val i = ((EA/12)/100)
    val n = a*12
    fun calcular(): Double {
        return VP * ((1 + i.toDouble()).pow(n.toDouble()) *i/ (1 + i.toDouble()).pow(n.toDouble() - 1))
    }
}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val element = cuota(70000000,14.03,5)
        val btn_simular :Button = findViewById(R.id.btnSimular);
        val etValPro : EditText = findViewById<EditText?>(R.id.ma_et_1);
        val ValPro= etValPro.text.toString();
        val numPro: Double? = ValPro.toDoubleOrNull();
        val etCuantoNecesitas : EditText = findViewById(R.id.ma_ed_2);
        val CuantoNecesitas = etCuantoNecesitas.text.toString();
        val numCuantoN: Double? = CuantoNecesitas.toDoubleOrNull();
        val etPlazo : EditText = findViewById(R.id.ma_ed_3);
        val Plazo = etPlazo.text.toString();
        val numPlazo: Double? = Plazo.toDoubleOrNull();
        val etTasa : EditText = findViewById(R.id.ma_ed_4);
        val Tasa = etTasa.text.toString();
        val numTasa: Double? = Tasa.toDoubleOrNull();
        val tasaTotal= (numTasa!!/12)/100
        val VP = numPro!!-numCuantoN!!
        val cuota = VP *(((1 + tasaTotal ).pow(numPlazo!!) * tasaTotal )/((1 + tasaTotal).pow(numPlazo)-1))

        btn_simular.setOnClickListener{

        }

        Toast.makeText(this, cuota.toString(), Toast.LENGTH_LONG).show();


    }

}