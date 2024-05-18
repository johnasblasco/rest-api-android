package busit.treefg1.myapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {


    private EditText userNameInput;
    private EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        userNameInput = findViewById(R.id.user);
        passwordInput = findViewById(R.id.password);


        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }



    private void login(){
//            get the data of the user entered
        String enteredUsername = userNameInput.getText().toString().trim();
        String enteredPassword = passwordInput.getText().toString().trim();

//            my api user
        String user = "https://dummyjson.com/users";

//            create a request
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, user, null,
                response -> {
                    try {
                        JSONArray u = response.getJSONArray("users");

                        for (int i = 0; i < u.length(); i++) {
                            JSONObject userObject = u.getJSONObject(i);
                            String response_username = userObject.getString("username");
                            String response_password = userObject.getString("password");


                            if (enteredUsername.equals(response_username) && enteredPassword.equals(response_password)) {
                                Toast.makeText(Login.this, "LOGIN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, MainActivity.class));
                                break;
                            }
                            else Toast.makeText(Login.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();

                        }


                    } catch (JSONException e) {

                    }
                }, error -> Toast.makeText(getApplicationContext(), "Network error: " + error.getMessage(), Toast.LENGTH_SHORT).show()
        );


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);


    }


}

