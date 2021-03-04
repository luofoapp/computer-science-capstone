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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

public class SignUpPage extends Fragment {
    private static final String COL2 = "f_name";
    private static final String COL3 = "l_name";
    private static final String COL4 = "email";
    private static final String COL5 = "phone";
    private static final String COL6 = "pass";


    FragmentTransaction fragmentTransaction;
    DatabaseHelper nDatabaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sign_up_page, container, false);

        nDatabaseHelper = new DatabaseHelper(getActivity());
        EditText firstName = v.findViewById(R.id.signUpFirstName);
        EditText lastName = v.findViewById(R.id.signUpLastName);
        EditText email = v.findViewById(R.id.signUpInitEmail);
        EditText confEmail = v.findViewById(R.id.signUpEmailConfirm);
        EditText phoneNumber =v.findViewById(R.id.editTextPhone);
        EditText pass =v.findViewById(R.id.editTextTextPassword2);
        LinearLayout lin = v.findViewById(R.id.warningTexts);

        lin.removeAllViews();


        v.findViewById(R.id.create_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstName.getText().toString().matches("") == false && lastName.getText().toString().matches("") == false && isValidEmail(email.getText().toString()) == true && matchConfEmail() == true && pass.getText().toString().matches("") == false && phoneNumber.getText().toString().matches("") == false) {
                    //upload new user info to database
                    addData(COL2, firstName.getText().toString());
                    addData(COL3, lastName.getText().toString());
                    addData(COL4, email.getText().toString());
                    addData(COL5, phoneNumber.getText().toString());
                    addData(COL6, pass.getText().toString());


                    MyProfile myProfFrag = new MyProfile();
                    fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_container, myProfFrag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
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

    public void addData(String COLUMN, String newEntry) {
        boolean insertData = nDatabaseHelper.addData(COLUMN, newEntry);

        if (insertData) {
            toastMessage("Awesome! You're account has been created.");
        }

        else {
            toastMessage("Something went wrong :/");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }

}