package com.example.nax.sdkarta;

import android.content.Context;
import android.widget.Toast;
import java.io.File;

public class Vymazanie {
    public void vymazanie(Context context, File file){
        file.delete();
        Toast.makeText(context, R.string.toast_vymazat, Toast.LENGTH_SHORT).show();
    }
}
