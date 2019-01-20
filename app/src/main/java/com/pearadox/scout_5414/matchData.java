package com.pearadox.scout_5414;

import java.io.Serializable;

public class matchData implements Serializable {
    private static final long serialVersionUID = -54145414541400L;
    // ============= AUTO ================
    private String match;                   // Match ID (e.g., Qualifying) and '00' - match #)
    private String team_num;                // Team Number (e.g., '5414')
                                            // *** Pre-Game **
    private boolean pre_cargo;              // Do they carry cargo
    private boolean pre_panel;              // Do they carry a panel
    private String pre_startPos;            // Start Position

    private boolean auto_mode;              // Do they have Autonomous mode?
    private boolean auto_leftHAB;           // Did they leave HAB
    private String auto_comment;            // Auto comment


    // ============== TELE =================
    private boolean tele_LeftRocket_LPan1;  // L-Rocket L-Panel#1
    private boolean tele_LeftRocket_LPan2;  // L-Rocket L-Panel#2
    private boolean tele_LeftRocket_LPan3;  // L-Rocket L-Panel#3
    private boolean tele_LeftRocket_RPan1;  // L-Rocket R-Panel#1
    private boolean tele_LeftRocket_RPan2;  // L-Rocket R-Panel#2
    private boolean tele_LeftRocket_RPan3;  // L-Rocket R-Panel#3
    private boolean tele_LeftRocket_LCarg1; // L-Rocket L-Cargo#1
    private boolean tele_LeftRocket_LCarg2; // L-Rocket L-Cargo#2
    private boolean tele_LeftRocket_LCarg3; // L-Rocket L-Cargo#3
    private boolean tele_LeftRocket_RCarg1; // L-Rocket R-Cargo#1
    private boolean tele_LeftRocket_RCarg2; // L-Rocket R-Cargo#2
    private boolean tele_LeftRocket_RCarg3; // L-Rocket R-Cargo#3

    private boolean tele_RghtRocket_LPan1;  // R-Rocket L-Panel#1
    private boolean tele_RghtRocket_LPan2;  // R-Rocket L-Panel#2
    private boolean tele_RghtRocket_LPan3;  // R-Rocket L-Panel#3
    private boolean tele_RghtRocket_RPan1;  // R-Rocket R-Panel#1
    private boolean tele_RghtRocket_RPan2;  // R-Rocket R-Panel#2
    private boolean tele_RghtRocket_RPan3;  // R-Rocket R-Panel#3
    private boolean tele_RghtRocket_LCarg1; // R-Rocket L-Cargo#1
    private boolean tele_RghtRocket_LCarg2; // R-Rocket L-Cargo#2
    private boolean tele_RghtRocket_LCarg3; // R-Rocket L-Cargo#3
    private boolean tele_RghtRocket_RCarg1; // R-Rocket R-Cargo#1
    private boolean tele_RghtRocket_RCarg2; // R-Rocket R-Cargo#2
    private boolean tele_RghtRocket_RCarg3; // R-Rocket R-Cargo#3

    private boolean tele_cube_pickup;       // Did they pick up cube(s)
    private boolean tele_Panel_pickup;      // Did they pick up Panel(s)
    private boolean tele_got_lift;          // Did they get lifted to higher HAB Level
    private boolean tele_lifted;            // Did they lift to higher HAB Level
    private int     tele_level_num;         // Ended on What HAB Level (0-3)
    private int     tele_num_Penalties;     // How many penalties received?
    private String  tele_comment;           // Tele comment

    // ============= Final  ================
    private boolean final_lostParts;         // Did they lose parts
    private boolean final_lostComms;         // Did they lose communication
    private boolean final_defense_good;      // Was their overall Defense Good (bad=false)
    private boolean final_def_Lane;          // Did they use Lane Defense
    private boolean final_def_Block;         // Did they use Blocking Defense
    private boolean final_def_BlockSwitch;   // Did they block the Switch
    /*=============================================================================*/
    private String  final_comment;           // Final comment
    private String  final_studID;            // Student doing the scouting
    private String  final_dateTime;          // Date & Time data was saved

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    public matchData(String match, String team_num, boolean pre_cargo, boolean pre_panel, String pre_startPos, boolean auto_mode, boolean auto_leftHAB, String auto_comment, boolean tele_LeftRocket_LPan1, boolean tele_LeftRocket_LPan2, boolean tele_LeftRocket_LPan3, boolean tele_LeftRocket_RPan1, boolean tele_LeftRocket_RPan2, boolean tele_LeftRocket_RPan3, boolean tele_LeftRocket_LCarg1, boolean tele_LeftRocket_LCarg2, boolean tele_LeftRocket_LCarg3, boolean tele_LeftRocket_RCarg1, boolean tele_LeftRocket_RCarg2, boolean tele_LeftRocket_RCarg3, boolean tele_RghtRocket_LPan1, boolean tele_RghtRocket_LPan2, boolean tele_RghtRocket_LPan3, boolean tele_RghtRocket_RPan1, boolean tele_RghtRocket_RPan2, boolean tele_RghtRocket_RPan3, boolean tele_RghtRocket_LCarg1, boolean tele_RghtRocket_LCarg2, boolean tele_RghtRocket_LCarg3, boolean tele_RghtRocket_RCarg1, boolean tele_RghtRocket_RCarg2, boolean tele_RghtRocket_RCarg3, boolean tele_cube_pickup, boolean tele_Panel_pickup, boolean tele_got_lift, boolean tele_lifted, int tele_level_num, int tele_num_Penalties, String tele_comment, boolean final_lostParts, boolean final_lostComms, boolean final_defense_good, boolean final_def_Lane, boolean final_def_Block, boolean final_def_BlockSwitch, String final_comment, String final_studID, String final_dateTime) {
        this.match = match;
        this.team_num = team_num;
        this.pre_cargo = pre_cargo;
        this.pre_panel = pre_panel;
        this.pre_startPos = pre_startPos;
        this.auto_mode = auto_mode;
        this.auto_leftHAB = auto_leftHAB;
        this.auto_comment = auto_comment;
        this.tele_LeftRocket_LPan1 = tele_LeftRocket_LPan1;
        this.tele_LeftRocket_LPan2 = tele_LeftRocket_LPan2;
        this.tele_LeftRocket_LPan3 = tele_LeftRocket_LPan3;
        this.tele_LeftRocket_RPan1 = tele_LeftRocket_RPan1;
        this.tele_LeftRocket_RPan2 = tele_LeftRocket_RPan2;
        this.tele_LeftRocket_RPan3 = tele_LeftRocket_RPan3;
        this.tele_LeftRocket_LCarg1 = tele_LeftRocket_LCarg1;
        this.tele_LeftRocket_LCarg2 = tele_LeftRocket_LCarg2;
        this.tele_LeftRocket_LCarg3 = tele_LeftRocket_LCarg3;
        this.tele_LeftRocket_RCarg1 = tele_LeftRocket_RCarg1;
        this.tele_LeftRocket_RCarg2 = tele_LeftRocket_RCarg2;
        this.tele_LeftRocket_RCarg3 = tele_LeftRocket_RCarg3;
        this.tele_RghtRocket_LPan1 = tele_RghtRocket_LPan1;
        this.tele_RghtRocket_LPan2 = tele_RghtRocket_LPan2;
        this.tele_RghtRocket_LPan3 = tele_RghtRocket_LPan3;
        this.tele_RghtRocket_RPan1 = tele_RghtRocket_RPan1;
        this.tele_RghtRocket_RPan2 = tele_RghtRocket_RPan2;
        this.tele_RghtRocket_RPan3 = tele_RghtRocket_RPan3;
        this.tele_RghtRocket_LCarg1 = tele_RghtRocket_LCarg1;
        this.tele_RghtRocket_LCarg2 = tele_RghtRocket_LCarg2;
        this.tele_RghtRocket_LCarg3 = tele_RghtRocket_LCarg3;
        this.tele_RghtRocket_RCarg1 = tele_RghtRocket_RCarg1;
        this.tele_RghtRocket_RCarg2 = tele_RghtRocket_RCarg2;
        this.tele_RghtRocket_RCarg3 = tele_RghtRocket_RCarg3;
        this.tele_cube_pickup = tele_cube_pickup;
        this.tele_Panel_pickup = tele_Panel_pickup;
        this.tele_got_lift = tele_got_lift;
        this.tele_lifted = tele_lifted;
        this.tele_level_num = tele_level_num;
        this.tele_num_Penalties = tele_num_Penalties;
        this.tele_comment = tele_comment;
        this.final_lostParts = final_lostParts;
        this.final_lostComms = final_lostComms;
        this.final_defense_good = final_defense_good;
        this.final_def_Lane = final_def_Lane;
        this.final_def_Block = final_def_Block;
        this.final_def_BlockSwitch = final_def_BlockSwitch;
        this.final_comment = final_comment;
        this.final_studID = final_studID;
        this.final_dateTime = final_dateTime;
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
// Default constructor required for calls to
// DataSnapshot.getValue(matchData.class)
public matchData() {

}

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
// Getters & Setters


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getTeam_num() {
        return team_num;
    }

    public void setTeam_num(String team_num) {
        this.team_num = team_num;
    }

    public boolean isPre_cargo() {
        return pre_cargo;
    }

    public void setPre_cargo(boolean pre_cargo) {
        this.pre_cargo = pre_cargo;
    }

    public boolean isPre_panel() {
        return pre_panel;
    }

    public void setPre_panel(boolean pre_panel) {
        this.pre_panel = pre_panel;
    }

    public String getPre_startPos() {
        return pre_startPos;
    }

    public void setPre_startPos(String pre_startPos) {
        this.pre_startPos = pre_startPos;
    }

    public boolean isAuto_mode() {
        return auto_mode;
    }

    public void setAuto_mode(boolean auto_mode) {
        this.auto_mode = auto_mode;
    }

    public boolean isAuto_leftHAB() {
        return auto_leftHAB;
    }

    public void setAuto_leftHAB(boolean auto_leftHAB) {
        this.auto_leftHAB = auto_leftHAB;
    }

    public String getAuto_comment() {
        return auto_comment;
    }

    public void setAuto_comment(String auto_comment) {
        this.auto_comment = auto_comment;
    }

    public boolean isTele_LeftRocket_LPan1() {
        return tele_LeftRocket_LPan1;
    }

    public void setTele_LeftRocket_LPan1(boolean tele_LeftRocket_LPan1) {
        this.tele_LeftRocket_LPan1 = tele_LeftRocket_LPan1;
    }

    public boolean isTele_LeftRocket_LPan2() {
        return tele_LeftRocket_LPan2;
    }

    public void setTele_LeftRocket_LPan2(boolean tele_LeftRocket_LPan2) {
        this.tele_LeftRocket_LPan2 = tele_LeftRocket_LPan2;
    }

    public boolean isTele_LeftRocket_LPan3() {
        return tele_LeftRocket_LPan3;
    }

    public void setTele_LeftRocket_LPan3(boolean tele_LeftRocket_LPan3) {
        this.tele_LeftRocket_LPan3 = tele_LeftRocket_LPan3;
    }

    public boolean isTele_LeftRocket_RPan1() {
        return tele_LeftRocket_RPan1;
    }

    public void setTele_LeftRocket_RPan1(boolean tele_LeftRocket_RPan1) {
        this.tele_LeftRocket_RPan1 = tele_LeftRocket_RPan1;
    }

    public boolean isTele_LeftRocket_RPan2() {
        return tele_LeftRocket_RPan2;
    }

    public void setTele_LeftRocket_RPan2(boolean tele_LeftRocket_RPan2) {
        this.tele_LeftRocket_RPan2 = tele_LeftRocket_RPan2;
    }

    public boolean isTele_LeftRocket_RPan3() {
        return tele_LeftRocket_RPan3;
    }

    public void setTele_LeftRocket_RPan3(boolean tele_LeftRocket_RPan3) {
        this.tele_LeftRocket_RPan3 = tele_LeftRocket_RPan3;
    }

    public boolean isTele_LeftRocket_LCarg1() {
        return tele_LeftRocket_LCarg1;
    }

    public void setTele_LeftRocket_LCarg1(boolean tele_LeftRocket_LCarg1) {
        this.tele_LeftRocket_LCarg1 = tele_LeftRocket_LCarg1;
    }

    public boolean isTele_LeftRocket_LCarg2() {
        return tele_LeftRocket_LCarg2;
    }

    public void setTele_LeftRocket_LCarg2(boolean tele_LeftRocket_LCarg2) {
        this.tele_LeftRocket_LCarg2 = tele_LeftRocket_LCarg2;
    }

    public boolean isTele_LeftRocket_LCarg3() {
        return tele_LeftRocket_LCarg3;
    }

    public void setTele_LeftRocket_LCarg3(boolean tele_LeftRocket_LCarg3) {
        this.tele_LeftRocket_LCarg3 = tele_LeftRocket_LCarg3;
    }

    public boolean isTele_LeftRocket_RCarg1() {
        return tele_LeftRocket_RCarg1;
    }

    public void setTele_LeftRocket_RCarg1(boolean tele_LeftRocket_RCarg1) {
        this.tele_LeftRocket_RCarg1 = tele_LeftRocket_RCarg1;
    }

    public boolean isTele_LeftRocket_RCarg2() {
        return tele_LeftRocket_RCarg2;
    }

    public void setTele_LeftRocket_RCarg2(boolean tele_LeftRocket_RCarg2) {
        this.tele_LeftRocket_RCarg2 = tele_LeftRocket_RCarg2;
    }

    public boolean isTele_LeftRocket_RCarg3() {
        return tele_LeftRocket_RCarg3;
    }

    public void setTele_LeftRocket_RCarg3(boolean tele_LeftRocket_RCarg3) {
        this.tele_LeftRocket_RCarg3 = tele_LeftRocket_RCarg3;
    }

    public boolean isTele_RghtRocket_LPan1() {
        return tele_RghtRocket_LPan1;
    }

    public void setTele_RghtRocket_LPan1(boolean tele_RghtRocket_LPan1) {
        this.tele_RghtRocket_LPan1 = tele_RghtRocket_LPan1;
    }

    public boolean isTele_RghtRocket_LPan2() {
        return tele_RghtRocket_LPan2;
    }

    public void setTele_RghtRocket_LPan2(boolean tele_RghtRocket_LPan2) {
        this.tele_RghtRocket_LPan2 = tele_RghtRocket_LPan2;
    }

    public boolean isTele_RghtRocket_LPan3() {
        return tele_RghtRocket_LPan3;
    }

    public void setTele_RghtRocket_LPan3(boolean tele_RghtRocket_LPan3) {
        this.tele_RghtRocket_LPan3 = tele_RghtRocket_LPan3;
    }

    public boolean isTele_RghtRocket_RPan1() {
        return tele_RghtRocket_RPan1;
    }

    public void setTele_RghtRocket_RPan1(boolean tele_RghtRocket_RPan1) {
        this.tele_RghtRocket_RPan1 = tele_RghtRocket_RPan1;
    }

    public boolean isTele_RghtRocket_RPan2() {
        return tele_RghtRocket_RPan2;
    }

    public void setTele_RghtRocket_RPan2(boolean tele_RghtRocket_RPan2) {
        this.tele_RghtRocket_RPan2 = tele_RghtRocket_RPan2;
    }

    public boolean isTele_RghtRocket_RPan3() {
        return tele_RghtRocket_RPan3;
    }

    public void setTele_RghtRocket_RPan3(boolean tele_RghtRocket_RPan3) {
        this.tele_RghtRocket_RPan3 = tele_RghtRocket_RPan3;
    }

    public boolean isTele_RghtRocket_LCarg1() {
        return tele_RghtRocket_LCarg1;
    }

    public void setTele_RghtRocket_LCarg1(boolean tele_RghtRocket_LCarg1) {
        this.tele_RghtRocket_LCarg1 = tele_RghtRocket_LCarg1;
    }

    public boolean isTele_RghtRocket_LCarg2() {
        return tele_RghtRocket_LCarg2;
    }

    public void setTele_RghtRocket_LCarg2(boolean tele_RghtRocket_LCarg2) {
        this.tele_RghtRocket_LCarg2 = tele_RghtRocket_LCarg2;
    }

    public boolean isTele_RghtRocket_LCarg3() {
        return tele_RghtRocket_LCarg3;
    }

    public void setTele_RghtRocket_LCarg3(boolean tele_RghtRocket_LCarg3) {
        this.tele_RghtRocket_LCarg3 = tele_RghtRocket_LCarg3;
    }

    public boolean isTele_RghtRocket_RCarg1() {
        return tele_RghtRocket_RCarg1;
    }

    public void setTele_RghtRocket_RCarg1(boolean tele_RghtRocket_RCarg1) {
        this.tele_RghtRocket_RCarg1 = tele_RghtRocket_RCarg1;
    }

    public boolean isTele_RghtRocket_RCarg2() {
        return tele_RghtRocket_RCarg2;
    }

    public void setTele_RghtRocket_RCarg2(boolean tele_RghtRocket_RCarg2) {
        this.tele_RghtRocket_RCarg2 = tele_RghtRocket_RCarg2;
    }

    public boolean isTele_RghtRocket_RCarg3() {
        return tele_RghtRocket_RCarg3;
    }

    public void setTele_RghtRocket_RCarg3(boolean tele_RghtRocket_RCarg3) {
        this.tele_RghtRocket_RCarg3 = tele_RghtRocket_RCarg3;
    }

    public boolean isTele_cube_pickup() {
        return tele_cube_pickup;
    }

    public void setTele_cube_pickup(boolean tele_cube_pickup) {
        this.tele_cube_pickup = tele_cube_pickup;
    }

    public boolean isTele_Panel_pickup() {
        return tele_Panel_pickup;
    }

    public void setTele_Panel_pickup(boolean tele_Panel_pickup) {
        this.tele_Panel_pickup = tele_Panel_pickup;
    }

    public boolean isTele_got_lift() {
        return tele_got_lift;
    }

    public void setTele_got_lift(boolean tele_got_lift) {
        this.tele_got_lift = tele_got_lift;
    }

    public boolean isTele_lifted() {
        return tele_lifted;
    }

    public void setTele_lifted(boolean tele_lifted) {
        this.tele_lifted = tele_lifted;
    }

    public int getTele_level_num() {
        return tele_level_num;
    }

    public void setTele_level_num(int tele_level_num) {
        this.tele_level_num = tele_level_num;
    }

    public int getTele_num_Penalties() {
        return tele_num_Penalties;
    }

    public void setTele_num_Penalties(int tele_num_Penalties) {
        this.tele_num_Penalties = tele_num_Penalties;
    }

    public String getTele_comment() {
        return tele_comment;
    }

    public void setTele_comment(String tele_comment) {
        this.tele_comment = tele_comment;
    }

    public boolean isFinal_lostParts() {
        return final_lostParts;
    }

    public void setFinal_lostParts(boolean final_lostParts) {
        this.final_lostParts = final_lostParts;
    }

    public boolean isFinal_lostComms() {
        return final_lostComms;
    }

    public void setFinal_lostComms(boolean final_lostComms) {
        this.final_lostComms = final_lostComms;
    }

    public boolean isFinal_defense_good() {
        return final_defense_good;
    }

    public void setFinal_defense_good(boolean final_defense_good) {
        this.final_defense_good = final_defense_good;
    }

    public boolean isFinal_def_Lane() {
        return final_def_Lane;
    }

    public void setFinal_def_Lane(boolean final_def_Lane) {
        this.final_def_Lane = final_def_Lane;
    }

    public boolean isFinal_def_Block() {
        return final_def_Block;
    }

    public void setFinal_def_Block(boolean final_def_Block) {
        this.final_def_Block = final_def_Block;
    }

    public boolean isFinal_def_BlockSwitch() {
        return final_def_BlockSwitch;
    }

    public void setFinal_def_BlockSwitch(boolean final_def_BlockSwitch) {
        this.final_def_BlockSwitch = final_def_BlockSwitch;
    }

    public String getFinal_comment() {
        return final_comment;
    }

    public void setFinal_comment(String final_comment) {
        this.final_comment = final_comment;
    }

    public String getFinal_studID() {
        return final_studID;
    }

    public void setFinal_studID(String final_studID) {
        this.final_studID = final_studID;
    }

    public String getFinal_dateTime() {
        return final_dateTime;
    }

    public void setFinal_dateTime(String final_dateTime) {
        this.final_dateTime = final_dateTime;
    }

    // New Match Data Object *** GLF 1/20/19

// End of Getters/Setters

}