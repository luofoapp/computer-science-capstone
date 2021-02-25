package com.example.a021520211;

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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

public class SignUpPage extends Fragment {
    FragmentTransaction fragmentTransaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sign_up_page, container, false);

        EditText email = v.findViewById(R.id.signUpInitEmail);
        EditText confEmail = v.findViewById(R.id.signUpEmailConfirm);
        EditText phoneNumber =v.findViewById(R.id.editTextPhone);
        EditText pass =v.findViewById(R.id.editTextTextPassword2);
        LinearLayout lin = v.findViewById(R.id.warningTexts);
        lin.removeAllViews();

        v.findViewById(R.id.create_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidEmail(email.getText().toString()) == true && matchConfEmail() == true && pass.getText().toString().matches("") == false && phoneNumber.getText().toString().matches("") == false) {
                    //upload new user info to database
                    MyProfile myProfFrag = new MyProfile();
                    fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_container, myProfFrag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else {
                    lin.removeAllViews();
                    if(isValidEmail(email.getText().toString()) == false){
                        createWarningMessage(0);
                    }
                    else if(matchConfEmail() == false){
                        createWarningMessage(1);
                    }
                    else if(phoneNumber.getText().toString().matches("") == true){
                        createWarningMessage(2);
                    }
                    else if(pass.getText().toString().matches("") == true){
                        createWarningMessage(3);
                    }
                }
            }

            public void createWarningMessage(int fieldNum) {
                TextView warningText = new TextView(getActivity());
                final int i = 0;
                String[] warnMessage = {"That email address isn't valid.", "The emails don't match", "Please enter a valid phone number", "Please enter a strong password"};
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

}