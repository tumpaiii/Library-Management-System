package com.example.librarymanagementsystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxMembership;
    private RadioGroup radioGroupMembership;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch switchNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        checkBoxMembership = findViewById(R.id.checkBoxMembership);
        radioGroupMembership = findViewById(R.id.radioGroupMembership);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        switchNotifications = findViewById(R.id.switchNotifications);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);


        buttonSubmit.setOnClickListener(view -> {
            StringBuilder result = new StringBuilder();


            if (checkBoxMembership.isChecked()) {
                result.append("Membership: Yes\n");

                // RadioButton: Get selected membership type
                int selectedId = radioGroupMembership.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if (selectedRadioButton != null) {
                    result.append("Membership Type: ").append(selectedRadioButton.getText()).append("\n");
                }
            } else {
                result.append("Membership: No\n");
            }


            result.append("Rating: ").append(ratingBar.getRating()).append("\n");


            result.append("Reading Progress: ").append(seekBar.getProgress()).append("%\n");


            result.append("Notifications: ").append(switchNotifications.isChecked() ? "Enabled" : "Disabled").append("\n");


            Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
        });
    }
}
