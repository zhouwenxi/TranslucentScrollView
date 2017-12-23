package com.zhou.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TranslucentScrollView translucentScrollView;
    private View zoomView;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        tv = findViewById(R.id.tv);
        translucentScrollView = findViewById(R.id.pullzoom_scrollview);
        zoomView = findViewById(R.id.lay_header);
        StatusBarUtils.darkMode(this);
        StatusBarUtils.setPaddingSmart(this, tv);



        //设置透明度变化监听
        translucentScrollView.setTranslucentChangedListener(new TranslucentScrollView.TranslucentChangedListener() {

            @Override
            public void onTranslucentChanged(int transAlpha) {

                Log.e("Tag","transAlpha:"+transAlpha);

                tv.setVisibility(transAlpha > 48 ? View.VISIBLE : View.GONE);
            }
        });
        //关联需要渐变的视图
        translucentScrollView.setTransView(tv);

        //关联伸缩的视图
        translucentScrollView.setPullZoomView(zoomView);
    }
}
