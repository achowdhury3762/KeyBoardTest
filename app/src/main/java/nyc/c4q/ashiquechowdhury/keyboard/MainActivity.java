package nyc.c4q.ashiquechowdhury.keyboard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import nyc.c4q.ashiquechowdhury.keyboard.model.AllKeys;
import nyc.c4q.ashiquechowdhury.keyboard.model.Keys;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://jsjrobotics.nyc/";
    private RecyclerView keyRecycler;
    private List<Keys> myKeys;
    private String myString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyRecycler = (RecyclerView) findViewById(R.id.keyRView);
        keyRecycler.setLayoutManager(new LinearLayoutManager(this));
        new DownloadStringTask().execute();
    }

    @Override
    protected void onStop() {
        super.onResume();
        recreate();
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private class DownloadStringTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                myString = readUrl("http://jsjrobotics.nyc/cgi-bin/1_11_2017_exam.pl");
                Gson gson = new Gson();
                AllKeys allMyKeys = gson.fromJson(myString, AllKeys.class);
                myKeys = allMyKeys.getAvailablekeys();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            keyRecycler.setAdapter(new KeyAdapter(myKeys));
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}
