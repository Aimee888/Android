package com.aimee.android.play.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建Json
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("name","jadyli");
//            jsonObject.put("gender","male");
//            jsonObject.put("age","18");
//            System.out.println(jsonObject.toString(1));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        //解析Json
        String json = "{\"name\":\"jadyli\",\"gender\":\"male\",\"age\":18}";
        try {
            JSONObject jsonObject = new JSONObject(json);
            Log.i(TAG,"姓名: " + jsonObject.getString("name"));
            Log.i(TAG,"性别: " + jsonObject.getString("gender"));
            Log.i(TAG,"年龄: " + jsonObject.getString("age"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
