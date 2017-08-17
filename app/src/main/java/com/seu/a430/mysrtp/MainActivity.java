package com.seu.a430.mysrtp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.SEARCH_SERVICE;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditText;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定布局文件
        setContentView(R.layout.activity_main);
        mTextView= (TextView) findViewById(R.id.textView3);
        mEditText= (EditText) findViewById(R.id.editText3);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                System.out.println("文字改变之前");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("正在改变");
            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("改变之后");
            }
        });
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(MainActivity.this,v.getText().toString(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    /**
     * 按钮单击事件方法：
     * 写法 public void 方法名（View v),除了方法名都是固定的
     * @param v
     */
    public void viewToast(View v){
        //getApplicationContext（）表示应用程序上下文，作用域为整个程序
        //this表示当前对象
        Toast.makeText(getApplicationContext(),"今天天气真不错",Toast.LENGTH_SHORT).show();
    }
    public void viewImage(View v){
        Toast t=new Toast(this);
        ImageView i=new ImageView(this);
        i.setImageResource(R.drawable.scence);
        t.setView(i);
        t.setDuration(Toast.LENGTH_SHORT);
        t.setGravity(Gravity.BOTTOM,0,0);
        t.show();
    }
}
