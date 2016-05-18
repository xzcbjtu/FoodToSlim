package bjtu.edu.cn.foodtoslim.main;
import bjtu.edu.cn.foodtoslim.activity.*;
import bjtu.edu.cn.foodtoslim.login.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class UserFrag extends Fragment implements OnClickListener{

	
	private View mParent;
	private FragmentActivity mActivity;
	private LinearLayout userdetail;
	
	
    public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		initView();
				
	}
	
    
    private void initView()
    {
    	mParent = getView();
		mActivity = getActivity();
		userdetail = (LinearLayout) mParent.findViewById(R.id.userdetail);
		userdetail.setOnClickListener(this);
    	
    }
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.activity_user, container, false);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		
		case R.id.userdetail:
			goDetailActivity();
			break;
		
		}
		
	}


	private void goDetailActivity() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.setClass(mActivity, UserDetailActivity.class);
		startActivity(i);		
	}

}
