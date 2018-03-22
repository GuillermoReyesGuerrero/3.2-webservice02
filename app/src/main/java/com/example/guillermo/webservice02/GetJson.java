package com.example.guillermo.webservice02;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by guillermo on 21/03/18.
 */

public class GetJson extends AsyncTask<Void,Void,Void> {

    String data ="";
    String datadst = "";
    String dataraw = "";
    String datastatus = "";
    String datazoneid = "";
    String datazonename = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //URL url = new URL("https://api.myjson.com/bins/1hewlv");
            URL url = new URL("https://maps.googleapis.com/maps/api/timezone/json?location=40.6643,-73.9385&timestamp=1521669765&language=es&key=AIzaSyDsFgjxU2TzsSNhyo9KMR7bAZsZA92AB1c");
            HttpURLConnection httpURLConnection = (HttpURLConnection)
                    url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject JO= new JSONObject(data);
            datadst="Diferencia horaria para el horario de verano: " + JO.get("dstOffset");
            dataraw="Diferencia horaria respecto de UTC: " + JO.get("rawOffset");
            datastatus="Esatdo de la respuesta: " + JO.get("status");
            datazoneid="Id de -tz- de la zona horaria: " + JO.get("timeZoneId");
            datazonename="Nombre en formato largo de la zona horaria: " + JO.get("timeZoneName");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.datadst.setText(this.datadst);
        MainActivity.dataraw.setText(this.dataraw);
        MainActivity.datastatus.setText(this.datastatus);
        MainActivity.datazoneid.setText(this.datazoneid);
        MainActivity.datazonename.setText(this.datazonename);
    }
}
