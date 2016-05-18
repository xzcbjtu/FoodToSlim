package bjtu.edu.cn.foodtoslim.login;

import bjtu.edu.cn.foodtoslim.main.FragmentTab;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends Activity implements OnClickListener{

	private Button mBtnRegister;
	private Button mBtnLogin;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
       
        initView();
    }
    
    
    public void initView()
    {
    	
    	
    	mBtnRegister = (Button) findViewById(R.id.regist);
    	mBtnRegister.setOnClickListener(this);
    	
    	mBtnLogin = (Button) findViewById(R.id.login);
    	mBtnLogin.setOnClickListener(this);
    }
    

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		
		case R.id.regist:
			goRegisterActivity();
			break;
		case R.id.login:
			goMainActivity();
			break;
			default:
				break;
		}
	}
    
    public void goRegisterActivity()
    {
    	Intent intent = new Intent();
    	intent.setClass(this, RegisterActivity.class);
    	startActivity(intent);
    }
	   public void goMainActivity()
	   {
		   Intent intent = new Intent();
		   intent.setClass(this, FragmentTab.class);
		   startActivity(intent);
	   }

	private Dialog mDialog = null;
	private void showRequestDialog()
	{
		if (mDialog != null)
		{
			mDialog.dismiss();
			mDialog = null;
		}
		mDialog = DialogFactory.creatRequestDialog(this, "正在验证账号...");
		mDialog.show();
	}
	
	
}
