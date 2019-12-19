package com.example.kao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		setTitle("ע��");
		
		
		//��ע�ᰴť���õ���¼�
		Button register2=(Button) findViewById(R.id.register2);
		register2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//��ȡ�˺�����
				EditText userName = (EditText) findViewById(R.id.userName);
				EditText password = (EditText) findViewById(R.id.password);
				
				String nameStr = userName.getText().toString();
				String passStr = password.getText().toString();
				
				//�ж��˺������Ƿ�Ϊ��
				if (nameStr.isEmpty()||passStr.isEmpty()) {
					Toast.makeText(RegisterActivity.this, "�˺Ż�����Ϊ��", Toast.LENGTH_SHORT).show();
				}else {
					//��Ϊ����ֵ��ԭҳ��
					Intent intent = new Intent();
					intent.putExtra("nameStr", nameStr);
					intent.putExtra("passStr", passStr);
					
					setResult(300, intent);
					finish();
				}
				
				
				
			}
		});
		
				/*//���Ա����õ���¼�
				RadioGroup sex = (RadioGroup) findViewById(R.id.sex);
				sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						RadioButton man = (RadioButton) findViewById(R.id.man);
						if (man.isChecked()) {
							Toast.makeText(RegisterActivity.this, "��",Toast.LENGTH_SHORT).show();
						}else {
							Toast.makeText(RegisterActivity.this, "Ů",Toast.LENGTH_SHORT).show();					
						}
					}
				});*/
	}
}
