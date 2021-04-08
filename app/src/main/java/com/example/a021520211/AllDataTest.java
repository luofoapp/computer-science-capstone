package com.example.a021520211;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

public class AllDataTest extends Fragment {
    ListView listView;
    String TAG = "THIS TAG RIGHT HERE";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.all_data_test_yuh, container, false);


//        setContentView(R.layout.activity_main);

        listView = (ListView) v.findViewById(R.id.listViewAA);
//        downloadJSON("https://127.0.0.1/app_info/app.php");
        downloadJSON("http://10.0.2.2/app_info/app.php");
//        downloadJSON("http://www.android.com/");

        return v;
    }



    private void downloadJSON(final String urlWebService) {


        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getActivity().getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    Log.d(TAG, "___________________________THIS IS THE TOP OF TRY");
                    URL url = new URL(urlWebService);
                    Log.d(TAG, "_______________HEREEEEEEEEEEEEEEEEEEEEEEEEEEE____________" + url);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    Log.d(TAG, "_______________________________________________" + con.getResponseCode());
                    InputStreamReader isrBR = new InputStreamReader(con.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(isrBR);
                    Log.d(TAG, "___________________________here was reached CCC");
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                        Log.d(TAG, "___________________________end of while");

                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    Log.d(TAG, "___________________________caught an exception" + e);
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        Log.d(TAG, "_______________hereeeeeeeeeeee____________");

        JSONArray jsonArray = new JSONArray(json);
        String[] usernameDB = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
//            usernameDB[i] = obj.getString("username");
            usernameDB[i] = obj.getString("username") + " " + obj.getString("email");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, usernameDB);
        listView.setAdapter(arrayAdapter);
    }




//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
//
//        listView = (ListView) getActivity().findViewById(R.id.listViewAA);
//        downloadJSON("https://127.0.0.1/app_info/app.php");
//    }
}
