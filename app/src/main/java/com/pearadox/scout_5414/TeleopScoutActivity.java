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
    /* Header Sect. */  TextView txt_dev, txt_stud, txt_match, txt_tnum;
    /* L Rocket */      CheckBox chk_LeftRocket_LPan1,chk_LeftRocket_LPan2,chk_LeftRocket_LPan3, chk_LeftRocket_LCarg1,chk_LeftRocket_LCarg2,chk_LeftRocket_LCarg3;
                        CheckBox chk_LeftRocket_RPan1,chk_LeftRocket_RPan2,chk_LeftRocket_RPan3, chk_LeftRocket_RCarg1,chk_LeftRocket_RCarg2,chk_LeftRocket_RCarg3;
    /* CargoShip */     CheckBox chk_CargoLPan1,chk_CargoLPan2,chk_CargoLPan3, chk_CargoLCarg1,chk_CargoLCarg2,chk_CargoLCarg3;
                        CheckBox chk_CargoRPan1,chk_CargoRPan2,chk_CargoRPan3, chk_CargoRCarg1,chk_CargoRCarg2,chk_CargoRCarg3;
                        CheckBox chk_CargoEndLPanel,chk_CargoEndRPanel,chk_CargoEndLCargo,chk_CargoEndRCargo;
    /* R Rocket */      CheckBox chk_RghtRocket_LPan1,chk_RghtRocket_LPan2,chk_RghtRocket_LPan3, chk_RghtRocket_LCarg1,chk_RghtRocket_LCarg2,chk_RghtRocket_LCarg3;
                        CheckBox chk_RghtRocket_RPan1,chk_RghtRocket_RPan2,chk_RghtRocket_RPan3, chk_RghtRocket_RCarg1,chk_RghtRocket_RCarg2,chk_RghtRocket_RCarg3;
    /* Comment */       EditText editText_TeleComments;
    /* P/U Sect. */     CheckBox chkBox_PU_Cargo_floor, chkBox_PU_Panel_floor;
    /* HAB */           RadioGroup  radgrp_HAB;      RadioButton  radio_Lift, radio_One, radio_Two, radio_Three, radio_Zero;
                        CheckBox chk_LiftedBy, chk_Lifted;
    /* Last Sect. */    Button button_GoToFinalActivity, button_Number_PenaltiesPlus, button_Number_PenaltiesUndo;
                        TextView lbl_Number_Penalties;
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    private FirebaseDatabase  pfDatabase;
//    private DatabaseReference pfTeam_DBReference;
//    private DatabaseReference pfMatch_DBReference;
    private DatabaseReference pfDevice_DBReference;
//    private DatabaseReference pfCur_Match_DBReference;
    String key = null;
    String tn  = " ";

    // ===================  TeleOps Elements for Match Scout Data object ===================
    public boolean LeftRocket_LPan1   = false;  // L-Rocket L-Panel#1
    public boolean LeftRocket_LPan2   = false;  // L-Rocket L-Panel#2
    public boolean LeftRocket_LPan3   = false;  // L-Rocket L-Panel#3
    public boolean LeftRocket_RPan1   = false;  // L-Rocket R-Panel#1
    public boolean LeftRocket_RPan2   = false;  // L-Rocket R-Panel#2
    public boolean LeftRocket_RPan3   = false;  // L-Rocket R-Panel#3
    public boolean LeftRocket_LCarg1  = false; // L-Rocket L-Cargo#1
    public boolean LeftRocket_LCarg2  = false; // L-Rocket L-Cargo#2
    public boolean LeftRocket_LCarg3  = false; // L-Rocket L-Cargo#3
    public boolean LeftRocket_RCarg1  = false; // L-Rocket R-Cargo#1
    public boolean LeftRocket_RCarg2  = false; // L-Rocket R-Cargo#2
    public boolean LeftRocket_RCarg3  = false; // L-Rocket R-Cargo#3

    public boolean CargoLPan1         = false;; // Cargo L-Panel#1
    public boolean CargoLPan2         = false;; // Cargo L-Panel#2
    public boolean CargoLPan3         = false;; // Cargo L-Panel#3
    public boolean CargoRPan1         = false;; // Cargo R-Panel#1
    public boolean CargoRPan2         = false;; // Cargo R-Panel#2
    public boolean CargoRPan3         = false;; // Cargo R-Panel#3
    public boolean CargoLCarg1        = false;; // Cargo L-Cargo#1
    public boolean CargoLCarg2        = false;; // Cargo L-Cargo#2
    public boolean CargoLCarg3        = false;; // Cargo L-Cargo#3
    public boolean CargoRCarg1        = false;; // Cargo R-Cargo#1
    public boolean CargoRCarg2        = false;; // Cargo R-Cargo#2
    public boolean CargoRCarg3        = false;; // Cargo R-Cargo#3
    public boolean CargoEndLPan1      = false;; // Cargo End L-Panel#1
    public boolean CargoEndLCarg1     = false;; // Cargo End L-Cargo#1
    public boolean CargoEndRPan1      = false;; // Cargo End R-Panel#1
    public boolean CargoEndRCarg1     = false;; // Cargo End R-Cargo#1


    public boolean RghtRocket_LPan1   = false;  // R-Rocket L-Panel#1
    public boolean RghtRocket_LPan2   = false;  // R-Rocket L-Panel#2
    public boolean RghtRocket_LPan3   = false;  // R-Rocket L-Panel#3
    public boolean RghtRocket_RPan1   = false;  // R-Rocket R-Panel#1
    public boolean RghtRocket_RPan2   = false;  // R-Rocket R-Panel#2
    public boolean RghtRocket_RPan3   = false;  // R-Rocket R-Panel#3
    public boolean RghtRocket_LCarg1  = false;  // R-Rocket L-Cargo#1
    public boolean RghtRocket_LCarg2  = false;  // R-Rocket L-Cargo#2
    public boolean RghtRocket_LCarg3  = false;  // R-Rocket L-Cargo#3
    public boolean RghtRocket_RCarg1  = false;  // R-Rocket R-Cargo#1
    public boolean RghtRocket_RCarg2  = false;  // R-Rocket R-Cargo#2
    public boolean RghtRocket_RCarg3  = false;  // R-Rocket R-Cargo#3

    public boolean cube_pickup        = false;  // Did they pickup cargo off the ground?
    public boolean panel_pickup       = false;  // Did they pickup panel off the ground?
    public int end_HAB_Level          = 0;      // HAB Level
    public boolean got_lift           = false;  // Got Lifted by another robot
    public boolean lifted             = false;  // Got Lifted by another robot
    public int final_num_Penalties    = 0;      // How many penalties received?
    /* */
    public String  teleComment        = " ";    // Tele Comment
    // ===========================================================================
    matchData match_cycle = new matchData();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(TAG, "<< Teleop Scout >>");
        setContentView(R.layout.activity_teleop_scout);
        Bundle bundle = this.getIntent().getExtras();
        tn = bundle.getString("tnum");
        Log.w(TAG, tn);      // ** DEBUG **

        txt_tnum = (TextView) findViewById(R.id.txt_tnum);
        txt_tnum.setText(tn);
        // Left Rocket
        chk_LeftRocket_LPan1    = (CheckBox) findViewById(R.id.chk_LeftRocket_LPan1);
        chk_LeftRocket_LPan2    = (CheckBox) findViewById(R.id.chk_LeftRocket_LPan2);
        chk_LeftRocket_LPan3    = (CheckBox) findViewById(R.id.chk_LeftRocket_LPan3);
        chk_LeftRocket_RPan1    = (CheckBox) findViewById(R.id.chk_LeftRocket_RPan1);
        chk_LeftRocket_RPan2    = (CheckBox) findViewById(R.id.chk_LeftRocket_RPan2);
        chk_LeftRocket_RPan3    = (CheckBox) findViewById(R.id.chk_LeftRocket_RPan3);
        chk_LeftRocket_LCarg1   = (CheckBox) findViewById(R.id.chk_LeftRocket_LCarg1);
        chk_LeftRocket_LCarg2   = (CheckBox) findViewById(R.id.chk_LeftRocket_LCarg2);
        chk_LeftRocket_LCarg3   = (CheckBox) findViewById(R.id.chk_LeftRocket_LCarg3);
        chk_LeftRocket_RCarg1   = (CheckBox) findViewById(R.id.chk_LeftRocket_RCarg1);
        chk_LeftRocket_RCarg2   = (CheckBox) findViewById(R.id.chk_LeftRocket_RCarg2);
        chk_LeftRocket_RCarg3   = (CheckBox) findViewById(R.id.chk_LeftRocket_RCarg3);
        // Cargo Ship
        chk_CargoLPan1          = (CheckBox) findViewById(R.id.chk_CargoLPan1);
        chk_CargoLPan2          = (CheckBox) findViewById(R.id.chk_CargoLPan2);
        chk_CargoLPan3          = (CheckBox) findViewById(R.id.chk_CargoLPan3);
        chk_CargoRPan1          = (CheckBox) findViewById(R.id.chk_CargoRPan1);
        chk_CargoRPan2          = (CheckBox) findViewById(R.id.chk_CargoRPan2);
        chk_CargoRPan3          = (CheckBox) findViewById(R.id.chk_CargoRPan3);
        chk_CargoLPan1          = (CheckBox) findViewById(R.id.chk_CargoLPan1);
        chk_CargoLCarg1          = (CheckBox) findViewById(R.id.chk_CargoLCarg1);
        chk_CargoLCarg2          = (CheckBox) findViewById(R.id.chk_CargoLCarg2);
        chk_CargoLCarg3          = (CheckBox) findViewById(R.id.chk_CargoLCarg3);
        chk_CargoRCarg1          = (CheckBox) findViewById(R.id.chk_CargoRCarg1);
        chk_CargoRCarg2          = (CheckBox) findViewById(R.id.chk_CargoRCarg2);
        chk_CargoRCarg3          = (CheckBox) findViewById(R.id.chk_CargoRCarg3);
        chk_CargoEndLPanel       = (CheckBox) findViewById(R.id.chk_CargoEndLPanel);
        chk_CargoEndRPanel       = (CheckBox) findViewById(R.id.chk_CargoEndRPanel);
        chk_CargoEndLCargo       = (CheckBox) findViewById(R.id.chk_CargoEndLCargo);
        chk_CargoEndRCargo       = (CheckBox) findViewById(R.id.chk_CargoEndRCargo);
        // Right Rocket
        chk_RghtRocket_LPan1    = (CheckBox) findViewById(R.id.chk_RghtRocket_LPan1);
        chk_RghtRocket_LPan2    = (CheckBox) findViewById(R.id.chk_RghtRocket_LPan2);
        chk_RghtRocket_LPan3    = (CheckBox) findViewById(R.id.chk_RghtRocket_LPan3);
        chk_RghtRocket_RPan1    = (CheckBox) findViewById(R.id.chk_RghtRocket_RPan1);
        chk_RghtRocket_RPan2    = (CheckBox) findViewById(R.id.chk_RghtRocket_RPan2);
        chk_RghtRocket_RPan3    = (CheckBox) findViewById(R.id.chk_RghtRocket_RPan3);
        chk_RghtRocket_LCarg1   = (CheckBox) findViewById(R.id.chk_RghtRocket_LCarg1);
        chk_RghtRocket_LCarg2   = (CheckBox) findViewById(R.id.chk_RghtRocket_LCarg2);
        chk_RghtRocket_LCarg3   = (CheckBox) findViewById(R.id.chk_RghtRocket_LCarg3);
        chk_RghtRocket_RCarg1   = (CheckBox) findViewById(R.id.chk_RghtRocket_RCarg1);
        chk_RghtRocket_RCarg2   = (CheckBox) findViewById(R.id.chk_RghtRocket_RCarg2);
        chk_RghtRocket_RCarg3   = (CheckBox) findViewById(R.id.chk_RghtRocket_RCarg3);

        editText_TeleComments   = (EditText) findViewById(R.id.editText_teleComments);
        chkBox_PU_Cargo_floor   = (CheckBox) findViewById(R.id.chkBox_PU_Cargo_floor);
        chkBox_PU_Panel_floor   = (CheckBox) findViewById(R.id.chkBox_PU_Panel_floor);
        radio_Zero              = (RadioButton) findViewById(R.id.radio_Zero);
        radio_One               = (RadioButton) findViewById(R.id.radio_One);
        radio_Two               = (RadioButton) findViewById(R.id.radio_Two);
        radio_Three             = (RadioButton) findViewById(R.id.radio_Three);
        chk_LiftedBy            = (CheckBox) findViewById(R.id.chk_LiftedBy);
        chk_Lifted              = (CheckBox) findViewById(R.id.chk_Lifted);
        button_Number_PenaltiesPlus = (Button) findViewById(R.id.button_Number_PenaltiesPlus);
        button_Number_PenaltiesUndo = (Button) findViewById(R.id.button_Number_PenaltiesUndo);
        button_GoToFinalActivity  = (Button)   findViewById(R.id.button_GoToFinalActivity);

        pfDatabase                = FirebaseDatabase.getInstance();            // Firebase
        pfDevice_DBReference      = pfDatabase.getReference("devices");     // List of Devices

//        Pearadox.Match_Data.setSand_LeftRocket_RPan1(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_LeftRocket_RPan3(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_CargoLPan1(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_CargoRPan3(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_CargoEndLPanel(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_CargoEndRPanel(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_CargoEndLCargo(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_CargoEndRCargo(true);  //DEBUG  .........................................
//        Pearadox.Match_Data.setSand_RghtRocket_LPan1(true);  //DEBUG  .........................................
//        Log.e(TAG, "First Check1=" + Pearadox.Match_Data.isSand_LeftRocket_RPan1());

        carry_over_chks();              // Carry-over check boxes from SandStorm


// *****************************************************************************************
// *****************************************************************************************


    button_GoToFinalActivity.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        Log.w(TAG, "###  Clicked Final  ###");
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

    chkBox_PU_Cargo_floor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            Log.w(TAG, "chkBox_PU_Cargo_floor Listener");
            if (buttonView.isChecked()) {
                Log.w(TAG,"PU_Cubes is checked.");
                cube_pickup = true;
            } else {  //not checked
                Log.w(TAG,"PU_Cubes is unchecked.");
                cube_pickup = false;
            }
        }
    });

    chkBox_PU_Panel_floor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            Log.w(TAG, "chkBox_PU_Panel_floor Listener");
            if (buttonView.isChecked()) {
                Log.w(TAG,"PU_Panel is checked.");
                cube_pickup = true;
            } else {  //not checked
                Log.w(TAG,"PU_Panel is unchecked.");
                cube_pickup = false;
            }
        }
    });


    chk_LiftedBy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            Log.w(TAG, "chk_LiftedBy Listener");
                if (chk_LiftedBy.isChecked()) {
                    //checked
                Log.w(TAG,"LiftedBy is checked.");
                got_lift = true;
                chk_Lifted.setChecked(false);       // Can't be both!!
                lifted = false;
            }
            else {
                //not checked
                Log.w(TAG,"LiftedBy is unchecked.");
                got_lift = false;
                //chkBox_Platform.setChecked(false);       // Have to be on platform to get lifted!
            }
        }
    });

    chk_Lifted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            Log.w(TAG, "chk_Lifted Listener");
            if (chk_Lifted.isChecked()) {
                //checked
                Log.w(TAG,"Lifted is checked.");
                got_lift = true;
                chk_LiftedBy.setChecked(false);       // Can't be both!!
                lifted = false;
            }
            else {
                //not checked
                Log.w(TAG,"Lifted is unchecked.");
                got_lift = false;
            }
        }
    });


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
            Log.w(TAG, "******  onTextChanged TextWatcher  ******" + s);
            teleComment = String.valueOf(s);
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.w(TAG, "******  beforeTextChanged TextWatcher  ******");
            // TODO Auto-generated method stub
        }
        @Override
        public void afterTextChanged(Editable s) {
            Log.w(TAG, "******  onTextChanged TextWatcher  ******" + s );
            teleComment = String.valueOf(s);
        }
    });
}

    /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    // Carry-over check boxes from SandStorm to Tele
    private void carry_over_chks() {
        Log.w(TAG, "$$$ carry_over_chks $$$");
        // Left Rocket
        chk_LeftRocket_LPan1.setChecked(Pearadox.Match_Data.isSand_LeftRocket_LPan1());
        chk_LeftRocket_LPan2.setChecked(Pearadox.Match_Data.isSand_LeftRocket_LPan2());
        chk_LeftRocket_LPan3.setChecked(Pearadox.Match_Data.isSand_LeftRocket_LPan3());
        chk_LeftRocket_RPan1.setChecked(Pearadox.Match_Data.isSand_LeftRocket_RPan1());
        chk_LeftRocket_RPan2.setChecked(Pearadox.Match_Data.isSand_LeftRocket_RPan2());
        chk_LeftRocket_RPan3.setChecked(Pearadox.Match_Data.isSand_LeftRocket_RPan3());
        chk_LeftRocket_LCarg1.setChecked(Pearadox.Match_Data.isSand_LeftRocket_LCarg1());
        chk_LeftRocket_LCarg2.setChecked(Pearadox.Match_Data.isSand_LeftRocket_LCarg2());
        chk_LeftRocket_LCarg3.setChecked(Pearadox.Match_Data.isSand_LeftRocket_LCarg3());
        chk_LeftRocket_RCarg1.setChecked(Pearadox.Match_Data.isSand_LeftRocket_RCarg1());
        chk_LeftRocket_RCarg2.setChecked(Pearadox.Match_Data.isSand_LeftRocket_RCarg2());
        chk_LeftRocket_RCarg3.setChecked(Pearadox.Match_Data.isSand_LeftRocket_RCarg3());
        // Cargo Ship
        chk_CargoLPan1.setChecked(Pearadox.Match_Data.isSand_CargoLPan1());
        chk_CargoLPan2.setChecked(Pearadox.Match_Data.isSand_CargoLPan2());
        chk_CargoLPan3.setChecked(Pearadox.Match_Data.isSand_CargoLPan3());
        chk_CargoRPan1.setChecked(Pearadox.Match_Data.isSand_CargoRPan1());
        chk_CargoRPan2.setChecked(Pearadox.Match_Data.isSand_CargoRPan2());
        chk_CargoRPan3.setChecked(Pearadox.Match_Data.isSand_CargoRPan3());
        chk_CargoLCarg1.setChecked(Pearadox.Match_Data.isSand_CargoLCarg1());
        chk_CargoLCarg2.setChecked(Pearadox.Match_Data.isSand_CargoLCarg2());
        chk_CargoLCarg3.setChecked(Pearadox.Match_Data.isSand_CargoLCarg3());
        chk_CargoRCarg1.setChecked(Pearadox.Match_Data.isSand_CargoRCarg1());
        chk_CargoRCarg2.setChecked(Pearadox.Match_Data.isSand_CargoRCarg2());
        chk_CargoRCarg3.setChecked(Pearadox.Match_Data.isSand_CargoRCarg3());
        chk_CargoEndLPanel.setChecked(Pearadox.Match_Data.isSand_CargoEndLPanel());
        chk_CargoEndRPanel.setChecked(Pearadox.Match_Data.isSand_CargoEndRPanel());
        chk_CargoEndLCargo.setChecked(Pearadox.Match_Data.isSand_CargoEndLCargo());
        chk_CargoEndRCargo.setChecked(Pearadox.Match_Data.isSand_CargoEndRCargo());
        // Left Rocket
        chk_RghtRocket_LPan1.setChecked(Pearadox.Match_Data.isSand_RghtRocket_LPan1());
        chk_RghtRocket_LPan2.setChecked(Pearadox.Match_Data.isSand_RghtRocket_LPan2());
        chk_RghtRocket_LPan3.setChecked(Pearadox.Match_Data.isSand_RghtRocket_LPan3());
        chk_RghtRocket_RPan1.setChecked(Pearadox.Match_Data.isSand_RghtRocket_RPan1());
        chk_RghtRocket_RPan2.setChecked(Pearadox.Match_Data.isSand_RghtRocket_RPan2());
        chk_RghtRocket_RPan3.setChecked(Pearadox.Match_Data.isSand_RghtRocket_RPan3());
        chk_RghtRocket_LCarg1.setChecked(Pearadox.Match_Data.isSand_RghtRocket_LCarg1());
        chk_RghtRocket_LCarg2.setChecked(Pearadox.Match_Data.isSand_RghtRocket_LCarg2());
        chk_RghtRocket_LCarg3.setChecked(Pearadox.Match_Data.isSand_RghtRocket_LCarg3());
        chk_RghtRocket_RCarg1.setChecked(Pearadox.Match_Data.isSand_RghtRocket_RCarg1());
        chk_RghtRocket_RCarg2.setChecked(Pearadox.Match_Data.isSand_RghtRocket_RCarg2());
        chk_RghtRocket_RCarg3.setChecked(Pearadox.Match_Data.isSand_RghtRocket_RCarg3());

    }


    /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    public void RadioClick_Lifted(View view) {
        Log.w(TAG, "@@ RadioClick_Lifted @@");
        radgrp_HAB = (RadioGroup) findViewById(R.id.radgrp_HAB);
        int selectedId = radgrp_HAB.getCheckedRadioButtonId();
//        Log.w(TAG, "*** Selected=" + selectedId);
        radio_Lift = (RadioButton) findViewById(selectedId);
        String value = radio_Lift.getText().toString();
        if (value.equals("Not On")) {        // Not On?
            Log.w(TAG, "Not On");
            end_HAB_Level = 0;
        } else if (value.equals("One")){     // One?
            Log.w(TAG, "One");
            end_HAB_Level = 1;
        } else if (value.equals("Two")){     // Two
            Log.w(TAG, "Two");
            end_HAB_Level = 2;
        } else {                              // Three
            Log.w(TAG, "Three");
            end_HAB_Level = 3;
        }
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private void storeTeleData() {
        Log.w(TAG, ">>>>  storeTeleData  <<<<");
        // New Match Data Object *** GLF 1/20/19
        Pearadox.Match_Data.setTele_cube_pickup(cube_pickup);
        Pearadox.Match_Data.setTele_Panel_pickup(panel_pickup);
        Pearadox.Match_Data.setTele_level_num(end_HAB_Level);
        Pearadox.Match_Data.setTele_got_lift(got_lift);
        Pearadox.Match_Data.setTele_num_Penalties(final_num_Penalties);
        // **
        Pearadox.Match_Data.setTele_comment(teleComment);
    }
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    private void updateDev(String phase) {     //
        Log.w(TAG, "#### updateDev #### " + phase);
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