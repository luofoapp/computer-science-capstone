package com.example.a021520211;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class LoginPage extends Fragment {
    FragmentTransaction fragmentTransaction;
    EditText emailInput, passwordInput;
    Button forgotBtn;
    String allow;
    private static final String url="http://10.0.2.2/app_info/check_login_creds.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.login_page, container, false);

        emailInput = v.findViewById(R.id.user_email_input);
        passwordInput = v.findViewById(R.id.pass_signin_input);
        allow = "0";

        forgotBtn  = v.findViewById(R.id.forgot_btn);

        v.findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailInput.getText().toString().matches("") == false && passwordInput.getText().toString().matches("") == false) {
                    checkData();
                }
            }
        });

        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forgot forgotFrag = new Forgot();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_container, forgotFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }

    private void checkData() {
        final String pPass = passwordInput.getText().toString().trim();
        final String pEmail = emailInput.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String testingA = response.toString();
                testingA.toString().trim();
                checkAllow(testingA);
                emailInput.setText("");
                passwordInput.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                param.put("emailInput", pEmail);
                param.put("passwordInput", pPass);
                return param;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(request);
    }

    public void checkAllow (String testA) {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (testA.equals("1")) {
                    Intent intent = new Intent(getActivity(), NavigationActivity.class);
                    startActivity(intent);
                }
                else {
//                    emailInput.setText("its not "+testA);
                    Toast.makeText(getActivity().getApplicationContext(), "Incorrect email or password", Toast.LENGTH_LONG).show();
                }
            }
        }, 1500);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
