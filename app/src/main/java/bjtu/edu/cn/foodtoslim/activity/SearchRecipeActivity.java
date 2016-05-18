package bjtu.edu.cn.foodtoslim.activity;
import android.text.Editable;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import bjtu.edu.cn.foodtoslim.login.R;

public class SearchRecipeActivity extends Activity implements AdapterView.OnItemClickListener{


    private  AutoCompleteTextView autoinput;
    private ListView searchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchitem);
        initView();
    }

    private void initView() {

        autoinput =(AutoCompleteTextView) findViewById(R.id.autoText);
        autoinput.setThreshold(1);// 输入一个字母就开始自动提示
        searchList = (ListView)findViewById(R.id.searchlist);
        searchList.setOnItemClickListener(this);
        autoinput.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String str = s.toString();//str是目前已输入的字符串

                //String[] result =  XXX.search(str);
               // ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,result);
               // searchList.setAdapter(adapter);
               //searchList.setOnItemClickListener(new ItemClickEvent());给listview添加点击事件，跳转到菜谱模块







            }




            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

        });

    }


    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
        // TODO Auto-generated method stub
        //通过单击事件，获得单击选项的内容
        String text = (String) arg0.getItemAtPosition(arg2);//listview上面的内容

    }

}
