package com.seu.a430.mysrtp;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

import static android.content.Context.SEARCH_SERVICE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private GridView gridView;
    private Button b1,b2,b3;
    private EditText mEditText;
    private ToggleButton toggleButton;
    private Switch switch1;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定布局文件
        setContentView(R.layout.activity_main);
        mEditText= (EditText) findViewById(R.id.editText3);
        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);
        gridView= (GridView) findViewById(R.id.gridview);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        switch1 = (android.widget.Switch) findViewById(R.id.switch1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"通过内部类实现按钮点击事件",Toast.LENGTH_SHORT).show();
            }
        });
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
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switch1.isChecked()){
                    Toast.makeText(MainActivity.this,"开",Toast.LENGTH_SHORT).show();
                }
            }
        });
        gridView.setAdapter(new MyAdpter(this));
    }


    static class   MyAdpter extends BaseAdapter{
        private int[] images={R.mipmap.ptr1,R.mipmap.ptr1,R.mipmap.ptr1,
                              R.mipmap.ptr1,R.mipmap.ptr1,R.mipmap.ptr2,};
        private Context context;
        public MyAdpter(Context context){
            this.context=context;
        }
        @Override
        //返回总数
        public int getCount() {
            return images.length;
        }

        @Override
        //获取每一个选项
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        //旋向的id
        public long getItemId(int position) {
            return position;
        }

        @Override
        //为每一个旋向生成视图，该方法会被多次调用
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView =new ImageView(context);
            imageView.setImageResource(images[position]);
            return imageView;
        }
    }

    /**
     * 按钮单击事件方法：
     * 写法 public void 方法名（View v),除了方法名都是固定的
     * @param v
     */
    public void viewToast(View v){
        //创建一个对话框的构建者
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("这是一个提示对话框");
        builder.setMessage("确定登录吗");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(this,"第一个通过监听器实现单击事件的按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(this,"第二个通过监听器实现单击事件的按钮",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }
}
