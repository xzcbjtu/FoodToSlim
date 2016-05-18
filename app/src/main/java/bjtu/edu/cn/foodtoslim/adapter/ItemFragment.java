package bjtu.edu.cn.foodtoslim.adapter;

import bjtu.edu.cn.foodtoslim.login.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemFragment extends Fragment implements OnClickListener {

	private ImageView img;
	private TextView id;

	private int mImgInt;
	private String mTitle;

	public ItemFragment(int imgInt, String title) {
		mImgInt = imgInt;
		mTitle = title;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.item, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		img = (ImageView) getView().findViewById(R.id.img);
		id = (TextView) getView().findViewById(R.id.id);

		img.setImageResource(mImgInt);
		id.setText(mTitle);
		img.setOnClickListener((android.view.View.OnClickListener) this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.img){
			Toast.makeText(getActivity(), "当前点击为："+mTitle, Toast.LENGTH_SHORT);
		}
	}
}
