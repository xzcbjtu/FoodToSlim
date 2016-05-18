package bjtu.edu.cn.foodtoslim.main;


import bjtu.edu.cn.foodtoslim.activity.*;
import bjtu.edu.cn.foodtoslim.login.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PlanFrag extends Fragment implements OnClickListener{


	
	private View mParent;
	private FragmentActivity mActivity;
	private LinearLayout plan;
	private LinearLayout record;
	private LinearLayout report;
	
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		initView();
				
	}
	
	private void initView()
	{
		
		mParent = getView();
		mActivity = getActivity();
		plan = (LinearLayout) mParent.findViewById(R.id.linearPlan);
		record = (LinearLayout) mParent.findViewById(R.id.linearRecord);
		report = (LinearLayout) mParent.findViewById(R.id.linearReport);
		plan.setOnClickListener(this);
		record.setOnClickListener(this);
		report.setOnClickListener(this);
		
		
	}
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.activity_plan, container, false);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		
		case R.id.linearPlan:
			
		    goPlanActivity();
		    break;
		
		case R.id.linearReport:
			goReportActivity();
			break;
		case R.id.linearRecord:
			goRecordActivity();
			break;
			
			
			
			
		
		
		}
		
	}

	private void goRecordActivity() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.setClass(mActivity, HeightRecordActivity.class);
		startActivity(i);
		
	}

	private void goReportActivity() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.setClass(mActivity, HealthReportActivity.class);
		startActivity(i);
		
	}

	private void goPlanActivity() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.setClass(mActivity, WeekPlanActivity.class);
		startActivity(i);
		
	}

}
