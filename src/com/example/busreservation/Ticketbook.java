package com.example.busreservation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.quitz.test.db.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Ticketbook extends Activity {
	private SQLiteHelper SQLHelper;
	public String si=null;
	public String n=null;
	public String tr;
	public String from;
	public String dp;
	public String at;
	public String r;
	public String content;
	public String to;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticketbook);
		SQLHelper = new SQLiteHelper(this); 
		 TextView t6=(TextView)findViewById(R.id.textView1);
		 final TextView t7=(TextView)findViewById(R.id.textView4);
final EditText e1=(EditText)findViewById(R.id.editText1);



final Spinner s=(Spinner)findViewById(R.id.spinner1);
		Intent i = getIntent();
		 tr = i.getStringExtra("tr");
	from = i.getStringExtra("From");
	 to=i.getStringExtra("To");
		dp=i.getStringExtra("dp");
		
		 at=i.getStringExtra("at");
		 r=i.getStringExtra("r");
		
t6.setText(tr);

Button b=(Button)findViewById(R.id.button1);
b.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String name=e1.getText().toString();
				content="Busname:"+tr+"\n"+"Name:"+name+"\n"+"From:"+from+"\n"+"To:"+to+"\n"+"Departure Time:"+dp+"\n"+"Arrival Time"+at+"\n"+"Fare:"+r+"\n"+"Seat no:"+si;
		final String name1=name+"ticket.doc";
	String up=n.replace(si,"");
	SQLHelper.cr(up,tr);
t7.setText("Ticket has been saved in your Device");
	try { 
	       
	       final String TESTSTRING = new String(content);
           
	       FileOutputStream fOut = openFileOutput(name1,
	                                                            MODE_WORLD_READABLE);
	       OutputStreamWriter osw = new OutputStreamWriter(fOut); 

	       // Write the string to the file
	       osw.write(TESTSTRING);

	       /* ensure that everything is
	        * really written out and close */
	       osw.flush();
	       osw.close();

	
	}
	catch (IOException ioe) 
    {
		ioe.printStackTrace();}
    }
	
});
// Place referece id


	
		 n=SQLHelper.loginData(tr);
		int j = n.length();
		String m=Integer.toString(j);
		String[] strings = new String[j];  
	    for (int i1 = 0; i1 < strings.length; i1++) {  
	      strings[i1] = n.substring(i1, i1 + 1);  
	    }
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, strings);
		s.setAdapter(adapter);
		s.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

			si=s.getSelectedItem().toString();
	
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

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
