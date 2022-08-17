package com.example.mywork10.UI.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mywork10.Bean.UserBean;
import com.example.mywork10.MainActivity;
import com.example.mywork10.R;
import com.example.mywork10.Utils.ToastUtils;
/**
 * 登录页面
 */
public class LoginActivity extends AppCompatActivity {

    EditText editTexName;
    EditText editTextPass;
    Button register;
    Button login;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editTexName=findViewById(R.id.log_name);
        editTextPass=findViewById(R.id.log_password);
        register=findViewById(R.id.log_register);
        login=findViewById(R.id.log_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onClickLogin(View v){
        //需要获取输入的用户名和密码
        String username=editTexName.getText().toString();
        String password=editTextPass.getText().toString();
        Intent intent=null;
        //匹配判断
        if (username.equals("wzj")&&password.equals("123456")){
            ToastUtils.show("登录成功 欢迎您");
            //登录成功则跳转
            intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            //登录失败
            Toast toastCenter=Toast.makeText(getApplicationContext(),"账号密码错误 请重新输入", Toast.LENGTH_SHORT);
            toastCenter.setGravity(Gravity.CENTER,0,0);
            toastCenter.show();
        }
    }

    /**
     * 跳转注册页面
     * @param v
     */
    public void onClickRegister(View v){
        intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}