package com.example.samsung.skaiciuotuvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button buttonSudetis , buttonAtimtis , buttonDalyba , buttonDaugyba , buttonSaknis, buttonLygu, buttonIstrinti;
    Button buttonVienas, buttonDu, buttonTrys, buttonKeturi, buttonPenki, buttonSesi, buttonSeptyni, buttonAstuoni, buttonDevyni;
    Button buttonNulis, buttonKablelis;

    TextView rezultatasView;
    EditText rezultatasEdit;

    private double pirmasisSK =  Double.NaN;
    private double antrasisSK;

    private static final char DAUGYBA = '*';
    private static final char DALYBA = '/';
    private static final char ATIMTIS = '-';
    private static final char SUDETIS = '+';
    private static final char SAKNIS = '√';

    private char SPRENDIMAS;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        buttonAtimtis = (Button) findViewById(R.id.buttonAtimtis);
        buttonDalyba = (Button) findViewById(R.id. buttonDalyba);
        buttonSaknis = (Button) findViewById(R.id.buttonSaknis);
        buttonSudetis = (Button) findViewById(R.id.buttonSudetis);
        buttonDaugyba = (Button) findViewById(R.id.buttonDaugyba);
        buttonLygu = (Button) findViewById(R.id.buttonLygu);
        buttonKablelis = (Button) findViewById(R.id.buttonKablelis);
        buttonIstrinti = (Button) findViewById(R.id.buttonIstrinti);

        buttonVienas = (Button) findViewById(R.id.buttonVienas);
        buttonDu = (Button) findViewById(R.id.buttonDu);
        buttonTrys = (Button) findViewById(R.id.buttonTrys);
        buttonKeturi = (Button) findViewById(R.id.buttonKeturi);
        buttonPenki = (Button) findViewById(R.id.buttonPenki);
        buttonSesi = (Button) findViewById(R.id.buttonSesi);
        buttonSeptyni = (Button) findViewById(R.id.buttonSeptyni);
        buttonAstuoni= (Button) findViewById(R.id.buttonAstuoni);
        buttonDevyni= (Button) findViewById(R.id.buttonDevyni);
        buttonNulis = (Button) findViewById(R.id.buttonNulis);

        rezultatasEdit =(EditText) findViewById(R.id.rezultatasEdit);
        rezultatasView =(TextView) findViewById(R.id.rezultatasView);



        buttonNulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "0");
            }
        });

        buttonVienas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "1");
            }
        });

        buttonDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "2");
            }
        });

        buttonTrys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "3");
            }
        });

        buttonKeturi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "4");
            }
        });

        buttonPenki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "5");
            }
        });

        buttonSesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "6");
            }
        });

        buttonSeptyni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "7");
            }
        });

        buttonAstuoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "8");
            }
        });

        buttonDevyni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + "9");
            }
        });

        buttonKablelis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatasEdit.setText(rezultatasEdit.getText() + ",");
            }
        });

        buttonSudetis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatoApskaiciavimas();
                SPRENDIMAS = SUDETIS;
                rezultatasView.setText(decimalFormat.format(pirmasisSK) + " + ");
                rezultatasEdit.setText(null);
            }
        });

        buttonAtimtis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatoApskaiciavimas();
                SPRENDIMAS = ATIMTIS;
                rezultatasView.setText(decimalFormat.format(pirmasisSK) + " - ");
                rezultatasEdit.setText(null);
            }
        });

        buttonDaugyba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatoApskaiciavimas();
                SPRENDIMAS = DAUGYBA;
               rezultatasView.setText(decimalFormat.format(pirmasisSK) + " * ");
                rezultatasEdit.setText(null);
            }
        });

        buttonDalyba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatoApskaiciavimas();
                SPRENDIMAS = DALYBA;
               rezultatasView.setText(decimalFormat.format(pirmasisSK) + " / ");
                rezultatasEdit.setText(null);
            }
        });

        buttonIstrinti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rezultatasEdit.getText().length() > 0) {
                    CharSequence currentText = rezultatasEdit.getText();
                    rezultatasEdit.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    pirmasisSK = Double.NaN;
                    antrasisSK = Double.NaN;
                    rezultatasEdit.setText("");
                    rezultatasView.setText("");
                }
            }
        });

        buttonSaknis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatoApskaiciavimas();
                SPRENDIMAS = SAKNIS;
               rezultatasView.setText(" √ " + decimalFormat.format(pirmasisSK));
                rezultatasEdit.setText(null);
            }
        });

        buttonLygu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rezultatoApskaiciavimas();
               rezultatasView.setText(rezultatasView.getText().toString() + decimalFormat.format(antrasisSK) +
                       " = " + decimalFormat.format(pirmasisSK));
                pirmasisSK = Double.NaN;
                SPRENDIMAS= '0';
                rezultatasEdit.setText(null);
            }
        });

    }

    private void rezultatoApskaiciavimas() {
        if(!Double.isNaN(pirmasisSK)) {

            antrasisSK = Double.parseDouble(rezultatasEdit.getText().toString());
            rezultatasEdit.setText(null);

            if(SPRENDIMAS == SUDETIS)
                pirmasisSK = this.pirmasisSK + antrasisSK;
            else if(SPRENDIMAS == ATIMTIS)
                pirmasisSK = this.pirmasisSK - antrasisSK;
            else if(SPRENDIMAS== DAUGYBA)
                pirmasisSK = this.pirmasisSK * antrasisSK;
            else if(SPRENDIMAS == DALYBA)
                pirmasisSK = this.pirmasisSK / antrasisSK;
            else if(SPRENDIMAS == SAKNIS)
                pirmasisSK = Math.sqrt(Math.abs(this.pirmasisSK));
        }
        else {
            try {
                pirmasisSK = Double.parseDouble(rezultatasEdit.getText().toString());
            }
            catch (Exception e){}
        }
    }




}