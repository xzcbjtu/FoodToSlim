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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class WeekPlanActivity extends Activity {

	
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weekplan);
		
		initView();
		
		
	}
	
	
	private void initView()
	{
        lv = (ListView)findViewById(R.id.weekplanlist);
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
                R.layout.weekitem, new String[] { "date", "way", "breakfast" ,"lunch","dinner"},
                new int[] { R.id.date, R.id.way, R.id.bre,R.id.lun,R.id.din });
        
        lv.setAdapter(adapter);//给listview设置适配器
        lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent();
				Bundle bundle = new Bundle();
				bundle.putInt("day", position);
				i.setClass(WeekPlanActivity.this, DayPlanActivity.class);
				i.putExtras(bundle);
				startActivity(i);
				
			}
        	
        	
        });
		
		
	}
	
	private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null ;
       
     
        for(int i= 0 ; i < 7;i++)
        {
        	map = new HashMap<String, Object>();
        	map.put("date",TimeUtil.getDate(i) );
            map.put("way", TimeUtil.getWay(i));
            list.add(map);
        }
      

        return list;
    }
	
	


}
