package sp.senai.br.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var etPeso: EditText? = null
    var etAltura: EditText? = null
    var btCalcular: Button? = null
    var btLimpar: Button? = null
    var tvResultado: TextView? = null
    var tvExibirResultado: TextView? = null
    var tvTabela: TextView? = null
    var ivImagem: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById<View>(R.id.etPeso) as EditText
        etAltura = findViewById<View>(R.id.etAltura) as EditText
        btCalcular = findViewById<View>(R.id.btCalcular) as Button
        btLimpar = findViewById<View>(R.id.btLimpar) as Button
        tvResultado = findViewById<View>(R.id.tvResultado) as TextView
        tvExibirResultado = findViewById<View>(R.id.tvExibirResultado) as TextView
        tvTabela = findViewById<View>(R.id.tvTabela) as TextView
        ivImagem = findViewById(R.id.ivImagem) as ImageView

        btCalcular!!.setOnClickListener { btCalcularOnClick() }
        btLimpar!!.setOnClickListener { btLimparOnClick() }

    }

    fun btCalcularOnClick() {
        var peso = etPeso!!.text.toString().toDouble()
        var altura = etAltura!!.text.toString().toDouble()
        var imc = peso / (altura * altura)
        tvExibirResultado!!.text = DecimalFormat("0.00").format(imc)


        if (imc <= 17) {
            tvTabela!!.text = "Muito Abaixo do Peso "
            ivImagem!!.setImageResource(R.drawable.imagem1)
            ivImagem!!.visibility = View.VISIBLE

        } else if (imc > 17 && imc <= 18.49){
            tvTabela!!.text = "Abaixo do peso"
            ivImagem!!.setImageResource(R.drawable.imagem2);
            ivImagem!!.visibility = View.VISIBLE}

        else if (imc >= 18.50 && imc <= 24.99){
            tvTabela!!.text = "Peso Normal"
            ivImagem!!.setImageResource(R.drawable.imagem3);
            ivImagem!!.visibility = View.VISIBLE}

        else if (imc >= 25 && imc <= 29.99){
            tvTabela!!.text = "Acima do peso"
            ivImagem!!.setImageResource(R.drawable.imagem4);
            ivImagem!!.visibility = View.VISIBLE}

        else if (imc > 30 && imc <= 34.99){
            tvTabela!!.text = "Obesidade I"
            ivImagem!!.setImageResource(R.drawable.imagem5);
            ivImagem!!.visibility = View.VISIBLE}

        else if (imc >= 35 && imc <= 39.99){
            tvTabela!!.text = "Obesidade II"
            ivImagem!!.setImageResource(R.drawable.imagem6);
            ivImagem!!.visibility = View.VISIBLE}

        else if (imc >= 40){
            tvTabela!!.text = "Obesidade III - Mórbida"
            ivImagem!!.setImageResource(R.drawable.imagem7);
            ivImagem!!.visibility = View.VISIBLE}
    }

    fun btLimparOnClick() {
        etPeso!!.setText("")
        etAltura!!.setText("")
        tvExibirResultado!!.setText("")
        tvTabela!!.setText("")
        ivImagem!!.setVisibility(View.INVISIBLE)
        etPeso!!.requestFocus()
    }

}