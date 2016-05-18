package bjtu.edu.cn.foodtoslim.activity;

import bjtu.edu.cn.foodtoslim.util.ChartView;
import bjtu.edu.cn.foodtoslim.login.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HeightRecordActivity extends Activity {

	
	private ChartView chartView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.height_record);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		chartView = (ChartView)findViewById(R.id.myChartView);
		
		chartView.SetInfo(
				new String[] { "1", "2", "3", "4", "5",
						"6" }, // X轴刻度
				new String[] { "60", "65", "70", "75", "80", "85" }, // Y轴刻度
				new String[] { "75", "73", "69", "67", "63", "61" },
				new String[] { "60", "60", "60", "60", "60", "60" }// 数据

				);
		
	}


	

}
