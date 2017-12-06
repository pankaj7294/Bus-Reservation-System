package com.example.busreservation;



import com.quitz.test.db.SQLiteHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

public class Busname extends Activity {
	private SQLiteHelper SQLHelper;
ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.busname);
		SQLHelper = new SQLiteHelper(this); 
		listView=(ListView)findViewById(R.id.listView1);
		String[] a = new String[] { "Bangalore Travels", "Trichy Travels", "Madurai Travels", "Coimbatore travels",
			"Salem Travels"	 };

		ArrayAdapter< String> f=new ArrayAdapter<String> (this,
				 android.R.layout.simple_list_item_1,a);
		listView.setAdapter(f);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2==0)
				{
					Intent i = new Intent(Busname.this, Businfo.class);
					i.putExtra("tr","BANGALORE TRAVELS" );
					i.putExtra("From","Chennai" );
			    	i.putExtra("To","Bangalore" );
			    	i.putExtra("dp","10:00 Pm" );
			    	i.putExtra("at","05:00 Am " );
			    	i.putExtra("r","500 " );
					startActivity(i);
				}
			
				else if(arg2==1)
				{
					Intent i= new Intent(Busname.this, Businfo.class);
					i.putExtra("tr","TRICHY TRAVELS" );
					i.putExtra("From","Chennai" );
			    	i.putExtra("To","Trichy" );
			    	i.putExtra("dp","08:00 Pm" );
			    	i.putExtra("at","05:00 Am " );
			    	i.putExtra("r","650 " );
					startActivity(i);
				}
					else if(arg2==2)
					{
						Intent i = new Intent(Busname.this,Businfo.class);
						i.putExtra("tr","MADURAI TRAVELS" );
						i.putExtra("From","Chennai" );
				    	i.putExtra("To","Madurai" );
				    	i.putExtra("dp","10:00 Pm" );
				    	i.putExtra("at","06:00 Am " );
				    	i.putExtra("r","600 " );
						startActivity(i);
					}
						else if(arg2==3)
						{
							Intent i = new Intent(Busname.this, Businfo.class);
							i.putExtra("tr","COIMBATORE TRAVELS" );
							i.putExtra("From","Chennai" );
					    	i.putExtra("To","Coimbatore" );
					    	i.putExtra("dp","08:45 Pm" );
					    	i.putExtra("at","06:30 Am " );
					    	i.putExtra("r","700 " );
					    	startActivity(i);
						}
						else if(arg2==4)
						{
							Intent i = new Intent(Busname.this, Businfo.class);
							i.putExtra("tr","SALEM TRAVELS" );
							i.putExtra("From","Chennai" );
					    	i.putExtra("To","Salem" );
					    	i.putExtra("dp","11:00 Pm" );
					    	i.putExtra("at","08:00 Am " );
					    	i.putExtra("r","550 " );
							startActivity(i);
						}
						
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

