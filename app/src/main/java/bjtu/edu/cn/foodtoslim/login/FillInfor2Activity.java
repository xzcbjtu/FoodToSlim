package bjtu.edu.cn.foodtoslim.login;


import java.util.Calendar;

import bjtu.edu.cn.foodtoslim.main.FragmentTab;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TextView;

public class FillInfor2Activity extends Activity implements  OnClickListener,TextWatcher,OnDateChangedListener{

	
	private EditText goalWeight;
	private TextView period;
	private DatePicker dap;
	private Button btFinish;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infor2);
		initView();
	}

	
	
	
	private void initView()
	{
		btFinish = (Button)findViewById(R.id.btFininsh);
		btFinish.setEnabled(false);
		btFinish.setOnClickListener(this);
		goalWeight = (EditText)findViewById(R.id.goalweight);
		goalWeight.addTextChangedListener(this);
		period = (TextView)findViewById(R.id.period);
		period.setOnClickListener(this);
		dap = (DatePicker)findViewById(R.id.dpPicker);
		dap.init(Calendar.getInstance().get(Calendar.YEAR),
				Calendar.getInstance().get(Calendar.MONTH),
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH), this);
	}
	
	
	
	












	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		period.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
	}









	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
		int nweight = goalWeight.getText().toString().length();
		if(nweight >=0)
		{
			btFinish.setBackgroundColor(Color.parseColor("#00BB00"));
			btFinish.setEnabled(true);
			
		}
		else
		{
			btFinish.setBackgroundColor(Color.parseColor("#ADADAD"));
			btFinish.setEnabled(false);
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



	private void showDatePicker()
	{
	
		dap.setVisibility(View.VISIBLE);
	}





	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		
		case R.id.period:
			showDatePicker();
			break;
		case R.id.btFininsh:
			goNextActivity();
			break;
		default:
		    //datePicker.setVisibility(View.INVISIBLE);
			break;
		}
		
	}




	private void goNextActivity() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(this, FragmentTab.class);
		startActivity(intent);
		
	}
}
