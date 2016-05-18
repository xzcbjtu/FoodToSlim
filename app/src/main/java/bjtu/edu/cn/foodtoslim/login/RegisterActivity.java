package bjtu.edu.cn.foodtoslim.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity implements OnClickListener,TextWatcher{

	private Button mBtnRegister;
	private EditText username;
	private EditText paswd;
	private EditText confirm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		initView();
		
	}
	
	
	public void initView()
	{
		mBtnRegister = (Button) findViewById(R.id.register_btn);
		mBtnRegister.setOnClickListener(this);
		mBtnRegister.setEnabled(false);
		username = (EditText)findViewById(R.id.username);
		paswd = (EditText)findViewById(R.id.password);
		confirm = (EditText)findViewById(R.id.spassword);
		username.addTextChangedListener(this);
		confirm.addTextChangedListener(this);
		paswd.addTextChangedListener(this);
	}
	
	

	private Dialog mDialog = null;
	private void showRequestDialog()
	{
		if (mDialog != null)
		{
			mDialog.dismiss();
			mDialog = null;
		}
		mDialog = DialogFactory.creatRequestDialog(this, "正在注册中...");
		mDialog.show();
	}
	
	private void goFillInfor1Activity(){
		
		Intent intent = new Intent();
		intent.setClass(this, FillInfor1Activity.class);
		startActivity(intent);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.register_btn:
			//showRequestDialog();
			goFillInfor1Activity();
			
			break;
			default:
				break;
		}
	}

	 
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
		int nUsername = username.getText().toString().length();
		int nPaswd = paswd.getText().toString().length();
		int nConfirm = confirm.getText().toString().length();
		if((nUsername != 0) &&(nPaswd >= 6)&&(nPaswd == nConfirm))
		{
			mBtnRegister.setBackgroundColor(Color.parseColor("#00BB00"));
			mBtnRegister.setEnabled(true);
		}
		else
		{
			mBtnRegister.setBackgroundColor(Color.parseColor("#ADADAD"));
			mBtnRegister.setEnabled(false);
		}
		
		
	}


	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}
}
