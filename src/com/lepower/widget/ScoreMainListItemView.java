package com.lepower.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.lepower.R;

public class ScoreMainListItemView extends LinearLayout {
	//
	public ScoreMainListItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.score_main_listitem_view, this);
		
	}
	
}
