package com.example.busreservation;

import com.quitz.test.db.SQLiteHelper;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Businfo extends Activity {
	private SQLiteHelper SQLHelper;
	public String tr;
	public String from;
	public String to;
	public String dp;
	public String at;
	public String r;
	public String m;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.businfo);
		SQLHelper = new SQLiteHelper(this); 
		Intent i = getIntent();
final TextView t1=(TextView)findViewById(R.id.textView2);
TextView t2=(TextView)findViewById(R.id.textView4);
TextView t3=(TextView)findViewById(R.id.textView6);
TextView t4=(TextView)findViewById(R.id.textView8);
final TextView t5=(TextView)findViewById(R.id.textView10);
final TextView t6=(TextView)findViewById(R.id.textView11);

TextView t7=(TextView)findViewById(R.id.textView13);
Button b=(Button)findViewById(R.id.button1);
b.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(m);
if(n==0)
{
	Intent i=new Intent(Businfo.this,Alert.class);
	startActivity(i);
}
else
{
	Intent i=new Intent(Businfo.this,Ticketbook.class);

	i.putExtra("tr",tr );
	i.putExtra("From",from );
	i.putExtra("To",to );
	i.putExtra("dp",dp );
	i.putExtra("at",at );
	i.putExtra("r",r );
	startActivity(i);
}
	}
});
// Place referece id

tr = i.getStringExtra("tr");
	from = i.getStringExtra("From");
	to=i.getStringExtra("To");
		dp=i.getStringExtra("dp");
		
		at=i.getStringExtra("at");
	 r=i.getStringExtra("r");
		t1.setText(from);
		t2.setText(to);
		t3.setText(dp);
		t4.setText(at);
		t5.setText(r);
		t6.setText(tr);
		String n=SQLHelper.loginData(tr);
		int j = n.length();
		 m=Integer.toString(j);
	t7.setText(m);
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
