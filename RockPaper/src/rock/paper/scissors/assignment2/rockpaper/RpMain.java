package rock.paper.scissors.assignment2.rockpaper;
////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
//////////////////////////////////////////////////////
///////////////////TEST///////////////////////////////
////////////////////////////////////////////////////
//////////////////////////////////////////////////////
////////////////////////////////////////////////////////
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class RpMain extends Activity {
	
	public int choice;
	public WebView myWebView1;
	public WebView myWebView2;
	public TextView myTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rp_main);
		
		
	}
	
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio1:
	            if (checked)
	                // player chose rock
	            	choice=1;
	            	checkWin();
	            break;	            
	        case R.id.radio2:
	            if (checked)
	                // player chose paper
	            	choice=2;
	            	checkWin();
	            break;
	        case R.id.radio3:
	            if (checked)
	                // player chose scissors
	            	choice=3;
            		checkWin();
	            break;  
	    }
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rp_main, menu);
		return true; 
	}
	
	public void checkWin(){
		
		Random generator = new Random();
		int machine = generator.nextInt( 3 )+1;
		setContentView(R.layout.show_results);
		myWebView1 = (WebView) findViewById(R.id.webView1);
		myWebView2 = (WebView) findViewById(R.id.webView2);
		myTextView = (TextView) findViewById(R.id.textView1);
		
		switch (machine){
		case 1: myWebView1.loadUrl("file:///android_asset/1.jpg");
		break;
		case 2: myWebView1.loadUrl("file:///android_asset/2.jpg");
		break;
		case 3: myWebView1.loadUrl("file:///android_asset/3.jpg");
		break;
		}
		
		switch (choice){
		case 1: myWebView2.loadUrl("file:///android_asset/1.jpg");
		break;
		case 2: myWebView2.loadUrl("file:///android_asset/2.jpg");
		break;
		case 3: myWebView2.loadUrl("file:///android_asset/3.jpg");
		break;
		}
		
		if (choice==machine){
			myTextView.setText("This is a tie!");
		}
		else if ((choice==3 && machine==2)||(choice==2 && machine==1)||(choice==1 && machine==3)){
			myTextView.setText("You Win!");
		}
		else{
			myTextView.setText("You Lose!");
		}
		Button myButton =  (Button)findViewById(R.id.button1);
		myButton.setOnClickListener(new OnClickListener() {

			@Override
	        public void onClick(View v) {
	        	
	        	Intent intent= new Intent(v.getContext(), RpMain.class);
	        	startActivityForResult(intent, 0);
	            
	        }
	    });
		
		
	}

}
