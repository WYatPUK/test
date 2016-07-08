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
		requestWindowFeature(Window.FEATURE_PROGRESS);//����ָʾ������
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//��ȷ���Ľ���
		setContentView(R.layout.activity_main);
		//final ProgressBar A = (ProgressBar)findViewById(R.id.progressbar1);
		setProgress(8000);
		i=0;
		setProgressBarIndeterminateVisibility(true);//��������ʾ��ȷ���Ľ��ȵĽ�����
		mToggleButton = (ToggleButton) findViewById(R.id.toggleButton1); //��ȡ���ؼ�  
		mToggleButton.setOnCheckedChangeListener(this);//��Ӽ����¼�  
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
			Text.setText("�ѿ���");  
		}else{  
			Text.setText("�ѹر�");  
		}  
	}  

}
