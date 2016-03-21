package com.lepower.activity;

import android.annotation.SuppressLint;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.lepower.R;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup {
	//
	//V6是整合前备份
	private TabHost menuTabHost;

	private Class activitys[] = { ScoreMainActivity.class, MyCircleActivity.class,SportsStart.class, SelfActivity.class, TabActivity5.class };
	private String title[] = { "成绩", "乐圈", "", "乐我", "设置" };
	private int images[] = { R.drawable.item_menu_score,
			R.drawable.item_menu_runner, R.drawable.menu_start,R.drawable.item_menu_profile, R.drawable.item_menu_more };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initTabView();
	}

	@SuppressLint("NewApi")
	private void initTabView() {
		// TODO Auto-generated method stub
		this.menuTabHost = (TabHost) findViewById(R.id.menuTabhost);
		menuTabHost.setup(this.getLocalActivityManager());
		// 创建标签
		for (int i = 0; i < activitys.length; i++) {
			// 实例化一个View作为tab的标签布局
			View view;
			TabSpec spec;
			if (i != 2) {
				view = View.inflate(this, R.layout.tab_layout, null);
				// 设置标题
				TextView textView = (TextView) view.findViewById(R.id.tvTitle);
				textView.setText(title[i]);
				// 设置图标
				ImageView imageView = (ImageView) view.findViewById(R.id.tmMenuImage);
				imageView.setImageDrawable(getResources().getDrawable(images[i]));
			} else {// 中间只设置图标,这里代码有点乱
				view = View.inflate(this, R.layout.tab_layout_mid, null);
				ImageView imageView = (ImageView) view.findViewById(R.id.tmMenuImage);
				TextView textView = (TextView) view.findViewById(R.id.tvTitle);
				imageView.setImageDrawable(getResources().getDrawable(images[i]));
				imageView.setOnClickListener(new OnClickListener() {
					// 设置它的点击事件，这样点击之后才能有半透明的效果
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getApplicationContext(), SportsStart.class);
						startActivity(intent);
					}
				});
				textView.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getApplicationContext(),SportsStart.class);
						startActivity(intent);
					}
				});
			}
			// 设置跳转Intent
			Intent intent = new Intent(this, activitys[i]);
			spec = menuTabHost.newTabSpec(title[i]).setIndicator(view).setContent(intent);
			menuTabHost.addTab(spec);
		}

	}
}
