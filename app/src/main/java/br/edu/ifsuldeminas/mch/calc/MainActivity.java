//Deyvison Nogueira de Oliveira | RA:20211940042

package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonEquals, buttonC, buttonD, buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour,
            buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    private TextView textViewResultado, textViewUltimaExpressao;
    private String expressao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonEquals = findViewById(R.id.buttonIgualID);
        buttonC = findViewById(R.id.buttonResetID);
        buttonD = findViewById(R.id.buttonDeleteID);
        buttonZero = findViewById(R.id.buttonZeroID);
        buttonOne = findViewById(R.id.buttonUmID);
        buttonTwo = findViewById(R.id.buttonDoisID);
        buttonThree = findViewById(R.id.buttonTresID);
        buttonFour = findViewById(R.id.buttonQuatroID);
        buttonFive = findViewById(R.id.buttonCincoID);
        buttonSix = findViewById(R.id.buttonSeisID);
        buttonSeven = findViewById(R.id.buttonSeteID);
        buttonEight = findViewById(R.id.buttonOitoID);
        buttonNine = findViewById(R.id.buttonNoveID);
        buttonPlus = findViewById(R.id.buttonSomaID);
        buttonMinus = findViewById(R.id.buttonSubtracaoID);
        buttonMultiply = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivide = findViewById(R.id.buttonDivisaoID);

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(expressao);
                expressao = expressao.substring(0,expressao.length()-1);
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao = "";
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "0";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "1";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "2";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "3";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "4";
                textViewUltimaExpressao.setText(expressao);
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "5";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "6";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "7";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "8";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "9";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "+";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "-";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "*";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "/";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable checandoExpressao = null;
                try {
                    checandoExpressao = new ExpressionBuilder(expressao).build();

                    Double resultado = checandoExpressao.calculate();

                    textViewResultado.setText(resultado.toString());
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }
}



