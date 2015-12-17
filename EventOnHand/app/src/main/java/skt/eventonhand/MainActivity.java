package skt.eventonhand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import skt.eventonhand.app.AppController;
import skt.eventonhand.app.SessionManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtName;
    TextView txtEmail;
    Button btnLogout;
    Button main_menus;

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        main_menus = (Button) findViewById(R.id.main_menus);

        btnLogout.setOnClickListener(this);
        main_menus.setOnClickListener(this);


        //setting toolbar
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);


        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        String name = AppController.getString(getApplicationContext(), "name");
        String email = AppController.getString(getApplicationContext(), "email");
        txtName.setText(name);
        txtEmail.setText(email);
    }


    public void onClick(View v) {
        switch (v.getId())
        {
            //on clicking register button move to Register Activity
            case R.id.btnLogout:
                logoutUser();
                break;

            case R.id.main_menus:
                main_menus();
                break;
        }
    }


    private void logoutUser() {
        session.setLogin(false);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


    private void main_menus() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
        finish();
    }


}


