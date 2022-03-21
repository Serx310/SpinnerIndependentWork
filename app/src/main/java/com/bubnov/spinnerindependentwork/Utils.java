package com.bubnov.spinnerindependentwork;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Utils {

    private List<Coffee> recipes;

    public final List getCoffeeFormJsonFile(Context context, String fileName){
        if (context != null){
            try {
                InputStream jsonStream = context.getAssets().open(fileName);
                Reader reader = (Reader) (new InputStreamReader(jsonStream, StandardCharsets.UTF_8));
                recipes = new Gson().fromJson(reader, new TypeToken<List<Coffee>>(){}.getType());
                reader.close();
            }catch (IOException ex){
                Log.e("Stream error - ", ex.toString());
            }
        }
        return recipes;
    }
}
