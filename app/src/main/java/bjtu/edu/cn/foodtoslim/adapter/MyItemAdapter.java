package bjtu.edu.cn.foodtoslim.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MyItemAdapter extends PagerAdapter {
	
	private List<View> mList;
	
	public MyItemAdapter(List<View> list) {
		mList=list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	protected View getItem(int position) {
		return mList.get(position);
	}
	
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return (view == object);
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager)container).addView(getItem(position), position);
		return getItem(position);
	}

}
