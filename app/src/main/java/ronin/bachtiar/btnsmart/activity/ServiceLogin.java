package ronin.bachtiar.btnsmart.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import ronin.bachtiar.btnsmart.MainActivity;
import ronin.bachtiar.btnsmart.R;
import ronin.bachtiar.btnsmart.apim.ApiManager;
import ronin.bachtiar.btnsmart.utils.AppController;
import ronin.bachtiar.btnsmart.utils.SessionManager;
import ronin.bachtiar.btnsmart.utils.Utility;

public class ServiceLogin extends Activity {

    private Boolean exit = false;
    SessionManager session;
    ProgressDialog prgDialog;
    Button btnLogin;
    TextView errMsg, linkRegis;
    EditText logEmail, logPassword;

    String URL = ApiManager.API_LOGIN;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            session.checkLogin();
            navigatetoHomeActivity();
        }

        logEmail = (EditText) findViewById(R.id.logEmail);
        logPassword = (EditText) findViewById(R.id.logPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        prgDialog = new ProgressDialog(this);
        prgDialog.setMessage("Loggin in..");
        prgDialog.setCancelable(false);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigatetoHomeActivity();

//                email = logEmail.getText().toString();
//                password = logPassword.getText().toString();
//                JSONObject body = new JSONObject();
//                if (Utility.isNotNull(email) && Utility.isNotNull(password)) {
//                    try {
//                        body.put("email", email);
//                        body.put("password", password);
//                        checkLogin(body);
//                    } catch (JSONException ex) {
//                        ex.printStackTrace();
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    Toast.makeText(getApplicationContext(), "email atau password masih kosong", Toast.LENGTH_LONG).show();
//                }
            }

            public void checkLogin(JSONObject body) throws UnsupportedEncodingException {
                prgDialog.show();
                final StringEntity entity = new StringEntity(body.toString());
                AsyncHttpClient client = new AsyncHttpClient();
                client.post(getApplicationContext(), URL, entity, "application/json", new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        prgDialog.hide();
                        try {
                            if (response.getBoolean("status")) {
                                saveSession();
                                session.createLoginSession(email);
                                navigatetoHomeActivity();
                            } else {
                                Toast.makeText(getApplicationContext(), response.getString("erroe_msg"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException ex) {
                            Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Throwable error, JSONObject content) {
                        prgDialog.hide();
                        if (statusCode == 404) {
                            Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                        } else if (statusCode == 500) {
                            Toast.makeText(getApplicationContext(), "Internal Server Error", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    public void saveSession() {
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String userId = response.getString("user_id");
                            String name = response.getString("name");
                            String phone = response.getString("phone");
                            String email = response.getString("email");
                            String img = response.getString("img");
                            String rbac = response.getString("rbac");
                            String password = response.getString("password");
                            String token = response.getString("token");
                            String createdAt = response.getString("created_at");

                            session.createLoginSession(userId, name, phone, email, img, rbac, password, token, createdAt);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                });
        AppController.getInstance().addToRequestQueue(obreq);
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish();
        } else {
            exit = true;
            moveTaskToBack(true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }

    public void navigatetoHomeActivity() {
        Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }

}
