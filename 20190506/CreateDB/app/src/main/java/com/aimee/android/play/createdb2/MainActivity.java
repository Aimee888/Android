package com.aimee.android.play.createdb2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aimee.android.play.createdb2.dao.ContactInfoDao;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText mEtName;
    private EditText mEtPhone;
    private ContactInfoDao mDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.找到需要用到的控件
        mEtName = findViewById(R.id.et_name);
        mEtPhone = findViewById(R.id.et_phone);
        //2.new一个Dao对象出来
        mDao = new ContactInfoDao(this);

//        MyDBOpenHelper helper = new MyDBOpenHelper(this);
//        helper.getWritableDatabase();
    }

    /**
     * 添加一条联系人信息
     * @param view
     */
    public void add(View view){
        String name = mEtName.getText().toString().trim();
        String phone = mEtPhone.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone)){
            Toast.makeText(this,"不能为空",Toast.LENGTH_SHORT).show();
        }else {
            mDao.add(name,phone);
            Toast.makeText(this,"添加",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 删除一条联系人信息
     * @param view
     */
    public void delete(View view){
        String name = mEtName.getText().toString().trim();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"不能为空",Toast.LENGTH_SHORT).show();
        }else {
            mDao.delete(name);
            Toast.makeText(this,"删除",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 修改一条联系人信息
     * @param view
     */
    public void update(View view){
        String name = mEtName.getText().toString().trim();
        String phone = mEtPhone.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone)){
            Toast.makeText(this,"不能为空",Toast.LENGTH_SHORT).show();
        }else {
            mDao.update(name,phone);
            Toast.makeText(this,"修改",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 查询一条联系人信息
     * @param view
     */
    public void query(View view){
        String name = mEtName.getText().toString().trim();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"不能为空",Toast.LENGTH_SHORT).show();
        }else {
            String phone = mDao.query(name);
            Toast.makeText(this,"查询到的号码为"+phone,Toast.LENGTH_SHORT).show();
        }
    }
}
