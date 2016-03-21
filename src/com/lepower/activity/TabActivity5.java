package com.lepower.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.lepower.R;

public class TabActivity5 extends Activity implements OnClickListener {

	private RelativeLayout rlPersonDataSet, rlBindAccount, rlRecommend,
			rlAppUpdate, rlAboutLePower;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab5);

		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		rlPersonDataSet = (RelativeLayout) findViewById(R.id.rlPersonDataSet);
		rlBindAccount = (RelativeLayout) findViewById(R.id.rlBindAccount);
		rlRecommend = (RelativeLayout) findViewById(R.id.rlRecommend);
		rlAppUpdate = (RelativeLayout) findViewById(R.id.rlAppUpdate);
		rlAboutLePower = (RelativeLayout) findViewById(R.id.rlAboutLePower);
		
		rlPersonDataSet.setOnClickListener(this);
		rlBindAccount.setOnClickListener(this);
		rlRecommend.setOnClickListener(this);
		rlAppUpdate.setOnClickListener(this);
		rlAboutLePower.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.rlPersonDataSet:
			Log.d("heheda", "rlPersonDataSet");
			Intent intent=new Intent(this,RegisterUserInfoActivity.class);
			startActivity(intent);
			
			break;

		case R.id.rlBindAccount:
			Log.d("heheda", "rlBindAccount");
			break;
		case R.id.rlRecommend:
			Log.d("heheda", "rlRecommend");
			break;
		case R.id.rlAppUpdate:
			Log.d("heheda", "rlAppUpdate");
			break;
		case R.id.rlAboutLePower:
			Log.d("heheda", "rlAboutLePower");
			break;
		default:
			break;

		}
	}
}
