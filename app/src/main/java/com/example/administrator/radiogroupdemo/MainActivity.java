package com.example.administrator.radiogroupdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	GridRadioGroup mRbGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRbGroup = findViewById(R.id.rb_group);

		final List<String> list = new ArrayList<>();
		list.add("USD");
		list.add("KHR");
		list.add("BND");
		list.add("VMA");
		list.add("CBY");

		for (int i = 0; i < list.size(); i++) {
			// 设置间距
			GridRadioGroup.LayoutParams gl = new GridLayout.LayoutParams();
			gl.topMargin = (int) getResources().getDimension(R.dimen.dimen5);
			gl.leftMargin = (int) getResources().getDimension(R.dimen.dimen5);
			gl.rightMargin = (int) getResources().getDimension(R.dimen.dimen5);

			GridRadioButton grbCurrency = (GridRadioButton) getLayoutInflater().inflate(R.layout.view_radio_button_item, null);
			grbCurrency.setId(i);
			grbCurrency.setText(list.get(i));
			grbCurrency.setLayoutParams(gl);

			mRbGroup.addView(grbCurrency);
		}

		mRbGroup.setOnCheckedChangeListener(new GridRadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(View group, int checkedId) {
				int id = checkedId;
				if (id >= 0 && id < list.size()) Toast.makeText(MainActivity.this, "" + list.get(id), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
