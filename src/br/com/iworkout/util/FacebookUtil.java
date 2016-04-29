package br.com.iworkout.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jorge on 15/7/2014.
 */
public class FacebookUtil extends AsyncTask<String, String, String> {

    private final Context context;

    public FacebookUtil(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        Log.i("Async-Example", "Começando download");
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            android.os.Debug.waitForDebugger();
            File file = new File(context.getFilesDir() + "/user_fb_photo.png");
            FileOutputStream out =  new FileOutputStream(file);
            URL img_url = new URL("http://graph.facebook.com/"+params[0]+"/picture?type=large");
            Bitmap mIcon1 = BitmapFactory.decodeStream(img_url.openConnection().getInputStream()); //ta ficando null
            mIcon1.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        }catch (Exception e){
            Log.i("Async-Example",e.getMessage().toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        /**
         * update ui thread and remove dialog
         */
        super.onPostExecute(result);
    }
}