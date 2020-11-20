package com.example.fragmentsassignment3.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentsassignment3.R;

public class FragmentGetData extends Fragment {
    private static final String FIRST_NAME ="firstName" ;
    private static final String LAST_NAME ="lastName" ;
    EditText editTextFirstName;
    EditText editTextLastName;
    Button buttonDataToActivity;
    OnGetTextListener onGetTextListener;
    String firstName;
    String lastName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            firstName = savedInstanceState.getString(FIRST_NAME);
            lastName = savedInstanceState.getString(LAST_NAME);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onGetTextListener = (OnGetTextListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_data, container, false);
        bindViews(view);
        buttonDataToActivity.setOnClickListener((v) -> {
             firstName = editTextFirstName.getText().toString();
             lastName = editTextLastName.getText().toString();
            onGetTextListener.onGetText(firstName,lastName);
        });
        return view;
    }

    private void bindViews(View view)
    {
        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        buttonDataToActivity = view.findViewById(R.id.buttonSendDataToActivity);
    }

    public interface OnGetTextListener
    {
        void onGetText(String firstName, String lastName);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FIRST_NAME,firstName);
        outState.putString(LAST_NAME,lastName);
    }
}