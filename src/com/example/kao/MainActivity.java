package com.example.kao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("登陆");
        
        //注册按钮点击事件
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
				
				startActivityForResult(intent, 200);
			}
		});
        
        //登陆按钮点击事件
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//找到账号密码输入框控件，设置点击事件
				EditText acc = (EditText) findViewById(R.id.acc);
				EditText pass = (EditText) findViewById(R.id.pass);
				String accStr = acc.getText().toString();
				String passStr = pass.getText().toString();
				if (accStr.isEmpty()||passStr.isEmpty()) {
					Toast.makeText(MainActivity.this, "账号或密码为空", Toast.LENGTH_SHORT).show();
				}
				String phone ="(135|133|139|185)[0-9]{8}";
				if (accStr.matches(phone))  {
					Toast.makeText(MainActivity.this, accStr+"欢迎你", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MainActivity.this, "账号不符合规则", Toast.LENGTH_SHORT).show();
					
				}
				
				
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	//判断请求码和结果码
    	if (requestCode==200&&resultCode==300) {
			String nameStr = data.getStringExtra("nameStr");
			String passStr = data.getStringExtra("passStr");
			
			EditText acc = (EditText) findViewById(R.id.acc);
			EditText pass = (EditText) findViewById(R.id.pass);
			//传值到页面
			acc.setText(nameStr);
			pass.setText(passStr);
			
		}
    }
}
