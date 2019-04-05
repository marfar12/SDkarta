package com.example.nax.sdkarta;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ukladanie {
    public void ulozenie(Context context, File file, Float mzda, String cistaMzda, String nemocenske, String starobne, String invalidne, String nezamestnanost, String socialna, String zdravotne, String odvody, String dan, String deti, CheckBox checkBoxManzelka){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file, true));
            br.write("Hrubá mzda:" + mzda);
            br.write("\n");
            br.write("Čistá mzda:" + cistaMzda);
            br.write("\n");
            br.write("Nemocenské poistenie:" + nemocenske);
            br.write("\n");
            br.write("Starobné poistenie:" + starobne);
            br.write("\n");
            br.write("Invalidné poistenie:" + invalidne);
            br.write("\n");
            br.write("Poistenie v nezamestnanosti:" + nezamestnanost);
            br.write("\n");
            br.write("Sociálna poisťovňa:" + socialna);
            br.write("\n");
            br.write("Zdravotné poistenie:" + zdravotne);
            br.write("\n");
            br.write("Odvody spolu:" + odvody);
            br.write("\n");
            br.write("Daň z príjmu:" + dan);
            br.write("\n");
            br.write("Počet detí:" + deti);
            br.write("\n");
            if (checkBoxManzelka.isChecked()){
                br.write("Manželka:true");
            }
            else {
                br.write("Manželka:false");
            }
            br.write("\n------------------------------\n");
            br.flush();
            br.close();
            Toast.makeText(context , R.string.toast_ulozit, Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(context , R.string.toast_chyba_zapisovania, Toast.LENGTH_SHORT).show();
        }
    }
}
