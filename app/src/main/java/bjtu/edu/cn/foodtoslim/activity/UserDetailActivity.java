package bjtu.edu.cn.foodtoslim.activity;

import bjtu.edu.cn.foodtoslim.login.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UserDetailActivity extends Activity {


	private Button btEdit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_detai);
		initView();
	}

	private void initView() {
		btEdit = (Button)findViewById(R.id.btEdit);
		btEdit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(UserDetailActivity.this,ModifyInforActivity.class);
				UserDetailActivity.this.finish();
				startActivity(i);


			}
		});
	}

}
