package com.lepower.activity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.lepower.R;
import com.lepower.adapter.ImageGridAdapter;
import com.lepower.callback.TextCallback;
import com.lepower.model.AlbumHelper;
import com.lepower.model.Bimp;
import com.lepower.model.ImageItem;

public class ImageGridActivity extends Activity {
	public static final String EXTRA_IMAGE_LIST = "imagelist";
	String TAG="bbb";
	private TextView tV;
	// ArrayList<Entity> dataList;//鐢ㄦ潵瑁呰浇鏁版嵁婧愮殑鍒楄〃
	List<ImageItem> dataList;
	GridView gridView;
	ImageGridAdapter adapter;// 鑷畾涔夌殑閫傞厤鍣�
	AlbumHelper helper;
	Button bt;

	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				Toast.makeText(ImageGridActivity.this, "最多选择9张图片", 400).show();
				break;

			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_image_grid);
		//Log.i(TAG,"ImageGridActivity");
		helper = AlbumHelper.getHelper();
		helper.init(getApplicationContext());

		dataList = (List<ImageItem>) getIntent().getSerializableExtra(
				EXTRA_IMAGE_LIST);

		initView();
		bt = (Button) findViewById(R.id.bt);
		bt.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				ArrayList<String> list = new ArrayList<String>();
				Collection<String> c = adapter.map.values();
				Iterator<String> it = c.iterator();
				for (; it.hasNext();) {
					list.add(it.next());
				}

				if (Bimp.act_bool) {
					Intent intent = new Intent(ImageGridActivity.this,
							PublishedActivity.class);
					startActivity(intent);
					Bimp.act_bool = false;
				}
				for (int i = 0; i < list.size(); i++) {
					if (Bimp.drr.size() < 9) {
						Bimp.drr.add(list.get(i));
					}
				}
				finish();
			}

		});
	}

	/**
	 * 鍒濆鍖杤iew瑙嗗浘
	 */
	private void initView() {
		tV=(TextView)findViewById(R.id.tv);
		tV.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		gridView = (GridView) findViewById(R.id.gridviewa);
		gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter = new ImageGridAdapter(ImageGridActivity.this, dataList,
				mHandler);
		gridView.setAdapter(adapter);
		adapter.setTextCallback(new TextCallback() {
			public void onListen(int count) {
				bt.setText("完成" + "(" + count + ")");
			}
		});

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				/**
				 * 鏍规嵁position鍙傛暟锛屽彲浠ヨ幏寰楄窡GridView鐨勫瓙View鐩哥粦瀹氱殑瀹炰綋绫伙紝鐒跺悗鏍规嵁瀹冪殑isSelected鐘舵
				 * �锛� 鏉ュ垽鏂槸鍚︽樉绀洪�涓晥鏋溿� 鑷充簬閫変腑鏁堟灉鐨勮鍒欙紝涓嬮潰閫傞厤鍣ㄧ殑浠ｇ爜涓細鏈夎鏄�
				 */
				// if(dataList.get(position).isSelected()){
				// dataList.get(position).setSelected(false);
				// }else{
				// dataList.get(position).setSelected(true);
				// }
				/**
				 * 閫氱煡閫傞厤鍣紝缁戝畾鐨勬暟鎹彂鐢熶簡鏀瑰彉锛屽簲褰撳埛鏂拌鍥�
				 */
				adapter.notifyDataSetChanged();
			}

		});

	}
}
