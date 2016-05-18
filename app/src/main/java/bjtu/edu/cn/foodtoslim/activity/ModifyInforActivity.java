package bjtu.edu.cn.foodtoslim.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import bjtu.edu.cn.foodtoslim.login.R;

public class ModifyInforActivity extends Activity implements OnClickListener {

    private Button btok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifyinfor);
        initView();
    }

    private void initView() {

        btok = (Button)findViewById(R.id.btok);
        btok.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {

            case R.id.btok:
                goUserDetailActivity();
                break;

        }
    }

    private void goUserDetailActivity() {

        Intent i = new Intent();
        i.setClass(this,UserDetailActivity.class);
        this.finish();
        startActivity(i);

    }


}
