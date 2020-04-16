package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Welcome extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> students;
    private JSONArray result;
    private TextView textViewName;
    private TextView textViewCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        students = new ArrayList<String>();
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        textViewName = (TextView) findViewById(R.id.textView2);
        textViewCourse = (TextView) findViewById(R.id.textView3);
        //      getData();

    }
}
//
//    private void getData() {
//        StringRequest stringRequest = new StringRequest("your php script address",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        JSONObject j = null;
//                        try {
//                            j = new JSONObject(response);
//                            result = j.getJSONArray(Bitmap.Config.JSON_ARRAY);
//                            getStudents(result);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }
//
//    private void getStudents(JSONArray j){
//        for(int i=0;i<j.length();i++){
//            try {
//                JSONObject json = j.getJSONObject(i);
//                students.add(json.getString(Config.TAG_USERNAME));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        spinner.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, students));
//    }
//
//    private class StringRequest {
//    }
//}
//
//
//    }
//}
