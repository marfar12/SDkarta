package com.example.nax.sdkarta;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Locale;

public class Vypocitanie {
    private Context context;
    private File file;
    private EditText editTextHrubaMzda, editTextDeti;
    private TextView textViewCistaMzda, textViewNemocenskeHodnota, textViewStarobneHodnota, textViewInvalidneHodnota, textViewNezamestnanostHodnota, textViewSocialnaHodnota, textViewZdravotneHodnota, textViewOdvodyHodnota, textViewDanHodnota;
    private CheckBox checkBoxManzelka;
    private Ukladanie ukladladanie = new Ukladanie();

    public  Vypocitanie(Context context, File file, CheckBox checkBoxManzelka, EditText editTextHrubaMzda, EditText editTextDeti, TextView textViewCistaMzda, TextView textViewNemocenskeHodnota, TextView textViewStarobneHodnota, TextView textViewInvalidneHodnota, TextView textViewNezamestnanostHodnota, TextView textViewSocialnaHodnota, TextView textViewZdravotneHodnota, TextView textViewOdvodyHodnota, TextView textViewDanHodnota){
        this.context = context;
        this.file = file;
        this.checkBoxManzelka = checkBoxManzelka;
        this.editTextHrubaMzda = editTextHrubaMzda;
        this.editTextDeti = editTextDeti;
        this.textViewCistaMzda = textViewCistaMzda;
        this.textViewNemocenskeHodnota = textViewNemocenskeHodnota;
        this.textViewStarobneHodnota = textViewStarobneHodnota;
        this.textViewInvalidneHodnota = textViewInvalidneHodnota;
        this.textViewNezamestnanostHodnota = textViewNezamestnanostHodnota;
        this.textViewSocialnaHodnota = textViewSocialnaHodnota;
        this.textViewZdravotneHodnota = textViewZdravotneHodnota;
        this.textViewOdvodyHodnota = textViewOdvodyHodnota;
        this.textViewDanHodnota = textViewDanHodnota;
    }

    public void vypocitanie(){
        String nemocenske, starobne, invalidne, nezamestnanost, socialna, zdravotne, odvody, dan, cistaMzda, deti;

        if (!editTextHrubaMzda.getText().toString().equals("") && Float.parseFloat(editTextHrubaMzda.getText().toString()) >= 200) {
            Float mzda = Float.parseFloat(editTextHrubaMzda.getText().toString());
            nemocenske = String.format(Locale.ENGLISH, "%.2f", mzda * 0.014f);
            textViewNemocenskeHodnota.setText(context.getString(R.string.eur, nemocenske));
            textViewNemocenskeHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
            starobne = String.format(Locale.ENGLISH, "%.2f", mzda * 0.04f);
            textViewStarobneHodnota.setText(context.getString(R.string.eur, starobne));
            textViewStarobneHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
            invalidne = String.format(Locale.ENGLISH, "%.2f", mzda * 0.03f);
            textViewInvalidneHodnota.setText(context.getString(R.string.eur, invalidne));
            textViewInvalidneHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
            nezamestnanost = String.format(Locale.ENGLISH, "%.2f", mzda * 0.01f);
            textViewNezamestnanostHodnota.setText(context.getString(R.string.eur, nezamestnanost));
            textViewNezamestnanostHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
            socialna = String.format(Locale.ENGLISH, "%.2f", mzda * 0.094);
            textViewSocialnaHodnota.setText(context.getString(R.string.eur, socialna));
            textViewSocialnaHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
            zdravotne = String.format(Locale.ENGLISH, "%.2f", mzda * 0.04);
            textViewZdravotneHodnota.setText(context.getString(R.string.eur, zdravotne));
            textViewZdravotneHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
            odvody = String.format(Locale.ENGLISH, "%.2f", mzda * 0.134f);
            textViewOdvodyHodnota.setText(context.getString(R.string.eur, odvody));
            textViewOdvodyHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
            if (mzda >= 376) {
                if (!checkBoxManzelka.isChecked()) {
                    dan = String.format(Locale.ENGLISH, "%.2f", (mzda - mzda * 0.134f - 316.94f) * 0.19f);
                    textViewDanHodnota.setText(context.getString(R.string.eur, dan));
                    textViewDanHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                }
                else {
                    dan = "0";
                    textViewDanHodnota.setText(context.getString(R.string.eur, dan));
                    textViewDanHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                }
                if (editTextDeti.getText().toString().isEmpty()){
                    deti = "0";
                }
                else {
                    if (Integer.parseInt(editTextDeti.getText().toString()) > 10) {
                        deti = "10";
                        editTextDeti.setText(context.getResources().getString(R.string.deti_max));
                    }
                    else {
                        deti = editTextDeti.getText().toString();
                    }
                }
                cistaMzda = String.format(Locale.ENGLISH, "%.2f", mzda - Float.parseFloat(odvody) - Float.parseFloat(dan) + Float.parseFloat(deti) * 21.41);
                textViewCistaMzda.setText(context.getString(R.string.eur, cistaMzda));
            }
            else {
                dan = "0";
                textViewDanHodnota.setText(context.getString(R.string.eur, dan));
                textViewDanHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                if (editTextDeti.getText().toString().isEmpty()){
                    deti = "0";
                }
                else {
                    if (Integer.parseInt(editTextDeti.getText().toString()) > 10) {
                        deti = "10";
                        editTextDeti.setText(context.getResources().getString(R.string.deti_max));
                    }
                    else {
                        deti = editTextDeti.getText().toString();
                    }
                }
                cistaMzda = String.format(Locale.ENGLISH, "%.2f", mzda - Float.parseFloat(odvody) + Float.parseFloat(deti) * 21.41);
                textViewCistaMzda.setText(context.getString(R.string.eur, cistaMzda));
            }

            ukladladanie.ulozenie(context, file, mzda, cistaMzda, nemocenske, starobne, invalidne, nezamestnanost, socialna, zdravotne, odvody, dan, deti, checkBoxManzelka);
        }
        else {
            Toast.makeText(context, R.string.toast_minimalna_mzda, Toast.LENGTH_SHORT).show();
        }
    }
}
