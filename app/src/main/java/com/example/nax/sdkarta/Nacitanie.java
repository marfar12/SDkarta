package com.example.nax.sdkarta;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Nacitanie {
    private Context context;
    private File file;
    private CheckBox checkBoxManzelka;
    private EditText editTextHrubaMzda, editTextDeti;
    private TextView textViewCistaMzda, textViewNemocenskeHodnota, textViewStarobneHodnota, textViewInvalidneHodnota, textViewNezamestnanostHodnota, textViewSocialnaHodnota, textViewZdravotneHodnota, textViewOdvodyHodnota, textViewDanHodnota;

    public  Nacitanie(Context context, File file, EditText editTextHrubaMzda, EditText editTextDeti, TextView textViewCistaMzda, TextView textViewNemocenskeHodnota, TextView textViewStarobneHodnota, TextView textViewInvalidneHodnota, TextView textViewNezamestnanostHodnota, TextView textViewSocialnaHodnota, TextView textViewZdravotneHodnota, TextView textViewOdvodyHodnota, TextView textViewDanHodnota, CheckBox checkBoxManzelka){
        this.context = context;
        this.file = file;
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
        this.checkBoxManzelka = checkBoxManzelka;
    }

    public void nacitanie(){
        try {
            if (!file.exists()){
                Toast.makeText(context, R.string.toast_subor_neexistuje, Toast.LENGTH_SHORT).show();
                editTextHrubaMzda.setText(null);
                textViewCistaMzda.setText(null);
                editTextDeti.setText(null);
                textViewNemocenskeHodnota.setText(R.string.pociatocna_hodnota);
                textViewNemocenskeHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                textViewStarobneHodnota.setText(R.string.pociatocna_hodnota);
                textViewStarobneHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                textViewInvalidneHodnota.setText(R.string.pociatocna_hodnota);
                textViewInvalidneHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                textViewNezamestnanostHodnota.setText((R.string.pociatocna_hodnota));
                textViewNezamestnanostHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                textViewSocialnaHodnota.setText((R.string.pociatocna_hodnota));
                textViewSocialnaHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                textViewZdravotneHodnota.setText(R.string.pociatocna_hodnota);
                textViewZdravotneHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                textViewOdvodyHodnota.setText(R.string.pociatocna_hodnota);
                textViewOdvodyHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                textViewDanHodnota.setText(R.string.pociatocna_hodnota);
                textViewDanHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
            }
            else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                editTextHrubaMzda.setText(reader.readLine().substring(11));
                textViewCistaMzda.setText(context.getResources().getString(R.string.eur,reader.readLine().substring(11)));
                textViewNemocenskeHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(21)));
                textViewNemocenskeHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                textViewStarobneHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(19)));
                textViewStarobneHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                textViewInvalidneHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(20)));
                textViewInvalidneHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                textViewNezamestnanostHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(28)));
                textViewNezamestnanostHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                textViewSocialnaHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(19)));
                textViewSocialnaHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                textViewZdravotneHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(20)));
                textViewZdravotneHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                textViewOdvodyHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(13)));
                textViewOdvodyHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                textViewDanHodnota.setText(context.getString(R.string.eur,reader.readLine().substring(13)));
                editTextDeti.setText(reader.readLine().substring(11));
                if (textViewDanHodnota.getText().toString().equals("0 €")){
                    textViewDanHodnota.setTextColor(context.getResources().getColor(R.color.default_value_color));
                }
                else {
                    textViewDanHodnota.setTextColor(context.getResources().getColor(R.color.value_color));
                }
                if (reader.readLine().equals("Manželka:true")){
                    checkBoxManzelka.setChecked(true);
                }
                else {
                    checkBoxManzelka.setChecked(false);
                }
                reader.close();
            }
            Toast.makeText(context, R.string.toast_nacitane, Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Toast.makeText(context, R.string.toast_chyba, Toast.LENGTH_SHORT).show();
        }
    }
}
