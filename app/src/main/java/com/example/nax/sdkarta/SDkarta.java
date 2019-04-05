package com.example.nax.sdkarta;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.io.File;

public class SDkarta extends AppCompatActivity {
    protected Button buttonSave, buttonOpen, buttonDelete;
    protected EditText editTextHrubaMzda, editTextDeti;
    protected TextView textViewCistaMzda, textViewNemocenskeHodnota, textViewStarobneHodnota, textViewInvalidneHodnota, textViewNezamestnanostHodnota, textViewSocialnaHodnota, textViewZdravotneHodnota, textViewOdvodyHodnota, textViewDanHodnota, textViewNemocenske, textViewStarobne, textViewInvalidne, textViewNezamestnanost, textViewSocialna, textViewZdravotne, textViewOdvody, textViewDan;
    protected CheckBox checkBoxManzelka;
    protected String path;
    protected File file;
    protected Boolean isExternal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdkarta);

        buttonSave = findViewById(R.id.buttonSave);
        buttonOpen = findViewById(R.id.buttonOpen);
        buttonDelete = findViewById(R.id.buttonDelete);
        editTextHrubaMzda = findViewById(R.id.editTextHrubaMzda);
        editTextDeti = findViewById(R.id.editTextDeti);
        textViewCistaMzda = findViewById(R.id.textViewCistaMzda);
        textViewNemocenskeHodnota = findViewById(R.id.textViewNemocenskeHodnota);
        textViewStarobneHodnota = findViewById(R.id.textViewStarobneHodnota);
        textViewInvalidneHodnota = findViewById(R.id.textViewInvalidneHodnota);
        textViewNezamestnanostHodnota = findViewById(R.id.textViewNezamestnanostHodnota);
        textViewSocialnaHodnota = findViewById(R.id.textViewSocialnaHodnota);
        textViewZdravotneHodnota = findViewById(R.id.textViewZdravotneHodnota);
        textViewOdvodyHodnota = findViewById(R.id.textViewOdvodyHodnota);
        textViewDanHodnota = findViewById(R.id.textViewDanHodnota);
        checkBoxManzelka = findViewById(R.id.checkBoxManzelka);
        textViewNemocenske = findViewById(R.id.textViewNemocenske);
        textViewStarobne = findViewById(R.id.textViewStarobne);
        textViewInvalidne = findViewById(R.id.textViewInvalidne);
        textViewNezamestnanost = findViewById(R.id.textViewNezamestnanost);
        textViewSocialna = findViewById(R.id.textViewSocialna);
        textViewZdravotne = findViewById(R.id.textViewZdravotne);
        textViewOdvody = findViewById(R.id.textViewOdvody);
        textViewDan = findViewById(R.id.textViewDan);

        final File[] storages = getExternalFilesDirs(null);
        String state = Environment.getExternalStorageState();
        if (storages.length > 1) {
            isExternal = Environment.isExternalStorageRemovable(storages[1]);
        }

        if (Environment.MEDIA_MOUNTED.equals(state) && isExternal) {

            path = String.valueOf(storages[1]);
        }
        else {
            path = String.valueOf(storages[0]);
        }

        file = new File(path, "DanovaKalkulackaData.txt");
        editTextHrubaMzda.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
        editTextDeti.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

        /**
         *
         * ROZDELENIE STRINGOV
         *
         */
        /*SpannableString ss1 = new SpannableString(getResources().getString(R.string.nemocenske));
        ss1.setSpan(new ForegroundColorSpan(Color.RED), 21, 27, 0);
        textViewNemocenske.setText(ss1);
        SpannableString ss2 = new SpannableString(getResources().getString(R.string.starobne));
        ss2.setSpan(new ForegroundColorSpan(Color.RED), 19, 25, 0);
        textViewStarobne.setText(ss2);
        SpannableString ss3 = new SpannableString(getResources().getString(R.string.invalidne));
        ss3.setSpan(new ForegroundColorSpan(Color.RED), 20, 26, 0);
        textViewInvalidne.setText(ss3);
        SpannableString ss4 = new SpannableString(getResources().getString(R.string.nezamestnanost));
        ss4.setSpan(new ForegroundColorSpan(Color.RED), 28, 34, 0);
        textViewNezamestnanost.setText(ss4);
        SpannableString ss5 = new SpannableString(getResources().getString(R.string.socialna));
        ss5.setSpan(new ForegroundColorSpan(Color.RED), 19, 25, 0);
        textViewSocialna.setText(ss5);
        SpannableString ss6 = new SpannableString(getResources().getString(R.string.zdravotne));
        ss6.setSpan(new ForegroundColorSpan(Color.RED), 20, 26, 0);
        textViewZdravotne.setText(ss6);
        SpannableString ss7 = new SpannableString(getResources().getString(R.string.odvody));
        ss7.setSpan(new ForegroundColorSpan(Color.RED), 13, 20, 0);
        textViewOdvody.setText(ss7);*/

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vypocitanie vypocitanie = new Vypocitanie(getApplicationContext(), file, checkBoxManzelka, editTextHrubaMzda, editTextDeti, textViewCistaMzda, textViewNemocenskeHodnota, textViewStarobneHodnota, textViewInvalidneHodnota, textViewNezamestnanostHodnota, textViewSocialnaHodnota, textViewZdravotneHodnota, textViewOdvodyHodnota, textViewDanHodnota);
                vypocitanie.vypocitanie();
            }
        });

        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nacitanie nacitanie = new Nacitanie(getApplicationContext(), file, editTextHrubaMzda, editTextDeti, textViewCistaMzda, textViewNemocenskeHodnota, textViewStarobneHodnota, textViewInvalidneHodnota, textViewNezamestnanostHodnota, textViewSocialnaHodnota, textViewZdravotneHodnota, textViewOdvodyHodnota, textViewDanHodnota, checkBoxManzelka);
                nacitanie.nacitanie();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vymazanie vymazanie = new Vymazanie();
                vymazanie.vymazanie(getApplicationContext(), file);
            }
        });
    }
}
