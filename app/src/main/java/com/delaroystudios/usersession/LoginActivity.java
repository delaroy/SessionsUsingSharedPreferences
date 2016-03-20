package com.delaroystudios.usersession;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	Button btnLogin;
	
	EditText txtUsername, txtPassword;
	
	// User Session Manager Class
	UserSessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        // User Session Manager
        session = new UserSessionManager(getApplicationContext());                
        
        // get Email, Password input text
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword); 
        
        Toast.makeText(getApplicationContext(), 
        		"User Login Status: " + session.isUserLoggedIn(), 
        		Toast.LENGTH_LONG).show();
        
        
        // User Login button
        btnLogin = (Button) findViewById(R.id.btnLogin);
        
        
        // Login button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// Get username, password from EditText
				String username = txtUsername.getText().toString();
				String password = txtPassword.getText().toString();
				
				// Validate if username, password is filled				
				if(username.trim().length() > 0 && password.trim().length() > 0){
					
					// For testing puspose username, password is checked with static data
					// username = admin
					// password = admin
					
					if(username.equals("admin") && password.equals("admin")){
						
						// Creating user login session
						// Statically storing name="Android Example"
						// and email="androidexample84@gmail.com"
						session.createUserLoginSession("User Session ", "bamoyk@yahoo.com");
						
						// Starting MainActivity
						Intent i = new Intent(getApplicationContext(), MainActivity.class);
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						
						// Add new Flag to start new Activity
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(i);
						
						finish();
						
					}else{
						
						// username / password doesn't match
						Toast.makeText(getApplicationContext(), "Username/Password is incorrect", Toast.LENGTH_LONG).show();
						
					}				
				}else{
					
					// user didn't entered username or password
					Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();
					
				}
				
			}
		});
    }        
}