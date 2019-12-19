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
        setTitle("��½");
        
        //ע�ᰴť����¼�
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
				
				startActivityForResult(intent, 200);
			}
		});
        
        //��½��ť����¼�
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//�ҵ��˺����������ؼ������õ���¼�
				EditText acc = (EditText) findViewById(R.id.acc);
				EditText pass = (EditText) findViewById(R.id.pass);
				String accStr = acc.getText().toString();
				String passStr = pass.getText().toString();
				if (accStr.isEmpty()||passStr.isEmpty()) {
					Toast.makeText(MainActivity.this, "�˺Ż�����Ϊ��", Toast.LENGTH_SHORT).show();
				}
				String phone ="(135|133|139|185)[0-9]{8}";
				if (accStr.matches(phone))  {
					Toast.makeText(MainActivity.this, accStr+"��ӭ��", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MainActivity.this, "�˺Ų����Ϲ���", Toast.LENGTH_SHORT).show();
					
				}
				
				
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	//�ж�������ͽ����
    	if (requestCode==200&&resultCode==300) {
			String nameStr = data.getStringExtra("nameStr");
			String passStr = data.getStringExtra("passStr");
			
			EditText acc = (EditText) findViewById(R.id.acc);
			EditText pass = (EditText) findViewById(R.id.pass);
			//��ֵ��ҳ��
			acc.setText(nameStr);
			pass.setText(passStr);
			
		}
    }
}
