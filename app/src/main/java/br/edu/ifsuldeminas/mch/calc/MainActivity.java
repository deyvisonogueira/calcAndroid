//Deyvison Nogueira de Oliveira | RA:20211940042

package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonEquals, buttonC, buttonD, buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour,
            buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonComma;
    private TextView textViewResultado, textViewUltimaExpressao;
    private String expressao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().hide();

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
        buttonComma = findViewById(R.id.buttonVirgulaID);

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.length() > 0) { // Verifica se a expressão não está vazia
                    System.out.println(expressao);
                    expressao = expressao.substring(0, expressao.length()-1);
                    textViewUltimaExpressao.setText(expressao);
                    textViewResultado.setText("");
                }
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

        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.length() > 0) {
                    char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                    if (ultimoCaractere == '.') {
                        // Se o último caractere já for um ponto, não adiciona novamente
                        return;
                    } else if (ultimoCaractere == '-' || ultimoCaractere == '*' || ultimoCaractere == '/' || ultimoCaractere == '+') {

                        expressao = expressao.substring(0, expressao.length() - 1) + "+";
                    }
                }
                else {
                    // Se a expressão estiver vazia, não adiciona o sinal de ponto
                    return;
                }

                // Adiciona o sinal de ponto à expressão
                expressao += ".";
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.length() > 0) {
                    char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                    if (ultimoCaractere == '+') {
                        // Se o último caractere já for uma soma, não adiciona novamente
                        return;
                    } else if (ultimoCaractere == '-' || ultimoCaractere == '*' || ultimoCaractere == '/') {
                        // Se o último caractere for um sinal diferente de soma, substitui pelo sinal de soma
                        expressao = expressao.substring(0, expressao.length() - 1) + "";
                    }
                    if (expressao.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "A expressão não pode começar com um sinal de soma.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else {
                    // Se a expressão estiver vazia, não adiciona o sinal de soma
                    return;
                }



                // Adiciona o sinal de soma à expressão
                expressao += "+";
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });


        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.length() > 0) {
                    char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                    if (ultimoCaractere == '-') {

                        return;
                    } else if (ultimoCaractere == '+' || ultimoCaractere == '*' || ultimoCaractere == '/') {

                        expressao = expressao.substring(0, expressao.length() - 1) + "";
                    }
                }
                else {

                    return;
                }

                // Adiciona o sinal de soma à expressão
                expressao += "-";
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.length() > 0) {
                    char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                    if (ultimoCaractere == '*') {

                        return;
                    } else if (ultimoCaractere == '-' || ultimoCaractere == '+' || ultimoCaractere == '/') {

                        expressao = expressao.substring(0, expressao.length() - 1) + "";
                    }
                }
                else {

                    return;
                }

                // Adiciona o sinal de soma à expressão
                expressao += "*";
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.length() > 0) {
                    char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                    if (ultimoCaractere == '/') {

                        return;
                    } else if (ultimoCaractere == '-' || ultimoCaractere == '*' || ultimoCaractere == '+') {

                        expressao = expressao.substring(0, expressao.length() - 1) + "";
                    }
                }
                else {
                    // Se a expressão estiver vazia, não adiciona o sinal de soma
                    return;
                }

                // Adiciona o sinal de soma à expressão
                expressao += "/";
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });



        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifica se a expressão não termina com um sinal matemático
                if (expressao.matches(".*[+\\-*/]$")) {
                    Toast.makeText(MainActivity.this, "A expressão não pode terminar com um sinal matemático", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Calculable checandoExpressao = new ExpressionBuilder(expressao).build();

                        Double resultado = checandoExpressao.calculate();

                        textViewResultado.setText(resultado.toString());
                        textViewUltimaExpressao.setText(expressao);

                        // Limpa a expressão e adiciona o resultado como nova expressão
                        expressao = resultado.toString();
                    } catch (Exception e) {
                        Log.d(TAG, e.getMessage());
                    }
                }

            }
        });

    }
}

