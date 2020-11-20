package com.example.fragmentsassignment3.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentsassignment3.R;

public class FragmentShowCharacter extends Fragment {
    private static final String COUNT ="count" ;
    TextView textViewNumberOfCharacters;
    int number ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
        {
            number = savedInstanceState.getInt(COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_character, container, false);
        textViewNumberOfCharacters = view.findViewById(R.id.textViewShowNumberOfCharacters);
        return view;
    }

    public void setNumberOfCharacters(int number)
    {
        this.number = number;
        textViewNumberOfCharacters.setText(String.valueOf(number));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT,number);
    }
}