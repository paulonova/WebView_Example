package br.exemplowebview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

//
import android.webkit.JavascriptInterface;

public class MainActivity extends Activity {
    private String name=null;
    private String email=null;
    private String password=null;

	private String url = "http://www.thiengo.com.br/doc/projects/integrando-webview-do-android-com-javascript-web/index.php?";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		WebView wv = (WebView) findViewById(R.id.webView);
		
		WebSettings ws = wv.getSettings();
		ws.setJavaScriptEnabled(true);
		
		wv.addJavascriptInterface(this, "ExemploWebView");
		
		wv.loadUrl(url+"apelido=Paulo Vila Nova");
	}
	
	@JavascriptInterface
	public void getForm(String name, String email, String password){
		Log.i("Script", "Name: "+name);
		Log.i("Script", "Email: "+email);
		Log.i("Script", "Password: " + password);

        setName(name);
        setEmail(email);
        setPassword(password);

        Log.i("Script", "Name: " + getName());
        Log.i("Script", "Email: " + getEmail());
        Log.i("Script", "Password: " + getPassword());


        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
        finish();
	}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
