package bjtu.edu.cn.foodtoslim.main;

import java.util.ArrayList;
import java.util.List;

import bjtu.edu.cn.foodtoslim.activity.RecipeActivity;
import bjtu.edu.cn.foodtoslim.adapter.MyItemAdapter;
import bjtu.edu.cn.foodtoslim.login.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchFrag extends Fragment implements OnTouchListener,OnClickListener{

    private View mParent;
	private FragmentActivity mActivity;
	//private int[] image = new int[] { R.drawable.apple, R.drawable.banana,	R.drawable.milk};
	private ViewPager view_pager;
	private ImageView breakimg;
	private ArrayList<Integer> imgList = new ArrayList<Integer>();
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		initView();
				
	}
	
	
	private void initView(){
		
		mParent = getView();
		mActivity = getActivity();
		
		view_pager = (ViewPager) mParent.findViewById(R.id.view_pager);
		breakimg = (ImageView)mParent.findViewById(R.id.breakfast);
		
	    initImg();
		List<View> mList = initImg();
		
		MyItemAdapter mAdapter=new MyItemAdapter(mList);
		view_pager.setAdapter(mAdapter);
		view_pager.setPageMargin(10);  
		view_pager.setOffscreenPageLimit(mList.size());

		mParent.findViewById(R.id.pager_layout).setOnTouchListener(this);
		breakimg.setOnClickListener(this);
		
	}
	
	
    private List<View> initImg()  {
    	
    	List<View> mList=new ArrayList<View>();
    	
    	imgList.add(R.drawable.t1);
    	imgList.add(R.drawable.t2);
    	imgList.add(R.drawable.t3);
    	imgList.add(R.drawable.t4);
    	imgList.add(R.drawable.t5);
    	imgList.add(R.drawable.t6);
    	imgList.add(R.drawable.t7);
    	imgList.add(R.drawable.t8);
    	
    	
    	
    	for (int i = 0;i < 8;i ++){
    		
    		View v=mActivity.getLayoutInflater().inflate(R.layout.item, null);
			((ImageView)v.findViewById(R.id.img)).setImageResource(imgList.get(i));
			((TextView)v.findViewById(R.id.id)).setText("id:"+i);;
			mList.add(v);
    		
    	}
    	return mList;
    			
	}

	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.activity_search, container, false);
		return view;
	}

	
	
	

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return view_pager.dispatchTouchEvent(event);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()){
		
		   case R.id.breakfast :
			   
			   goRecipeActivity();
			   break;	
		
		}	
		
	}
	
	

	private void goRecipeActivity() {
		// TODO Auto-generated method stub
		
		Intent i = new Intent();
		i.setClass(getActivity(), RecipeActivity.class);
		startActivity(i);
		
	}


	
	
	

}
