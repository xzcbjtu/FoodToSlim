package bjtu.edu.cn.foodtoslim.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bjtu.edu.cn.foodtoslim.login.R;
import bjtu.edu.cn.foodtoslim.util.TimeUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

public class RecipeActivity extends Activity {

	
	
	
	private ScrollView scroll;
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recipe);
		initView();
		
	}

	
	
	private void initView()
	{
		
		scroll = (ScrollView)findViewById(R.id.scview);
		lv = (ListView)findViewById(R.id.processlist);
		SimpleAdapter adapter = new SimpleAdapter(this,getData(0) ,
                R.layout.processitem, new String[] {"picture" ,"name"},
                new int[] { R.id.propic,R.id.proname});
		lv.setAdapter(adapter);
		setListViewHeight(lv,adapter,2);
		
		
	}
	
	private void setListViewHeight(ListView listView, SimpleAdapter adapter,int count) 
	{
			int totalHeight = 0;
			for (int i = 0; i < count; i++) {
			View listItem = adapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
			}
			ViewGroup.LayoutParams params = listView.getLayoutParams();
			params.height = totalHeight + (listView.getDividerHeight() * count);
			listView.setLayoutParams(params);
	}
	
	
	private List<Map<String, Object>> getData(int i) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        
        
        map.put("picture", R.drawable.p1);
        map.put("name", "1. 先把酵母倒进水里搅拌均匀后揉成面团，发酵一个小时。");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("picture", R.drawable.p1);
        map.put("name", "1. 先把酵母倒进水里搅拌均匀后揉成面团，发酵一个小时。");
   
        list.add(map);
   
        

        return list;
    }
	
	

}
