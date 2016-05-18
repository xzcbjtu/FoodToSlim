package bjtu.edu.cn.foodtoslim.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bjtu.edu.cn.foodtoslim.login.R;
import bjtu.edu.cn.foodtoslim.util.TimeUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class DayPlanActivity extends Activity {

	
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dayplan);
		
        initView();
        
		
	}

	
	private void initView()
	{
		
		Intent i = getIntent();
		Bundle bundle = i.getExtras();
		int day = bundle.getInt("day");
        lv = (ListView)findViewById(R.id.dayplanlist);
		
		SimpleAdapter adapter = new SimpleAdapter(this, getData(day),
                R.layout.dayplanitem, new String[] { "date", "way", "picture" ,"name","summary"},
                new int[] { R.id.redate, R.id.reway, R.id.repic,R.id.rename,R.id.rebrief });
        
        lv.setAdapter(adapter);//给listview设置适配器
        lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent();
				Bundle bundle = new Bundle();
				bundle.putInt("day", position);
				//i.setClass(WeekPlanActivity.this, DayPlanActivity.class);
				i.putExtras(bundle);
				startActivity(i);
				
			}
        	
        	
        });
		
	}
	
	
	private List<Map<String, Object>> getData(int i) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("date", "早餐·"+TimeUtil.getDate(i));
        map.put("way", "早上好，今天是"+TimeUtil.getWay(i));
        map.put("picture", R.drawable.bt1);
        map.put("name", "老北京懒龙");
        map.put("summary", "味道很不错，浓浓的肉香味。");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("date", "午餐·"+TimeUtil.getDate(i));
        map.put("way", "中午好，今天是"+TimeUtil.getWay(i));
        map.put("picture", R.drawable.lh1);
        map.put("name", "茄子烧土豆");
        map.put("summary", "鲜浓的味道、天然绿色的食材，涵盖多种食材的营养。");
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("date", "晚餐·"+TimeUtil.getDate(i));
        map.put("way", "晚上好，今天是"+TimeUtil.getWay(i));
        map.put("picture", R.drawable.dr1);
        map.put("name", "小炒豆腐干");
        map.put("summary", "非常家常的一道小菜。但是味道杠杠的。绝对好下饭。");
        list.add(map);
        
        

        return list;
    }
	
	
	
	
	
	
	
	
	
	
	
	

}
