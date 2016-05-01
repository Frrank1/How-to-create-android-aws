package com.frrank.android.aws.ui;

import com.frrank.android.aws.R;
import com.frrank.android.aws.app.AppLog;
import com.frrank.android.aws.constants.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AWSMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message);
		
		setMessage();
		setTitle();
	}

	private void setTitle(){
		((TextView)findViewById(R.id.txtTitle)).setText(getString(R.string.message_title));
	}

	private void setMessage() {
		Bundle bundle = getIntent().getExtras();
		
		if(null != bundle){
			String message = bundle.getString(Constants.AWS_MESSAGE);
			
			AppLog.logString("AWS Message: " + message);
			
			((TextView)findViewById(R.id.txtMessage)).setText(message);
		}
		else{
			AppLog.logString("Activity has no extras!");
		}
	}
}
