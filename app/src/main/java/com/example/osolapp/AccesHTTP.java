package com.example.osolapp;

import android.os.AsyncTask;
import android.util.Log;

import androidx.core.content.pm.PermissionInfoCompat;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.ArrayList;

/*
public class AccesHTTP extends AsyncTask<String, Integer,Long>{

    private ArrayList<NameValuePair> parametres;
    private String ret = null;
    public AsyncResponse delegate = null;

    public  AccesHTTP(){
        parametres = new ArrayList<NameValuePair>();
    }



    public void addParam(String nom, String valeur){
        parametres.add(new BasicNameValuePair(nom, valeur));
    }


    @Override
    protected Long doInBackground(String... strings){
        HttpClient cnxHttp = new DefaultHttpClient();
        HttpPost paramCnx = new HttpPost(strings[0]);

        try {
            //
            paramCnx.setEntity(new UrlEncodedFormEntity(parametres));
            HttpResponse reponse = cnxHttp.execute(paramCnx);
            ret = EntityUtils.toString(reponse.getEntity());
        }
        catch (UnsupportedEncodingException e){
            Log.d("erreur encodage","eeee"+e.toString());
        } catch (ClientProtocolException e) {
            Log.d("erreur protocole","eeee"+e.toString());
        } catch (IOException e) {
            Log.d("erreur I/O","eeee"+e.toString());
        }
        return null;
    }
     protected void onPostExecute(Long result){
        delegate.processFinish(ret.toString());

     }
}
*/