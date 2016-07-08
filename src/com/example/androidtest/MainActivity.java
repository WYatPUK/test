package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener	{
	private int i;
	private ToggleButton mToggleButton;  
	private TextView Text;  


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);//进度指示器功能
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//不确定的进度
		setContentView(R.layout.activity_main);
		//final ProgressBar A = (ProgressBar)findViewById(R.id.progressbar1);
		setProgress(8000);
		i=0;
		setProgressBarIndeterminateVisibility(true);//标题栏显示不确定的进度的进度条
		mToggleButton = (ToggleButton) findViewById(R.id.toggleButton1); //获取到控件  
		mToggleButton.setOnCheckedChangeListener(this);//添加监听事件  
		Text = (TextView) findViewById(R.id.Text); 

		new Thread(new Runnable()
		{
			public void run()
			{
				while (true)
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setProgress(1000*(i%10));
					//A.setProgress(10 * (i%10));
					i++;
				}
			}
		}).start();
	}
	
	@Override  
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {  
		if(isChecked){  
			Text.setText("已开启");  
		}else{  
			Text.setText("已关闭");  
		}  
	}  

}
