package com.xiaoai.webviewcontextmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String strUrl = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView vw = (WebView) findViewById(R.id.wv);       
		WebSettings webSettings = vw.getSettings();       
		webSettings.setJavaScriptEnabled(true);       

		vw.loadUrl("http://www.baidu.com");
		//注册上下文菜单
		this.registerForContextMenu(vw);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		WebView w = (WebView)v;
		HitTestResult result = w.getHitTestResult();
		//只检测图片格式
		if(result.getType() == HitTestResult.IMAGE_TYPE){
			menu.addSubMenu(1, 1, 1, "保存图片");

			//通过result.getExtra()取出URL
			strUrl = result.getExtra();
			Toast.makeText(getApplicationContext(), strUrl, Toast.LENGTH_SHORT).show();
		}
	}
}
