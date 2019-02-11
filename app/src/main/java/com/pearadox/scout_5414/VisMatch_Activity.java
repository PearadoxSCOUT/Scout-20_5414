package com.pearadox.scout_5414;

import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.media.ToneGenerator;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import java.io.File;
import java.io.FileOutputStream;

import static android.util.Log.e;

public class VisMatch_Activity extends AppCompatActivity {
    String TAG = "VisMatch_Activity";        // This CLASS name
    String tnum = "";
    String tname = "";
    int start = 0;          // Start Position for matches (0=ALL)
    int numObjects = 0; int numProcessed = 0;
    Spinner spinner_numMatches;
    String underScore = new String(new char[60]).replace("\0", "_");  // string of 'x' underscores
    String matches = "";
    TextView txt_team, txt_teamName, txt_NumMatches, txt_Matches;
    TextView txt_Ss_LeftHab1, txt_Ss_LeftHab2, txt_noSand, txt_Ss_cargoScored, txt_Ss_hatchScored, txt_Ss_droppedHatch;
    TextView txt_Tele_cargoScored, txt_Tele_hatchScored, txt_Tele_droppedHatch;
    TextView txt_HabLvl, txt_Lift1NUM, txt_Lift2NUM, txt_WasLiftedNUM;
    // ToDo - TextViews for Cargo/Panels 2nd & 3rd
    /* Comment Boxes */     TextView txt_AutoComments, txt_TeleComments, txt_FinalComments;
    TextView txt_Lvl1, txt_Lvl2, txt_NoShow;
    TextView txt_Pos1, txt_Pos2, txt_Pos3;
    public static String[] numMatch = new String[]             // Num. of Matches to process
            {"ALL","Last","Last 2","Last 3"};
    BarChart mBarChart;
    //----------------------------------
    int numLeftHAB = 0; int numLeftHAB2 = 0; int noSand = 0; int numExtraSw = 0; int numExtraSc = 0;
    int auto_SwCubesAttempted = 0; int auto_SwCrossOver = 0;int Auto_SwWrong = 0;
    int auto_ScCubesAttempted = 0; int auto_ScCubesPlaced = 0; int auto_ScCrossOver = 0; int Auto_ScWrong = 0;
    int auto_B1 = 0; int auto_B2 = 0; int auto_B3 = 0;
    int auto_Ps1 = 0; int auto_Ps2 = 0; int auto_Ps3 = 0;
// ToDO - variables for 2nd & 3rd
    int climbH0= 0; int climbH1 = 0; int climbH2 = 0; int climbH3 = 0; int lift1Num = 0; int liftedNum = 0;
    int cargL1 = 0; int cargL2 = 0; int cargL3 =0; int TcargL1 = 0; int TcargL2 = 0; int TcargL3 = 0; int TpanL1 = 0; int TpanL2 = 0; int TpanL3 = 0;
    int numMatches = 0; int panL1 = 0; int panL2 = 0; int panL3 = 0; int dropped=0; int Tdropped = 0;
    String auto_Comments = "";
    //----------------------------------
//    int tele_totalCubeSwAttempted = 0; int tele_totalCubeSwPlaced = 0; int tele_totalCubeScAttempted = 0; int tele_totalCubeScPlaced = 0; int tele_SwTheirs = 0; int tele_SwTheirAtt = 0; int tele_their_floor = 0;
//    int cubznNUM = 0; int cubplatNUM = 0; int cubPlatOthrNUM = 0; int offFloorNUM = 0; int portalNUM = 0; int randomNUM = 0;
    int numTeleExch = 0; int numTeleLaunch = 0; int numTelePlace = 0;
    int numTeleClimbSuccess = 0; int LiftNm = 0; int WasLifted = 0; int rungNum = 0; int sideNum = 0; int onPlatform = 0;
    String tele_Comments = "";
    //----------------------------------
    int final_LostComm = 0; int final_LostParts = 0; int final_DefGood = 0; int final_DefBlock = 0;  int final_DefSwitch = 0; int final_DefStarve = 0; int final_NumPen = 0;
    TextView txt_final_LostComm, txt_final_LostParts, txt_final_DefGood, txt_final_DefBlock, txt_final_BlkSwtch, txt_final_NumPen, txt_final_DefStarve;
    String final_Comments = "";
    //----------------------------------

    matchData match_inst = new matchData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vis_match);
        Log.i(TAG, "@@@@  VisMatch_Activity started  @@@@");
        Bundle bundle = this.getIntent().getExtras();
        String param1 = bundle.getString("team");
        String param2 = bundle.getString("name");
        Log.w(TAG, param1);      // ** DEBUG **
        tnum = param1;      // Save Team #
        Log.w(TAG, param2);      // ** DEBUG **
        tname = param2;      // Save Team #


        txt_Matches = (TextView) findViewById(R.id.txt_Matches);
        txt_team = (TextView) findViewById(R.id.txt_team);
        txt_teamName = (TextView) findViewById(R.id.txt_teamName);
        txt_NumMatches = (TextView) findViewById(R.id.txt_NumMatches);
        Spinner spinner_numMatches = (Spinner) findViewById(R.id.spinner_numMatches);
        ArrayAdapter adapter_Matches = new ArrayAdapter<String>(this, R.layout.robonum_list_layout, numMatch);
        adapter_Matches.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_numMatches.setAdapter(adapter_Matches);
        spinner_numMatches.setSelection(0, false);
        spinner_numMatches.setOnItemSelectedListener(new numMatches_OnItemSelectedListener());
        /*  Auto  */
        txt_Ss_LeftHab1 = (TextView) findViewById(R.id.txt_Ss_LeftHab1);
        txt_Ss_LeftHab2 = (TextView) findViewById(R.id.txt_Ss_LeftHab2);
        txt_HabLvl = (TextView) findViewById(R.id.txt_HabLvl);
        txt_noSand = (TextView) findViewById(R.id.txt_noSand);
        txt_Ss_cargoScored = (TextView) findViewById(R.id.txt_Ss_cargoScored);
        txt_Ss_hatchScored  = (TextView) findViewById(R.id.txt_Ss_hatchScored);
        txt_Ss_droppedHatch = (TextView) findViewById(R.id.txt_Ss_droppedHatch);
// ToDo -  findViews Cargo/Panels 2nd & 3rd
        txt_Tele_droppedHatch = (TextView) findViewById(R.id.txt_Tele_droppedHatch);
        txt_Lvl1 = (TextView) findViewById(R.id.txt_Lvl1);
        txt_Lvl2 = (TextView) findViewById(R.id.txt_Lvl2);
        txt_NoShow = (TextView) findViewById(R.id.txt_NoShow);
        txt_Pos1 = (TextView) findViewById(R.id.txt_Pos1);
        txt_Pos2 = (TextView) findViewById(R.id.txt_Pos2);
        txt_Pos3 = (TextView) findViewById(R.id.txt_Pos3);
        txt_AutoComments = (TextView) findViewById(R.id.txt_AutoComments);
        txt_AutoComments.setMovementMethod(new ScrollingMovementMethod());
        /*  Tele  */
        txt_Tele_cargoScored = (TextView) findViewById(R.id.txt_Tele_cargoScored);
        txt_Tele_hatchScored = (TextView) findViewById(R.id.txt_Tele_hatchScored);
        txt_Lift1NUM = (TextView) findViewById(R.id.txt_Lift1NUM);
        txt_Lift2NUM = (TextView) findViewById(R.id.txt_Lift2NUM);
        txt_WasLiftedNUM = (TextView) findViewById(R.id.txt_WasLiftedNUM);
        mBarChart = (BarChart) findViewById(R.id.barchart);
        txt_TeleComments = (TextView) findViewById(R.id.txt_TeleComments);
        txt_TeleComments.setMovementMethod(new ScrollingMovementMethod());

        /*  Final  */
        txt_FinalComments = (TextView) findViewById(R.id.txt_FinalComments);
        txt_FinalComments.setMovementMethod(new ScrollingMovementMethod());

        txt_final_LostComm = (TextView) findViewById(R.id.txt_final_LostComm);
        txt_final_LostParts = (TextView) findViewById(R.id.txt_final_LostParts);
        txt_final_DefGood = (TextView) findViewById(R.id.txt_final_DefGood);
        txt_final_DefBlock = (TextView) findViewById(R.id.txt_final_DefBlock);
        txt_final_BlkSwtch = (TextView) findViewById(R.id.txt_final_BlkSwtch);
        txt_final_NumPen = (TextView) findViewById(R.id.txt_final_NumPen);
        txt_final_DefStarve = (TextView) findViewById(R.id.txt_final_DefStarve);

        txt_team.setText(tnum);
        txt_teamName.setText(tname);    // Get real

        numObjects = Pearadox.Matches_Data.size();
        Log.w(TAG, "Objects = " + numObjects);
        txt_NumMatches.setText(String.valueOf(numObjects));

        init_Values();
        numProcessed = numObjects;
        start = 0;
        getMatch_Data();
    }
// ================================================================
    private void getMatch_Data() {
        for (int i = start; i < numObjects; i++) {
            Log.w(TAG, "In for loop!   " + i);
            match_inst = Pearadox.Matches_Data.get(i);      // Get instance of Match Data
            matches = matches + match_inst.getMatch() + "  ";

            if (match_inst.isSand_mode()) {
                noSand++;
            }
            if (match_inst.isSand_leftHAB()) {
                numLeftHAB++;
            }
            if (match_inst.isSand_leftHAB2()) {
                numLeftHAB2++;
            }

            if (match_inst.getSand_comment().length() > 1) {
                auto_Comments = auto_Comments + match_inst.getMatch() + "-" + match_inst.getSand_comment() + "\n" + underScore  + "\n" ;
            }
            String pos = match_inst.getPre_startPos().trim();
            Log.w(TAG, "Start Pos. " + pos);
            switch (pos) {
                case "Level 1":
                    auto_B1++;
                    break;
                case ("Level 2"):
                    auto_B2++;
                    break;
                case "No Show":
                    auto_B3++;
                    break;
                default:                //
                    Log.e(TAG, "***  Invalid Start Position!!!  ***" );
            }

            int PlayerStat = match_inst.getPre_PlayerSta();
            Log.w(TAG, "Player Station. " + PlayerStat);
            switch (PlayerStat) {
                case 1:
                    auto_Ps1++;
                    break;
                case 2:
                    auto_Ps2++;
                    break;
                case 3:
                    auto_Ps3++;
                    break;
                default:                //
                    Log.e(TAG, "***  Invalid Player Station!!!  ***" );
            }


            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
            // Tele elements
            LiftNm = LiftNm + match_inst.getTele_liftedNum();
            
            if (match_inst.isTele_got_lift()) {
                WasLifted++;
            }
            dropped = dropped + match_inst.getSand_num_Dropped();
            Tdropped = Tdropped + match_inst.getTele_num_Dropped();
            // =================== Cargo ============
            if (match_inst.isSand_LeftRocket_LCarg1()) {
                cargL1++;
            }
            if (match_inst.isSand_LeftRocket_LCarg2()) {
                cargL2++;
            }
            if (match_inst.isSand_LeftRocket_LCarg3()) {
                cargL3++;
            }
            if (match_inst.isSand_LeftRocket_RCarg1()) {
                cargL1++;
            }
            if (match_inst.isSand_LeftRocket_RCarg2()) {
                cargL2++;
            }
            if (match_inst.isSand_LeftRocket_RCarg3()) {
                cargL3++;
            }
            if (match_inst.isSand_RghtRocket_LCarg1()) {
                cargL1++;
            }
            if (match_inst.isSand_RghtRocket_LCarg2()) {
                cargL2++;
            }
            if (match_inst.isSand_RghtRocket_LCarg3()) {
                cargL3++;
            }
            if (match_inst.isSand_RghtRocket_RCarg1()) {
                cargL1++;
            }
            if (match_inst.isSand_RghtRocket_RCarg2()) {
                cargL2++;
            }
            if (match_inst.isSand_RghtRocket_RCarg3()) {
                cargL3++;
            }
            if (match_inst.isSand_CargoLCarg1()) {              // Cargo Ship
                cargL1++;
            }
            if (match_inst.isSand_CargoLCarg2()) {
                cargL1++;
            }
            if (match_inst.isSand_CargoLCarg3()) {
                cargL1++;
            }
            if (match_inst.isSand_CargoRCarg1()) {
                cargL1++;
            }
            if (match_inst.isSand_CargoRCarg2()) {
                cargL1++;
            }
            if (match_inst.isSand_CargoRCarg3()) {
                cargL1++;
            }
            if (match_inst.isSand_CargoEndLCargo()) {      // End
                cargL1++;
            }
            if (match_inst.isSand_CargoEndRCargo()) {      // End
                cargL1++;
            }
            // =================== Panels ============
            if (match_inst.isSand_LeftRocket_LPan1()) {
                panL1++;
            }
            if (match_inst.isSand_LeftRocket_LPan2()) {
                panL2++;
            }
            if (match_inst.isSand_LeftRocket_LPan3()) {
                panL3++;
            }
            if (match_inst.isSand_LeftRocket_RPan1()) {
                panL1++;
            }
            if (match_inst.isSand_LeftRocket_RPan2()) {
                panL2++;
            }
            if (match_inst.isSand_LeftRocket_RPan3()) {
                panL3++;
            }
            if (match_inst.isSand_RghtRocket_LPan1()) {
                panL1++;
            }
            if (match_inst.isSand_RghtRocket_LPan2()) {
                panL2++;
            }
            if (match_inst.isSand_RghtRocket_LPan3()) {
                panL3++;
            }
            if (match_inst.isSand_RghtRocket_RPan1()) {
                panL1++;
            }
            if (match_inst.isSand_RghtRocket_RPan2()) {
                panL2++;
            }
            if (match_inst.isSand_RghtRocket_RPan3()) {
                panL3++;
            }
            if (match_inst.isSand_CargoLPan1()) {              // Cargo Ship
                panL1++;
            }
            if (match_inst.isSand_CargoLPan2()) {
                panL1++;
            }
            if (match_inst.isSand_CargoLPan3()) {
                panL1++;
            }
            if (match_inst.isSand_CargoRPan1()) {
                panL1++;
            }
            if (match_inst.isSand_CargoRPan2()) {
                panL1++;
            }
            if (match_inst.isSand_CargoRPan3()) {
                panL1++;
            }
            if (match_inst.isSand_CargoEndLPanel()) {      // End
                panL1++;
            }
            if (match_inst.isSand_CargoEndRPanel()) {      // End
                panL1++;
            }
// ToDo - Collect data for Cargo/Panels 2nd & 3rd

            // *************************************************
            // ******************** TeleOps ********************
            // *************************************************
            dropped = dropped + match_inst.getTele_num_Dropped();
            // =================== Cargo ============
            if (match_inst.isTele_LeftRocket_LCarg1()) {
                TcargL1++;
            }
            if (match_inst.isTele_LeftRocket_LCarg2()) {
                TcargL2++;
            }
            if (match_inst.isTele_LeftRocket_LCarg3()) {
                TcargL3++;
            }
            if (match_inst.isTele_LeftRocket_RCarg1()) {
                TcargL1++;
            }
            if (match_inst.isTele_LeftRocket_RCarg2()) {
                TcargL2++;
            }
            if (match_inst.isTele_LeftRocket_RCarg3()) {
                TcargL3++;
            }
            if (match_inst.isTele_RghtRocket_LCarg1()) {
                TcargL1++;
            }
            if (match_inst.isTele_RghtRocket_LCarg2()) {
                TcargL2++;
            }
            if (match_inst.isTele_RghtRocket_LCarg3()) {
                TcargL3++;
            }
            if (match_inst.isTele_RghtRocket_RCarg1()) {
                TcargL1++;
            }
            if (match_inst.isTele_RghtRocket_RCarg2()) {
                TcargL2++;
            }
            if (match_inst.isTele_RghtRocket_RCarg3()) {
                TcargL3++;
            }
            if (match_inst.isTele_CargoLCarg1()) {              // Cargo Ship
                TcargL1++;
            }
            if (match_inst.isTele_CargoLCarg2()) {
                TcargL1++;
            }
            if (match_inst.isTele_CargoLCarg3()) {
                TcargL1++;
            }
            if (match_inst.isTele_CargoRCarg1()) {
                TcargL1++;
            }
            if (match_inst.isTele_CargoRCarg2()) {
                TcargL1++;
            }
            if (match_inst.isTele_CargoRCarg3()) {
                TcargL1++;
            }
            if (match_inst.isTele_CargoEndLCargo()) {      // End
                TcargL1++;
            }
            if (match_inst.isTele_CargoEndRCargo()) {      // End
                TcargL1++;
            }
            // =================== Panels ============
            if (match_inst.isTele_LeftRocket_LPan1()) {
                TpanL1++;
            }
            if (match_inst.isTele_LeftRocket_LPan2()) {
                TpanL2++;
            }
            if (match_inst.isTele_LeftRocket_LPan3()) {
                TpanL3++;
            }
            if (match_inst.isTele_LeftRocket_RPan1()) {
                TpanL1++;
            }
            if (match_inst.isTele_LeftRocket_RPan2()) {
                TpanL2++;
            }
            if (match_inst.isTele_LeftRocket_RPan3()) {
                TpanL3++;
            }
            if (match_inst.isTele_RghtRocket_LPan1()) {
                TpanL1++;
            }
            if (match_inst.isTele_RghtRocket_LPan2()) {
                TpanL2++;
            }
            if (match_inst.isTele_RghtRocket_LPan3()) {
                TpanL3++;
            }
            if (match_inst.isTele_RghtRocket_RPan1()) {
                TpanL1++;
            }
            if (match_inst.isTele_RghtRocket_RPan2()) {
                TpanL2++;
            }
            if (match_inst.isTele_RghtRocket_RPan3()) {
                TpanL3++;
            }
            if (match_inst.isTele_CargoLPan1()) {              // Cargo Ship
                TpanL1++;
            }
            if (match_inst.isTele_CargoLPan2()) {
                TpanL1++;
            }
            if (match_inst.isTele_CargoLPan3()) {
                TpanL1++;
            }
            if (match_inst.isTele_CargoRPan1()) {
                TpanL1++;
            }
            if (match_inst.isTele_CargoRPan2()) {
                TpanL1++;
            }
            if (match_inst.isTele_CargoRPan3()) {
                TpanL1++;
            }
            if (match_inst.isTele_CargoEndLPanel()) {      // End
                TpanL1++;
            }
            if (match_inst.isTele_CargoEndRPanel()) {      // End
                TpanL1++;
            }

            int endHAB = match_inst.getTele_level_num();        // end HAB Level
            switch (endHAB) {
                case 0:         // Not On
                    climbH0++;
                    break;
                case 1:         // Level 1
                    climbH1++;
                    break;
                case 2:         // Level 2
                    climbH2++;
                    break;
                case 3:         // Level 3
                    climbH3++;
                    break;
                default:                // ????
                    e(TAG, "*** Error - bad HAB Level indicator  ***");
            }

            if (match_inst.isTele_lifted()) {
                lift1Num++;
            }
//                if (match_inst.isTele_lift_two()) {
//                    lift2Num++;
//                }
            if (match_inst.isTele_got_lift()) {
                liftedNum++;
            }

            // ToDo - figure out why bar chart is accumulating??????
            int BarCargo = cargL1 + cargL2 + cargL3 + TcargL1 + TcargL2 + TcargL3;
            int BarPanels = panL1 + panL2 + panL3 + TpanL1 + TpanL2 + TpanL3;
            mBarChart.addBar(new BarModel(BarCargo, 0xffff0000));       // Cargo
            Log.w(TAG, "@@@@@@@@ Cargo=" + BarCargo + "   Panels=" + BarPanels);
            mBarChart.addBar(new BarModel( BarPanels,  0xff08457e));       // Panels
            if (match_inst.getTele_comment().length() > 1) {
                tele_Comments = tele_Comments + match_inst.getMatch() + "-" + match_inst.getTele_comment() + "\n" + underScore  + "\n" ;
            }

            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
            // Final elements
            if (match_inst.isFinal_lostComms()) {
                final_LostComm++;
            }
            if (match_inst.isFinal_lostParts()) {
                final_LostParts++;
            }
            if (match_inst.isFinal_defense_good()) {
                final_DefGood++;
            }
            // Todo Rocket Int.
//            if (match_inst.isFinal_def_Lane()) {
//                final_DefStarve++;
//            }
            if (match_inst.isFinal_def_Block()) {
                final_DefBlock++;
            }
            if (match_inst.getTele_num_Penalties() > 0) {
                final_NumPen = final_NumPen + match_inst.getTele_num_Penalties();
            }

//            Log.w(TAG, "Final Comment = " + match_inst.getFinal_comment() + "  " + match_inst.getFinal_comment().length());
            if (match_inst.getFinal_comment().length() > 1) {
                final_Comments = final_Comments + match_inst.getMatch() + "-" + match_inst.getFinal_comment() + "\n" + underScore  + "\n" ;
            }
        } //end For


// ================================================================
// ======  Now start displaying all the data we collected  ========
// ================================================================
        txt_Ss_LeftHab1 = (TextView) findViewById(R.id.txt_Ss_LeftHab1);
        txt_Ss_LeftHab2 = (TextView) findViewById(R.id.txt_Ss_LeftHab2);
        txt_HabLvl = (TextView) findViewById(R.id.txt_HabLvl);
        txt_noSand = (TextView) findViewById(R.id.txt_noSand);
        txt_Ss_cargoScored = (TextView) findViewById(R.id.txt_Ss_cargoScored);
        txt_Ss_hatchScored  = (TextView) findViewById(R.id.txt_Ss_hatchScored);
        txt_Ss_droppedHatch = (TextView) findViewById(R.id.txt_Ss_droppedHatch);
        txt_Tele_cargoScored = (TextView) findViewById(R.id.txt_Tele_cargoScored);
        txt_Tele_hatchScored = (TextView) findViewById(R.id.txt_Tele_hatchScored);
        txt_Tele_droppedHatch = (TextView) findViewById(R.id.txt_Tele_droppedHatch);
        txt_Lvl1 = (TextView) findViewById(R.id.txt_Lvl1);
        txt_Lvl2 = (TextView) findViewById(R.id.txt_Lvl2);
        txt_NoShow = (TextView) findViewById(R.id.txt_NoShow);
        txt_Pos1 = (TextView) findViewById(R.id.txt_Pos1);
        txt_Pos2 = (TextView) findViewById(R.id.txt_Pos2);
        txt_Pos3 = (TextView) findViewById(R.id.txt_Pos3);

        txt_Matches.setText(matches);
        txt_Ss_LeftHab1.setText(String.valueOf(numLeftHAB));
        txt_Ss_LeftHab2.setText(String.valueOf(numLeftHAB2));
        txt_noSand.setText(String.valueOf(noSand));
//        Log.w(TAG, "Ratio of Placed to Attempted Gears in Auto = " + auto_SwCubesPlaced + "/" + auto_SwCubesAttempted);
        String carScored = "¹" + String.valueOf(cargL1) + " ²" + String.valueOf(cargL2) + " ³" + String.valueOf(cargL3);
        txt_Ss_cargoScored.setText(carScored);
        String hatScored = "¹" + String.valueOf(panL1) + " ²" + String.valueOf(panL2) + " ³" + String.valueOf(panL3);
        txt_Ss_hatchScored.setText(String.valueOf(hatScored));
        txt_Ss_droppedHatch.setText(String.valueOf(dropped));
        String teleCargo = "¹" + String.valueOf(cargL1) + " ²" + String.valueOf(cargL2) + " ³" + String.valueOf(cargL3);
        txt_Tele_cargoScored.setText(teleCargo);
        String teleHatchPanel = "¹" + String.valueOf(TpanL1) + " ²" + String.valueOf(TpanL2) + " ³" + String.valueOf(TpanL3);
        txt_Tele_hatchScored.setText(teleHatchPanel);
        txt_Tele_droppedHatch.setText(String.valueOf(Tdropped));
        String HabEnd = "⁰"+ String.valueOf(climbH0) + " ¹" + String.valueOf(climbH1) + " ²" + String.valueOf(climbH2) + " ³" + String.valueOf(climbH3);
        txt_HabLvl.setText(HabEnd);
        txt_Lvl1.setText(String.valueOf(auto_B1));
        txt_Lvl2.setText(String.valueOf(auto_B2));
        txt_NoShow.setText(String.valueOf(auto_B3));
        txt_Pos1.setText(String.valueOf(auto_Ps1));
        txt_Pos2.setText(String.valueOf(auto_Ps2));
        txt_Pos3.setText(String.valueOf(auto_Ps3));
// ToDo - Display data for Cargo/Panels 2nd & 3rd

        txt_AutoComments.setText(auto_Comments);

        // ==============================================
        // Display Tele elements
        txt_Lift1NUM.setText(String.valueOf(LiftNm));
        txt_WasLiftedNUM.setText(String.valueOf(WasLifted));

        txt_TeleComments.setText(tele_Comments);

        // ==============================================
        // Display Final elements
        txt_final_LostComm.setText(String.valueOf(final_LostComm));
        txt_final_LostParts.setText(String.valueOf(final_LostParts));
        txt_final_DefGood.setText(String.valueOf(final_DefGood));
        txt_final_BlkSwtch.setText(String.valueOf(final_DefSwitch));
        txt_final_DefBlock.setText(String.valueOf(final_DefBlock));
        txt_final_DefStarve.setText(String.valueOf(final_DefStarve));
        txt_final_NumPen.setText(String.valueOf(final_NumPen));

        txt_FinalComments.setText(final_Comments);


//
//        mBarChart.addBar(new BarModel(2.0f, 0xffff0000));       //1
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(2.0f, 0xffff0000));       //2
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(3.0f, 0xffff0000));       //3
//        mBarChart.addBar(new BarModel(2.0f, 0xff08457e));
//        mBarChart.addBar(new BarModel(5.0f, 0xffff0000));       //4
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(6.0f, 0xffff0000));       //5
//        mBarChart.addBar(new BarModel(5.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(0.0f, 0xffff0000));       //6
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(6.0f, 0xffff0000));       //7
//        mBarChart.addBar(new BarModel(2.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(8.0f, 0xffff0000));       //8
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(10.0f, 0xffff0000));      //9
//        mBarChart.addBar(new BarModel(5.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(7.0f, 0xffff0000));       //10
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(12.0f, 0xffff0000));      //11
//        mBarChart.addBar(new BarModel(5.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(7.0f, 0xffff0000));       //12
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(10.0f, 0xffff0000));      //13
//        mBarChart.addBar(new BarModel(5.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(8.0f, 0xffff0000));       //14
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(10.0f, 0xffff0000));      //15
//        mBarChart.addBar(new BarModel(5.0f,  0xff08457e));
//        mBarChart.addBar(new BarModel(8.0f, 0xffff0000));       //16
//        mBarChart.addBar(new BarModel(4.0f,  0xff08457e));

        mBarChart.startAnimation();

    }

//******************************
    private void init_Values() {
        noSand = 0;
        numLeftHAB = 0;
        numLeftHAB2 = 0;
        auto_Ps1 = 0;
        auto_Ps2 = 0;
        auto_Ps3 = 0;
        cargL1 = 0; cargL2 = 0; cargL3 = 0; TcargL1 = 0; TcargL2 = 0; TcargL3 = 0;
        panL1 = 0; panL2 = 0; panL3 = 0; TpanL1 = 0; TpanL2 = 0; TpanL3 = 0;
// ToDo - initialize data for Cargo/Panels 2nd & 3rd
        numTeleClimbSuccess = 0;
        lift1Num = 0;
        liftedNum = 0;
        LiftNm = 0;
        WasLifted = 0;
        auto_B1 = 0; auto_B2 = 0; auto_B3 = 0;
        auto_Ps1 = 0; auto_Ps2 = 0; auto_Ps3 = 0;
        climbH0 = 0; climbH1 = 0; climbH2 = 0; climbH3 = 0;
        dropped = 0; Tdropped =0;
        auto_Comments = "";
        tele_Comments = "";
        final_Comments = "";
        matches = "";
        final_LostComm = 0;
        final_LostParts = 0;
        final_DefGood = 0;
        final_DefBlock = 0;
        final_DefSwitch = 0;
        final_DefStarve = 0;
        final_NumPen = 0;

        mBarChart.clearChart();
    }


//===========================================================================================
    public class numMatches_OnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {
            String num = " ";
            num = parent.getItemAtPosition(pos).toString();
            Log.w(TAG, ">>>>> NumMatches '" + num + "'");
            switch (num) {
                case "Last":
                    start = numObjects - 1;     //
                    numProcessed = 1;
                    break;
                case "Last 2":
                    if (numObjects > 2) {
                        start = numObjects - 2;     //
                        numProcessed = 2;
                        break;
                    } else {
                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
                        tg.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD);
                        Toast toast = Toast.makeText(getBaseContext(), "***  This team only has " + numObjects +  " match(s) ***", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                    }
                case "Last 3":
                    if (numObjects > 2) {
                        start = numObjects - 3;     //
                        numProcessed = 3;
                        break;
                    } else {
                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
                        tg.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD);
                        Toast toast = Toast.makeText(getBaseContext(), "***  This team only has " + numObjects +  " match(s) ***", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                    }
                case "ALL":
                    start = 0;                  // Start at beginning
                    numProcessed = numObjects;
                    break;
                default:                //
                    Log.e(TAG, "Invalid Sort - " + start);
            }
            Log.w(TAG, "Start = " + num );
            init_Values();
            getMatch_Data();
        }
        public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_viz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.e(TAG, "@@@  Options  @@@ " );
        Log.w(TAG, " \n  \n");
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_screen) {
            String filNam = Pearadox.FRC_Event.toUpperCase() + "-VizMatch"  + "_" + tnum.trim() + ".JPG";
            Log.w(TAG, "File='" + filNam + "'");
            try {
                File imageFile = new File(Environment.getExternalStorageDirectory() + "/download/FRC5414/" + filNam);
                View v1 = getWindow().getDecorView().getRootView();             // **\
                v1.setDrawingCacheEnabled(true);                                // ** \Capture screen
                Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());      // ** /  as bitmap
                v1.setDrawingCacheEnabled(false);                               // **/
                FileOutputStream fos = new FileOutputStream(imageFile);
                int quality = 100;
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos);
                fos.flush();
                fos.close();
                bitmap.recycle();           //release memory
                MediaActionSound sound = new MediaActionSound();
                sound.play(MediaActionSound.SHUTTER_CLICK);
                Toast toast = Toast.makeText(getBaseContext(), "☢☢  Screen captured in Download/FRC5414  ☢☢", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            } catch (Throwable e) {
                // Several error may come out with file handling or DOM
                e.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //###################################################################
//###################################################################
//###################################################################
    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");
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
