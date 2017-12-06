package com.example.busreservation;

import java.util.ArrayList;


import com.quitz.test.db.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Operator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.operator);
		Button b=(Button) findViewById(R.id.button1);
		ListView li=(ListView)findViewById(R.id.listView1);
	
			ArrayList<String[]> DATA = new ArrayList<String[]>();
			
			  SQLiteHelper SQLHelper = new SQLiteHelper(this); 
		
			
			DATA=SQLHelper.selectalldatabase();
			if(!DATA.isEmpty())
			       li.setAdapter(new MyCustomBaseAdapter(this, DATA));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
