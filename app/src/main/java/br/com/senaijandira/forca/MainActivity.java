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


    // Método que inicia o jogo
    public void iniciarJogo() {


        // Criando um Random
        random = new Random();

        // qtdDicas recebe o tamanho do vetor
        qtdDicas = dica.length;

        // indiceDica recebe um indice sorteado do vetor dicas
        indiceDica = random.nextInt(qtdDicas);

        // qtdPalavras recebe o tamanho das colunas da matriz
        qtdPalavras = palavra[0].length;

        // indiceSorteio recebe um indice sorteado do vetor
        sortearPalavra = random.nextInt(qtdPalavras);

        // palavraSorteada recebe a palavra referente a linha com indiceDica, coluna com indiceSorteio e com todas as letras maiúsculas
        palavraSorteada = palavra[indiceDica][sortearPalavra].toUpperCase();

        // Loop que conta até o tamanho da palavra sorteada
        for (int i = 0; i < palavraSorteada.length(); i++) {

            // A cada volta do loop, acrescenta um "_ " na palavraEscondida através do método append que concatena strings
            palavraEscondida.append("_ ");

        }

        // Exibindo na tela as letras escondidas da palavra
        txtPalavra.setText(palavraEscondida.toString());


        // Exibindo a quantidade de letras na palavra
        txtLetras.setText(palavraSorteada.length() + " letras");


        //iniciar a música
        mediaPlayer = MediaPlayer.create(this, R.raw.super_mario_world);
        mediaPlayer.start();



    }


    // Método que é chamado com o clique dos botões de A-Z
    public void pegarLetra(View view) {

        // botao recebe a view que foi clicada na tela
        Button botao = (Button) view;

        // letra recebe o texto que está no botão clicado
        String letra = botao.getText().toString();


        // compararAcertos recebe acertos
        compararAcertos = acertos;

        // Loop que conta até o tamanho da palavra sorteada
        for (int i = 0; i < palavraSorteada.length(); i++) {

            // Verefica se tem a letra clicada na palavra
            if (letra.equals(String.valueOf(palavraSorteada.charAt(i)))) {

                // Se tiver, troca o "_" pela letra digitada e acrescenta 1 nos acertos
                // i vai ser sempre * 2 para ignorar os espaços em palavraEscondida ao fazer a contagem
                palavraEscondida.setCharAt(i * 2, letra.charAt(0));
                acertos += 1;

            }
        }

        // Exibe a palavra escondida que vai atualizando
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
        btnZ = findViewById(R.id.btnZ);

        iniciarJogo();

    }

}


