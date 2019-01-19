package com.pearadox.scout_5414;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mlm.02000 on 2/5/2017.
 */

public class TeleopScoutActivity extends Activity {

    String TAG = "TeleopScoutActivity";      // This CLASS name
    TextView txt_dev, txt_stud, txt_match, txt_tnum, lbl_Number_Penalties;
    TextView  txt_CubeZoneNUM, txt_CubePlatformNUM, txt_OthrSwtchNUM, txt_PortalNUM, txt_ExchangeNUM;
    /* Last Sect. */       private Button button_GoToFinalActivity, button_Number_PenaltiesPlus, button_Number_PenaltiesUndo;
    CheckBox   chkBox_PU_Cubes_floor, chk_LiftedBy;
    EditText   editText_TeleComments;
    RadioGroup  radgrp_Lifted;      RadioButton  radio_Lift, radio_One, radio_Two, radio_Three, radio_Zero;

    private FirebaseDatabase  pfDatabase;
    private DatabaseReference pfTeam_DBReference;
    private DatabaseReference pfMatch_DBReference;
    private DatabaseReference pfDevice_DBReference;
    private DatabaseReference pfCur_Match_DBReference;
    String key = null;
    String tn  = " ";

    // ===================  TeleOps Elements for Match Scout Data object ===================
    public int     cubeSwitch_placed  = 0;     // # Gears placed
    public int     cubeSwitch_attempt = 0;     // # Gears attempted
    public int     cube_scale         = 0;     // # cubes placed on Switch during Tele
    public int     scale_attempt      = 0;     // # cubes attempted on Switch during Tele
    public int     their_switch       = 0;     // # cubes placed on _THEIR_Switch during Tele
    public int     their_attempt      = 0;     // # cubes attempted on _THEIR_Switch during Tele
    public int     cube_exchange      = 0;     // # cubes placed in Exchange during Tele
    public int     cube_portal        = 0;     // # cubes retrieved from Portal during Tele
    public int     cube_pwrzone       = 0;     // # cubes retrieved from Power Zone during Tele
    public int     cube_floor         = 0;     // # cubes retrieved from our Floor or Platform Zone during Tele
    public int     their_floor        = 0;     // # cubes retrieved from their Floor or Platform Zone during Tele
    public int     random_floor       = 0;     // # cubes retrieved from random places during Tele
    public boolean cube_pickup        = false; // Did they pickup gears off the ground?
    public boolean on_platform        = false; // Finished on platform
    public boolean delPlace           = false; // Cube Delivery = Place    \ Radio
    public boolean delLaunch          = false; // Cube Delivery = Launch   /  Button
    public boolean climb_attempt      = false; // Did they ATTEMPT climb?
    public boolean climb_success      = false; // Was climb successful?
    public boolean grab_rung          = false; // == Grabbed rung to climb   \ Radio
    public boolean grab_side          = false; // == Grabbed side to climb   /  Button
    public boolean lift_zero          = false; // Lifted no other robot     \
    public boolean lift_one           = false; // Lifted one other robot       Radio
    public boolean lift_two           = false; // Lifted two other robots   /   Button
    public boolean lift_three          = false; // Lifted two other robots   /   Button
    public boolean got_lift           = false; // Got Lifted by another robot
    public int    final_num_Penalties = 0;     // How many penalties received?
    /* */
    public String  teleComment        = " ";   // Tele Comment
    // ===========================================================================
    matchData match_cycle = new matchData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "<< Teleop Scout >>");
        setContentView(R.layout.activity_teleop_scout);
        Bundle bundle = this.getIntent().getExtras();
        tn = bundle.getString("tnum");
        Log.w(TAG, tn);      // ** DEBUG **

        txt_tnum = (TextView) findViewById(R.id.txt_tnum);
        txt_tnum.setText(tn);

        txt_CubeZoneNUM           = (TextView) findViewById(R.id.txt_CubeZoneNUM);
//        txt_OtherSwitchNUM        = (TextView) findViewById(R.id.txt_OtherSwitchNUM);
//        txt_OtherSwitchAttNUM     = (TextView) findViewById(R.id.txt_OtherSwitchAttNUM);
//        txt_OthrSwtchNUM          = (TextView) findViewById(R.id.txt_OthrSwtchNUM);
        txt_CubePlatformNUM       = (TextView) findViewById(R.id.txt_CubePlatformNUM);
        chk_LiftedBy              = (CheckBox) findViewById(R.id.chk_LiftedBy);
        chkBox_PU_Cubes_floor     = (CheckBox) findViewById(R.id.chkBox_PU_Cubes_floor);
        editText_TeleComments     = (EditText) findViewById(R.id.editText_teleComments);
        button_GoToFinalActivity  = (Button)   findViewById(R.id.button_GoToFinalActivity);
        txt_PortalNUM             = (TextView) findViewById(R.id.txt_PortalNUM);
        txt_ExchangeNUM           = (TextView) findViewById(R.id.txt_ExchangeNUM);
//        txt_RandomNUM             = (TextView) findViewById(R.id.txt_RandomNUM);
        lbl_Number_Penalties      = (TextView) findViewById(R.id.lbl_Number_Penalties);

        button_Number_PenaltiesPlus = (Button) findViewById(R.id.button_Number_PenaltiesPlus);
        button_Number_PenaltiesUndo = (Button) findViewById(R.id.button_Number_PenaltiesUndo);

        pfDatabase                = FirebaseDatabase.getInstance();
//        pfTeam_DBReference        = pfDatabase      .getReference("teams");         // Tteam data from Firebase D/B
//        pfStudent_DBReference     = pfDatabase      .getReference("students");      // List of Students
//        pfMatch_DBReference       = pfDatabase      .getReference("matches");       // List of matches
//        pfCur_Match_DBReference   = pfDatabase      .getReference("current-match"); // _THE_ current Match
        pfDevice_DBReference      = pfDatabase      .getReference("devices");    // List of Devices
        radio_One = (RadioButton) findViewById(R.id.radio_One);
        //radio_One.setEnabled(false);        // Don't let them choose if CLIMB not selected
        radio_Two = (RadioButton) findViewById(R.id.radio_Two);
        //radio_Two.setEnabled(false);        // Don't let them choose if CLIMB not selected
        radio_Three = (RadioButton) findViewById(R.id.radio_Three);
        radio_Zero = (RadioButton) findViewById(R.id.radio_Zero);
        //radio_Zero.setEnabled(false);        // Don't let them choose if CLIMB not selected

// *****************************************************************************************
// *****************************************************************************************


        button_GoToFinalActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "Clicked Final");
                // ToDo - Check for ANY required fields
//                if (!climb_success || (climb_success && (radio_Rung.isChecked() || radio_Side.isChecked()))) {     // Gotta pick one!
                    updateDev("Final");           // Update 'Phase' for stoplight indicator in ScoutM aster
                    storeTeleData();                    // Put all the TeleOps data collected in Match object

                    Intent smast_intent = new Intent(TeleopScoutActivity.this, FinalActivity.class);
                    Bundle SMbundle = new Bundle();
                    SMbundle.putString("tnum", tn);
                    smast_intent.putExtras(SMbundle);
                    startActivity(smast_intent);
//                } else {
//                    Log.e(TAG, "ERROR - did not select lift type");
//                    Toast.makeText(getBaseContext(), "** Climb _MUST_ have 'Rung' or 'Side' selected **", Toast.LENGTH_LONG).show();
//                    final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
//                    tg.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD);
//                }
            }
        });

        chkBox_PU_Cubes_floor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            Log.i(TAG, "chkBox_PU_Cubes_floor Listener");
            if (buttonView.isChecked()) {
                Log.w(TAG,"PU_Cubes is checked.");
                cube_pickup = true;

            } else {  //not checked
                Log.i(TAG,"PU_Cubes is unchecked.");
                cube_pickup = false;
            }
            }
        });



        chk_LiftedBy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                Log.i(TAG, "chk_LiftedBy Listener");
                    if (chk_LiftedBy.isChecked()) {
                        //checked
                    Log.i(TAG,"LiftedBy is checked.");
                    got_lift = true;
                }
                else {
                    //not checked
                    Log.i(TAG,"LiftedBy is unchecked.");
                    got_lift = false;
                    //chkBox_Platform.setChecked(false);       // Have to be on platform to get lifted!
                }
            }
        });



        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_One.isChecked())
                {
                    lift_one = true;
                    Log.w(TAG, "radio_One is " + lift_one);
                }
                else
                {
                    lift_one=false;
                    Log.w(TAG, "radio_One is " + lift_one);
                }
            }
        };

        radio_One.setOnClickListener(listener);
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_Two.isChecked()) {
                    lift_two = true;
                    Log.w(TAG, "radio_Two is " + lift_two);
                } else {
                    lift_two = false;
                    Log.w(TAG, "radio_Two is " + lift_two);
                }
            }
        };

        radio_Two.setOnClickListener(listener);
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_Zero.isChecked()) {
                    lift_zero = true;
                    lift_one = false;
                    lift_two = false;
                    //chkBox_Platform.setChecked(true);
                    Log.w(TAG, "radio_Zero is " + lift_zero);
                } else {
                    lift_zero = false;
                    Log.w(TAG, "radio_Zero is " + lift_zero);
                }
            }
        };

    radio_Zero.setOnClickListener(listener);


        button_Number_PenaltiesPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final_num_Penalties++;

                Log.w(TAG, "Penalties = " + final_num_Penalties);      // ** DEBUG **
                lbl_Number_Penalties.setText(Integer.toString(final_num_Penalties));    // Perform action on click
            }
        });
        button_Number_PenaltiesUndo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (final_num_Penalties >= 1) {
                    final_num_Penalties--;
                }
                Log.w(TAG, "Penalties = " + final_num_Penalties);      // ** DEBUG **
                lbl_Number_Penalties.setText(Integer.toString(final_num_Penalties));    // Perform action on click
            }
        });


        editText_TeleComments.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "******  onTextChanged TextWatcher  ******" + s);
                teleComment = String.valueOf(s);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "******  beforeTextChanged TextWatcher  ******");
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "******  onTextChanged TextWatcher  ******" + s );
                teleComment = String.valueOf(s);
            }
        });
    }


    /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    public void RadioClick_Lifted(View view) {
        Log.w(TAG, "@@ RadioClick_Lifted @@");
        radgrp_Lifted = (RadioGroup) findViewById(R.id.radgrp_Lifted);
        int selectedId = radgrp_Lifted.getCheckedRadioButtonId();
//        Log.w(TAG, "*** Selected=" + selectedId);
        radio_Lift = (RadioButton) findViewById(selectedId);
        String value = radio_Lift.getText().toString();
//        radio_Lift.setChecked(false);
        if (value.equals("One")) {           // One?
            Log.w(TAG, "One");
            lift_one = true;
            lift_two = false;
            lift_three = false;
        } else if (value.equals("Two")){     // Two
            Log.w(TAG, "Two");
            lift_three = false;
            lift_two = true;
            lift_one = false;
        } else {                              // Three
            Log.w(TAG, "Three");
            lift_three = true;
            lift_two = false;
            lift_one = false;
        }
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private void storeTeleData() {
        Log.w(TAG, ">>>>  storeTeleData  <<<<");
        Pearadox.Match_Data.setTele_cube_switch(cubeSwitch_placed);
        Pearadox.Match_Data.setTele_switch_attempt(cubeSwitch_attempt);
        Pearadox.Match_Data.setTele_cube_scale(cube_scale);
        Pearadox.Match_Data.setTele_scale_attempt(scale_attempt);
        Pearadox.Match_Data.setTele_their_switch(their_switch);
        Pearadox.Match_Data.setTele_their_attempt(their_attempt);
        Pearadox.Match_Data.setTele_cube_exchange(cube_exchange);
        Pearadox.Match_Data.setTele_cube_portal(cube_portal);
        Pearadox.Match_Data.setTele_cube_pwrzone(cube_pwrzone);
        Pearadox.Match_Data.setTele_cube_floor(cube_floor);
        Pearadox.Match_Data.setTele_their_floor(their_floor);
        Pearadox.Match_Data.setTele_random_floor(random_floor);
        Pearadox.Match_Data.setTele_cube_pickup(cube_pickup);
        Pearadox.Match_Data.setTele_on_platform(on_platform);
        Pearadox.Match_Data.setTele_placed_cube(delPlace);
        Pearadox.Match_Data.setTele_launched_cube(delLaunch);
        Pearadox.Match_Data.setTele_climb_attempt(climb_attempt);
        Pearadox.Match_Data.setTele_climb_success(climb_success);
        Pearadox.Match_Data.setTele_grab_rung(grab_rung);
        Pearadox.Match_Data.setTele_grab_side(grab_side);
        Pearadox.Match_Data.setTele_lift_one(lift_one);
        Pearadox.Match_Data.setTele_lift_two(lift_two);
        Pearadox.Match_Data.setTele_got_lift(got_lift);
        Pearadox.Match_Data.setFinal_num_Penalties(final_num_Penalties);
        // **
        Pearadox.Match_Data.setTele_comment(teleComment);
    }
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    private void updateDev(String phase) {     //
        Log.i(TAG, "#### updateDev #### " + phase);
        switch (Pearadox.FRC514_Device) {
            case "Scout Master":         // Scout Master
                key = "0";
                break;
            case ("Red-1"):             //#Red or Blue Scout
                key = "1";
                break;
            case ("Red-2"):             //#
                key = "2";
                break;
            case ("Red-3"):             //#
                key = "3";
                break;
            case ("Blue-1"):            //#
                key = "4";
                break;
            case ("Blue-2"):            //#
                key = "5";
                break;
            case ("Blue-3"):            //#####
                key = "6";
                break;
            case "Visualizer":          // Visualizer
                key = "7";
                break;
            default:                //
                Log.w(TAG, "DEV = NULL" );
        }
        pfDevice_DBReference.child(key).child("phase").setValue(phase);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit without saving? All of your data will be lost!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }


//###################################################################
//###################################################################
//###################################################################
    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");

        if (Pearadox.MatchData_Saved) {
            // ToDo - Clear all data back to original settings
            Log.w(TAG, "#### Data was saved in Final #### ");
            //Toast.makeText(getBaseContext(), "Data was saved in Final - probably should Exit", Toast.LENGTH_LONG).show();

            finish();       // Exit

        }
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy");
    }

}
/*  This is for committing! */