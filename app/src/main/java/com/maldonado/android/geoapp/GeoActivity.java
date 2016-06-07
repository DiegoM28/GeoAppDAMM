package com.maldonado.android.geoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.maldonado.android.model.Preguntas;


public class GeoActivity extends AppCompatActivity {
    public static final String KEY_PREGUNTA_ACTUAL = "PreguntaActual";
    private Button mBotonCierto;
    private Button mBotonFalso;
    private Button mBotonSiguiente;
    private TextView mTextoPregunta;
    private Preguntas mBancoDePreguntas[] = {
            new Preguntas(R.string.texto_pregunta_1, false),
            new Preguntas(R.string.texto_pregunta_2, true),
            new Preguntas(R.string.texto_pregunta_3, true),
            new Preguntas(R.string.texto_pregunta_4, true),
            new Preguntas(R.string.texto_pregunta_5, false),
    };
    private int mPreguntaActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        mBotonCierto = (Button) findViewById(R.id.boton_cierto);
        mBotonFalso = (Button) findViewById(R.id.boton_falso);
        mBotonSiguiente = (Button) findViewById(R.id.boton_siguiente);
        mTextoPregunta = (TextView) findViewById(R.id.texto_pregunta);


        mBotonCierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(true);
            }
        });
        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(false);
            }
        });

        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPreguntaActual = mPreguntaActual + 1;
                if (mPreguntaActual == mBancoDePreguntas.length) {
                    mPreguntaActual = 0;
                }
                actualizarPregunta();
            }
        });



        if (savedInstanceState != null){
            mPreguntaActual = savedInstanceState.getInt(KEY_PREGUNTA_ACTUAL, 0);
        }

        actualizarPregunta();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_PREGUNTA_ACTUAL, mPreguntaActual);
    }

    private void actualizarPregunta() {
        int preguntaActual = mBancoDePreguntas[mPreguntaActual].getmIdResTexto();
        mTextoPregunta.setText(preguntaActual);
    }


    private void verificarRespuesta(boolean botonOprimido) {
        boolean respuestaEsVerdadera = mBancoDePreguntas[mPreguntaActual].ismRespuestaVerdadera();
        if (botonOprimido == respuestaEsVerdadera) {
            Toast.makeText(GeoActivity.this, R.string.texto_correcto, Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(GeoActivity.this, R.string.texto_incorrecto, Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
