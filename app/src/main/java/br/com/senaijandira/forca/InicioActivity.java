package br.com.senaijandira.forca;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class InicioActivity  extends AppCompatActivity {
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Definindo o conteudo na tela, passando o arquivo xml
        setContentView(R.layout.activity_inicio);

        //inicializando o player com a musica do jogo
        mediaPlayer = MediaPlayer.create(this,
                R.raw.dragon_ball_z);

        mediaPlayer.setLooping(true);//para a musica ficar em looping
        mediaPlayer.start();//iniciar a musica

    }


    public void iniciarJogo(View v){
        //Parar a musica
        mediaPlayer.stop();

        //Abrir uma nova tela(Activity)
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();

    }
}
