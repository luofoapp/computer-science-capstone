package com.example.a021520211;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class SignUpPage extends Fragment {

    EditText firstName, lastName, email, confEmail, phoneNumber,pass, userName;
    private static final String url = "http://10.0.2.2/app_info/insert_signup.php";


    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sign_up_page, container, false);

        firstName = v.findViewById(R.id.fName);
        lastName = v.findViewById(R.id.lName);
        email = v.findViewById(R.id.uEmail);
        confEmail = v.findViewById(R.id.signUpEmailConfirm);
        phoneNumber =v.findViewById(R.id.pNum);
        userName = v.findViewById(R.id.uName);
        pass =v.findViewById(R.id.pwd);
        LinearLayout lin = v.findViewById(R.id.warningTexts);

        lin.removeAllViews();


        v.findViewById(R.id.create_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstName.getText().toString().matches("") == false && lastName.getText().toString().matches("") == false && isValidEmail(email.getText().toString()) == true && matchConfEmail() == true && pass.getText().toString().matches("") == false && phoneNumber.getText().toString().matches("") == false) {
                    //upload new user info to database
                    insertData();

                    Intent intent = new Intent(getActivity(), NavigationActivity.class);
                    startActivity(intent);

//                    MyProfile myProfFrag = new MyProfile();
//                    fragmentTransaction = getParentFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.content_container, myProfFrag);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
                }
                else {
                    lin.removeAllViews();
                     if(firstName.getText().toString().matches("") == true){
                        createWarningMessage(0);
                    }
                    else if(lastName.getText().toString().matches("") == true){
                        createWarningMessage(1);
                    }
                    else if(isValidEmail(email.getText().toString()) == false){
                        createWarningMessage(2);
                    }
                    else if(matchConfEmail() == false){
                        createWarningMessage(3);
                    }
                    else if(phoneNumber.getText().toString().matches("") == true){
                        createWarningMessage(4);
                    }
                    else if(pass.getText().toString().matches("") == true){
                        createWarningMessage(4);
                    }

                }
            }

            public void createWarningMessage(int fieldNum) {
                TextView warningText = new TextView(getActivity());
                final int i = 0;
                String[] warnMessage = {"Please enter a valid first name", "Please enter a valid last name","That email address isn't valid.", "The emails don't match", "Please enter a valid phone number", "Please enter a strong password"};
                warningText.setId(i);
                warningText.setText(warnMessage[fieldNum]);
                lin.addView(warningText);
            }

            public boolean isValidEmail(String target) {
                return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
            }

            public boolean matchConfEmail(){
                if (email.getText().toString().equals(confEmail.getText().toString())) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
        return v;
    }

    private void insertData() {
        final String pFirstName = firstName.getText().toString().trim();
        final String pLastName = lastName.getText().toString().trim();
        final String pUsername = userName.getText().toString().trim();
        final String pPassword = pass.getText().toString().trim();
        final String pEmail = email.getText().toString().trim();
        final String pPhoneNumber = phoneNumber.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                firstName.setText("");
                lastName.setText("");
                userName.setText("");
                pass.setText("");
                email.setText("");
                phoneNumber.setText("");
                Toast.makeText(getActivity().getApplicationContext(), response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param=new HashMap<String, String>();
                param.put("firstName", pFirstName);
                param.put("lastName", pLastName);
                param.put("userName", pUsername);
                param.put("pass", pPassword);
                param.put("email", pEmail);
                param.put("phoneNumber", pPhoneNumber);
                return param;
            }
        };


        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(request);

    }

}