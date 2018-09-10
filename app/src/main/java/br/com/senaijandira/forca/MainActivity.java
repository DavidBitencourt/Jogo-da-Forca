package br.com.senaijandira.forca;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    LinearLayout linear;

    MediaPlayer mediaPlayer;

    TextView txtPalavra, txtLetras, txtDicas;

    Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ;

    String palavra[][] = {
            {"senai", "etec", "dorvalino"},
            {"abacaxi", "morango", "abacate", "uva"},
            {"azul", "amarelo", "vermelho", "verde"},

    };

    String dica[] = {"escola", "fruta", "cor"};


    Random random;


    int qtdPalavras, sortearPalavra, qtdDicas, indiceDica, acertos, compararAcertos;

    String palavraSorteada;

    StringBuilder palavraEscondida = new StringBuilder();

    public void iniciarJogo() {


        random = new Random();

        qtdDicas = dica.length;


        indiceDica = random.nextInt(qtdDicas);

        qtdPalavras = palavra[0].length;

        sortearPalavra = random.nextInt(qtdPalavras);

        palavraSorteada = palavra[indiceDica][sortearPalavra].toUpperCase();

        for (int i = 0; i < palavraSorteada.length(); i++) {

            palavraEscondida.append("_ ");

        }


        txtPalavra.setText(palavraEscondida.toString());

        txtLetras.setText(palavraSorteada.length() + " letras");

        mediaPlayer = MediaPlayer.create(this, R.raw.super_mario_world);
        mediaPlayer.start();



    }


    public void pegarLetra(View view) {

        Button botao = (Button) view;

        String letra = botao.getText().toString();

        compararAcertos = acertos;

        for (int i = 0; i < palavraSorteada.length(); i++) {

            if (letra.equals(String.valueOf(palavraSorteada.charAt(i)))) {

                palavraEscondida.setCharAt(i * 2, letra.charAt(0));
                acertos += 1;

            }
        }

        txtPalavra.setText(palavraEscondida.toString());


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linear = findViewById(R.id.linear);

        txtPalavra = findViewById(R.id.txtPalavra);
        txtLetras = findViewById(R.id.txtLetras);
        txtDicas = findViewById(R.id.txtDicas);
/*
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);
        btnG = findViewById(R.id.btnG);
        btnH = findViewById(R.id.btnH);
        btnI = findViewById(R.id.btnI);
        btnJ = findViewById(R.id.btnJ);
        btnK = findViewById(R.id.btnK);
        btnL = findViewById(R.id.btnL);
        btnM = findViewById(R.id.btnM);
        btnN = findViewById(R.id.btnN);
        btnO = findViewById(R.id.btnO);
        btnP = findViewById(R.id.btnP);
        btnQ = findViewById(R.id.btnQ);
        btnR = findViewById(R.id.btnR);
        btnS = findViewById(R.id.btnS);
        btnT = findViewById(R.id.btnT);
        btnU = findViewById(R.id.btnU);
        btnV = findViewById(R.id.btnV);
        btnW = findViewById(R.id.btnW);
        btnX = findViewById(R.id.btnX);
        btnY = findViewById(R.id.btnY);
        btnZ = findViewById(R.id.btnZ);*/

        iniciarJogo();

    }

}


