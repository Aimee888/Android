package com.aimee.android.play.settinginfo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox mCb;
    private SharedPreferences mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCb = (CheckBox) findViewById(R.id.cb);
        mSp = getSharedPreferences("config", MODE_PRIVATE);

        boolean status = mSp.getBoolean("status", false);
        mCb.setChecked(status);

        mCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //
                }

                SharedPreferences.Editor editor = mSp.edit();
                editor.putBoolean("status",isChecked);
                editor.commit();//提交数据，类似关闭流，事务
            }
        });

        mCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"setOnClickListener",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
