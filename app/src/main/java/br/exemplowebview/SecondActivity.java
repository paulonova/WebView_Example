package br.exemplowebview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class SecondActivity extends Activity {

    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView name = (TextView)findViewById(R.id.txtName);
        TextView email = (TextView)findViewById(R.id.txtEmail);
        TextView password = (TextView)findViewById(R.id.txtPassword);

        mainActivity = new MainActivity();


        // A little problem here!!
        name.setText(mainActivity.getName());
        email.setText(mainActivity.getEmail());
        password.setText(mainActivity.getPassword());


    }

    public void backToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }


}
