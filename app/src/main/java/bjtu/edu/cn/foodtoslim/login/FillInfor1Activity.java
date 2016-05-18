package bjtu.edu.cn.foodtoslim.login;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker.OnDateChangedListener;

public class FillInfor1Activity extends Activity implements OnClickListener,TextWatcher,OnDateChangedListener{

	
	private DatePicker datePicker;
	private Button btNext;
	private TextView birthText;
	private EditText heightedit;
	private EditText weightedit;
	private RadioGroup rg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infor1);
		initView();
	
		
	}
	
	private void initView()
	{
		btNext = (Button)findViewById(R.id.btNext);
		btNext.setOnClickListener(this);
		btNext.setEnabled(false);
		datePicker = (DatePicker)findViewById(R.id.dpPicker);
		datePicker.init(Calendar.getInstance().get(Calendar.YEAR),
				Calendar.getInstance().get(Calendar.MONTH),
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH), this);
		birthText = (TextView)findViewById(R.id.birthday);
		birthText.setOnClickListener(this);
		heightedit = (EditText)findViewById(R.id.height);
		heightedit.addTextChangedListener(this);
		weightedit = (EditText)findViewById(R.id.weight);
		weightedit.addTextChangedListener(this);
	    rg = (RadioGroup)findViewById(R.id.rBtGroup1);

		
	}

	private void goNextActivity()
	{
		datePicker.setVisibility(View.INVISIBLE);
		Intent intent = new Intent();
		intent.setClass(this,FillInfor2Activity.class );
		startActivity(intent);
	}
	private void showDatePicker()
	{
	
		datePicker.setVisibility(View.VISIBLE);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		
		case R.id.birthday:
			showDatePicker();
			break;
		case R.id.btNext:
			goNextActivity();
			break;
		default:
		    datePicker.setVisibility(View.INVISIBLE);
			break;
		}
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		int nheight = heightedit.getText().toString().length();
		int nweight = weightedit.getText().toString().length();
		
		
		if((nheight >=1)&&(nweight>=1))
		{
			btNext.setBackgroundColor(Color.parseColor("#00BB00"));
			btNext.setEnabled(true);
			
		}
		else
		{
			btNext.setBackgroundColor(Color.parseColor("#ADADAD"));
			btNext.setEnabled(false);
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

	@Override
	public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		birthText.setText(arg1+"-"+(arg2+1)+"-"+arg3);
		
	}
	
}
