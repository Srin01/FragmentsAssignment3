package com.example.fragmentsassignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fragmentsassignment3.Fragments.FragmentGetData;
import com.example.fragmentsassignment3.Fragments.FragmentShowCharacter;

public class MainActivity extends AppCompatActivity implements FragmentGetData.OnGetTextListener {
    private static final String COUNT ="count" ;
    private static final String  TAG1 ="tag1" ;
    private static final String  TAG2 ="tag2" ;
    TextView textViewShowName;
    int countOfCharacters = 0;
    FragmentShowCharacter fragmentShowCharacter;
    FragmentGetData fragmentGetData;
    private static final String FIRST_NAME ="firstName" ;
    private static final String LAST_NAME ="lastName" ;
    String firstName;
    String lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            firstName = savedInstanceState.getString(FIRST_NAME);
            lastName = savedInstanceState.getString(LAST_NAME);
            countOfCharacters = savedInstanceState.getInt(COUNT);
            fragmentShowCharacter = (FragmentShowCharacter) getSupportFragmentManager().findFragmentByTag(TAG2);
            fragmentGetData = (FragmentGetData) getSupportFragmentManager().findFragmentByTag(TAG1);
        }
        else
        {
            fragmentGetData = new FragmentGetData();
            fragmentShowCharacter = new FragmentShowCharacter();
            addFragments(fragmentGetData,R.id.linearLayoutFragmentGetDataHolder,TAG1);
            addFragments(fragmentShowCharacter,R.id.linearLayoutFragmentShowCharacterHolder,TAG2);
            
        }
        bindViews();
    }

    private void addFragments(Fragment fragment, int id,String tag) {
        getSupportFragmentManager().beginTransaction().add(id, fragment,tag).commit();
    }

    private void bindViews() {
        textViewShowName = findViewById(R.id.textViewShowName);
    }

    @Override
    public void onGetText(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        textViewShowName.setText(firstName+" " +lastName);
        countOfCharacters = firstName.length() + lastName.length();
        fragmentShowCharacter.setNumberOfCharacters(countOfCharacters);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT,countOfCharacters);
        outState.putString(FIRST_NAME,firstName);
        outState.putString(LAST_NAME,lastName);
    }
}