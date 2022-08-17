package com.example.mywork10.UI.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mywork10.R;
import com.example.mywork10.Utils.ToastUtils;

/**
 * 注册页面
 */
public class RegisterActivity extends AppCompatActivity {

    EditText editTexName;
    EditText editTextPass;
    Button register;
    Button backLogin;
    Intent intent;

    public static final String UserName="user";
    public static final String Password="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editTexName=findViewById(R.id.res_name);
        editTextPass=findViewById(R.id.res_password);
        backLogin=findViewById(R.id.res_login);
        register=findViewById(R.id.res_res);
    }

    public void BackLogin(View view){
        intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void Register(View view){
        String userName=editTexName.getText().toString();
        String password=editTextPass.getText().toString();
        if (userName==null||password==null){
            //弹窗提示
            ToastUtils.show("用户名或密码不能为空");
        }else {
            //跳转登录
            intent=new Intent(this,LoginActivity.class);
            intent.putExtra(UserName,userName);
            intent.putExtra(Password,password);
            startActivity(intent);
        }

    }

}