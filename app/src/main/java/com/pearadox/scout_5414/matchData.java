package com.pearadox.scout_5414;

import java.io.Serializable;

public class matchData implements Serializable {
    private static final long serialVersionUID = -54145414541400L;
    // ============= SAND ================
    private String match;                   // Match ID (e.g., Qualifying) and '00' - match #)
    private String team_num;                // Team Number (e.g., '5414')
                                            // *** Pre-Game **
    private boolean pre_cargo;              // Do they carry cargo
    private boolean pre_panel;              // Do they carry a panel
    private String  pre_startPos;           // Start Position
    private int     pre_PlayerSta;          // Player Station (1-3)

                                            // ---- AFTER Start ----
    private boolean sand_mode;              // Do they have Autonomous mode?
    private boolean sand_leftHAB;           // Did they leave HAB
    private String  sand_comment;           // Auto comment

    private boolean sand_LeftRocket_LPan1;  // L-Rocket L-Panel#1
    private boolean sand_LeftRocket_LPan2;  // L-Rocket L-Panel#2
    private boolean sand_LeftRocket_LPan3;  // L-Rocket L-Panel#3
    private boolean sand_LeftRocket_RPan1;  // L-Rocket R-Panel#1
    private boolean sand_LeftRocket_RPan2;  // L-Rocket R-Panel#2
    private boolean sand_LeftRocket_RPan3;  // L-Rocket R-Panel#3
    private boolean sand_LeftRocket_LCarg1; // L-Rocket L-Cargo#1
    private boolean sand_LeftRocket_LCarg2; // L-Rocket L-Cargo#2
    private boolean sand_LeftRocket_LCarg3; // L-Rocket L-Cargo#3
    private boolean sand_LeftRocket_RCarg1; // L-Rocket R-Cargo#1
    private boolean sand_LeftRocket_RCarg2; // L-Rocket R-Cargo#2
    private boolean sand_LeftRocket_RCarg3; // L-Rocket R-Cargo#3

    private boolean sand_CargoLPan1;        // Cargo L-Panel#1
    private boolean sand_CargoLPan2;        // Cargo L-Panel#2
    private boolean sand_CargoLPan3;        // Cargo L-Panel#3
    private boolean sand_CargoRPan1;        // Cargo R-Panel#1
    private boolean sand_CargoRPan2;        // Cargo R-Panel#2
    private boolean sand_CargoRPan3;        // Cargo R-Panel#3
    private boolean sand_CargoLCarg1;       // Cargo L-Cargo#1
    private boolean sand_CargoLCarg2;       // Cargo L-Cargo#2
    private boolean sand_CargoLCarg3;       // Cargo L-Cargo#3
    private boolean sand_CargoRCarg1;       // Cargo R-Cargo#1
    private boolean sand_CargoRCarg2;       // Cargo R-Cargo#2
    private boolean sand_CargoRCarg3;       // Cargo R-Cargo#3
    private boolean sand_CargoEndLPan1;     // Cargo End L-Panel#1
    private boolean sand_CargoEndLCarg1;    // Cargo End L-Cargo#1
    private boolean sand_CargoEndRPan1;     // Cargo End R-Panel#1
    private boolean sand_CargoEndRCarg1;    // Cargo End R-Cargo#1

    private boolean sand_RghtRocket_LPan1;  // R-Rocket L-Panel#1
    private boolean sand_RghtRocket_LPan2;  // R-Rocket L-Panel#2
    private boolean sand_RghtRocket_LPan3;  // R-Rocket L-Panel#3
    private boolean sand_RghtRocket_RPan1;  // R-Rocket R-Panel#1
    private boolean sand_RghtRocket_RPan2;  // R-Rocket R-Panel#2
    private boolean sand_RghtRocket_RPan3;  // R-Rocket R-Panel#3
    private boolean sand_RghtRocket_LCarg1; // R-Rocket L-Cargo#1
    private boolean sand_RghtRocket_LCarg2; // R-Rocket L-Cargo#2
    private boolean sand_RghtRocket_LCarg3; // R-Rocket L-Cargo#3
    private boolean sand_RghtRocket_RCarg1; // R-Rocket R-Cargo#1
    private boolean sand_RghtRocket_RCarg2; // R-Rocket R-Cargo#2
    private boolean sand_RghtRocket_RCarg3; // R-Rocket R-Cargo#3


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

    private boolean tele_CargoLPan1;        // Cargo L-Panel#1
    private boolean tele_CargoLPan2;        // Cargo L-Panel#2
    private boolean tele_CargoLPan3;        // Cargo L-Panel#3
    private boolean tele_CargoRPan1;        // Cargo R-Panel#1
    private boolean tele_CargoRPan2;        // Cargo R-Panel#2
    private boolean tele_CargoRPan3;        // Cargo R-Panel#3
    private boolean tele_CargoLCarg1;       // Cargo L-Cargo#1
    private boolean tele_CargoLCarg2;       // Cargo L-Cargo#2
    private boolean tele_CargoLCarg3;       // Cargo L-Cargo#3
    private boolean tele_CargoRCarg1;       // Cargo R-Cargo#1
    private boolean tele_CargoRCarg2;       // Cargo R-Cargo#2
    private boolean tele_CargoRCarg3;       // Cargo R-Cargo#3
    private boolean tele_CargoEndLPan1;     // Cargo End L-Panel#1
    private boolean tele_CargoEndLCarg1;    // Cargo End L-Cargo#1
    private boolean tele_CargoEndRPan1;     // Cargo End R-Panel#1
    private boolean tele_CargoEndRCarg1;    // Cargo End R-Cargo#1

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
//  Constructor


    public matchData(String match, String team_num, boolean pre_cargo, boolean pre_panel, String pre_startPos, int pre_PlayerSta, boolean sand_mode, boolean sand_leftHAB, String sand_comment, boolean sand_LeftRocket_LPan1, boolean sand_LeftRocket_LPan2, boolean sand_LeftRocket_LPan3, boolean sand_LeftRocket_RPan1, boolean sand_LeftRocket_RPan2, boolean sand_LeftRocket_RPan3, boolean sand_LeftRocket_LCarg1, boolean sand_LeftRocket_LCarg2, boolean sand_LeftRocket_LCarg3, boolean sand_LeftRocket_RCarg1, boolean sand_LeftRocket_RCarg2, boolean sand_LeftRocket_RCarg3, boolean sand_CargoLPan1, boolean sand_CargoLPan2, boolean sand_CargoLPan3, boolean sand_CargoRPan1, boolean sand_CargoRPan2, boolean sand_CargoRPan3, boolean sand_CargoLCarg1, boolean sand_CargoLCarg2, boolean sand_CargoLCarg3, boolean sand_CargoRCarg1, boolean sand_CargoRCarg2, boolean sand_CargoRCarg3, boolean sand_CargoEndLPan1, boolean sand_CargoEndLCarg1, boolean sand_CargoEndRPan1, boolean sand_CargoEndRCarg1, boolean sand_RghtRocket_LPan1, boolean sand_RghtRocket_LPan2, boolean sand_RghtRocket_LPan3, boolean sand_RghtRocket_RPan1, boolean sand_RghtRocket_RPan2, boolean sand_RghtRocket_RPan3, boolean sand_RghtRocket_LCarg1, boolean sand_RghtRocket_LCarg2, boolean sand_RghtRocket_LCarg3, boolean sand_RghtRocket_RCarg1, boolean sand_RghtRocket_RCarg2, boolean sand_RghtRocket_RCarg3, boolean tele_LeftRocket_LPan1, boolean tele_LeftRocket_LPan2, boolean tele_LeftRocket_LPan3, boolean tele_LeftRocket_RPan1, boolean tele_LeftRocket_RPan2, boolean tele_LeftRocket_RPan3, boolean tele_LeftRocket_LCarg1, boolean tele_LeftRocket_LCarg2, boolean tele_LeftRocket_LCarg3, boolean tele_LeftRocket_RCarg1, boolean tele_LeftRocket_RCarg2, boolean tele_LeftRocket_RCarg3, boolean tele_CargoLPan1, boolean tele_CargoLPan2, boolean tele_CargoLPan3, boolean tele_CargoRPan1, boolean tele_CargoRPan2, boolean tele_CargoRPan3, boolean tele_CargoLCarg1, boolean tele_CargoLCarg2, boolean tele_CargoLCarg3, boolean tele_CargoRCarg1, boolean tele_CargoRCarg2, boolean tele_CargoRCarg3, boolean tele_CargoEndLPan1, boolean tele_CargoEndLCarg1, boolean tele_CargoEndRPan1, boolean tele_CargoEndRCarg1, boolean tele_RghtRocket_LPan1, boolean tele_RghtRocket_LPan2, boolean tele_RghtRocket_LPan3, boolean tele_RghtRocket_RPan1, boolean tele_RghtRocket_RPan2, boolean tele_RghtRocket_RPan3, boolean tele_RghtRocket_LCarg1, boolean tele_RghtRocket_LCarg2, boolean tele_RghtRocket_LCarg3, boolean tele_RghtRocket_RCarg1, boolean tele_RghtRocket_RCarg2, boolean tele_RghtRocket_RCarg3, boolean tele_cube_pickup, boolean tele_Panel_pickup, boolean tele_got_lift, boolean tele_lifted, int tele_level_num, int tele_num_Penalties, String tele_comment, boolean final_lostParts, boolean final_lostComms, boolean final_defense_good, boolean final_def_Lane, boolean final_def_Block, boolean final_def_BlockSwitch, String final_comment, String final_studID, String final_dateTime) {
        this.match = match;
        this.team_num = team_num;
        this.pre_cargo = pre_cargo;
        this.pre_panel = pre_panel;
        this.pre_startPos = pre_startPos;
        this.pre_PlayerSta = pre_PlayerSta;
        this.sand_mode = sand_mode;
        this.sand_leftHAB = sand_leftHAB;
        this.sand_comment = sand_comment;
        this.sand_LeftRocket_LPan1 = sand_LeftRocket_LPan1;
        this.sand_LeftRocket_LPan2 = sand_LeftRocket_LPan2;
        this.sand_LeftRocket_LPan3 = sand_LeftRocket_LPan3;
        this.sand_LeftRocket_RPan1 = sand_LeftRocket_RPan1;
        this.sand_LeftRocket_RPan2 = sand_LeftRocket_RPan2;
        this.sand_LeftRocket_RPan3 = sand_LeftRocket_RPan3;
        this.sand_LeftRocket_LCarg1 = sand_LeftRocket_LCarg1;
        this.sand_LeftRocket_LCarg2 = sand_LeftRocket_LCarg2;
        this.sand_LeftRocket_LCarg3 = sand_LeftRocket_LCarg3;
        this.sand_LeftRocket_RCarg1 = sand_LeftRocket_RCarg1;
        this.sand_LeftRocket_RCarg2 = sand_LeftRocket_RCarg2;
        this.sand_LeftRocket_RCarg3 = sand_LeftRocket_RCarg3;
        this.sand_CargoLPan1 = sand_CargoLPan1;
        this.sand_CargoLPan2 = sand_CargoLPan2;
        this.sand_CargoLPan3 = sand_CargoLPan3;
        this.sand_CargoRPan1 = sand_CargoRPan1;
        this.sand_CargoRPan2 = sand_CargoRPan2;
        this.sand_CargoRPan3 = sand_CargoRPan3;
        this.sand_CargoLCarg1 = sand_CargoLCarg1;
        this.sand_CargoLCarg2 = sand_CargoLCarg2;
        this.sand_CargoLCarg3 = sand_CargoLCarg3;
        this.sand_CargoRCarg1 = sand_CargoRCarg1;
        this.sand_CargoRCarg2 = sand_CargoRCarg2;
        this.sand_CargoRCarg3 = sand_CargoRCarg3;
        this.sand_CargoEndLPan1 = sand_CargoEndLPan1;
        this.sand_CargoEndLCarg1 = sand_CargoEndLCarg1;
        this.sand_CargoEndRPan1 = sand_CargoEndRPan1;
        this.sand_CargoEndRCarg1 = sand_CargoEndRCarg1;
        this.sand_RghtRocket_LPan1 = sand_RghtRocket_LPan1;
        this.sand_RghtRocket_LPan2 = sand_RghtRocket_LPan2;
        this.sand_RghtRocket_LPan3 = sand_RghtRocket_LPan3;
        this.sand_RghtRocket_RPan1 = sand_RghtRocket_RPan1;
        this.sand_RghtRocket_RPan2 = sand_RghtRocket_RPan2;
        this.sand_RghtRocket_RPan3 = sand_RghtRocket_RPan3;
        this.sand_RghtRocket_LCarg1 = sand_RghtRocket_LCarg1;
        this.sand_RghtRocket_LCarg2 = sand_RghtRocket_LCarg2;
        this.sand_RghtRocket_LCarg3 = sand_RghtRocket_LCarg3;
        this.sand_RghtRocket_RCarg1 = sand_RghtRocket_RCarg1;
        this.sand_RghtRocket_RCarg2 = sand_RghtRocket_RCarg2;
        this.sand_RghtRocket_RCarg3 = sand_RghtRocket_RCarg3;
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
        this.tele_CargoLPan1 = tele_CargoLPan1;
        this.tele_CargoLPan2 = tele_CargoLPan2;
        this.tele_CargoLPan3 = tele_CargoLPan3;
        this.tele_CargoRPan1 = tele_CargoRPan1;
        this.tele_CargoRPan2 = tele_CargoRPan2;
        this.tele_CargoRPan3 = tele_CargoRPan3;
        this.tele_CargoLCarg1 = tele_CargoLCarg1;
        this.tele_CargoLCarg2 = tele_CargoLCarg2;
        this.tele_CargoLCarg3 = tele_CargoLCarg3;
        this.tele_CargoRCarg1 = tele_CargoRCarg1;
        this.tele_CargoRCarg2 = tele_CargoRCarg2;
        this.tele_CargoRCarg3 = tele_CargoRCarg3;
        this.tele_CargoEndLPan1 = tele_CargoEndLPan1;
        this.tele_CargoEndLCarg1 = tele_CargoEndLCarg1;
        this.tele_CargoEndRPan1 = tele_CargoEndRPan1;
        this.tele_CargoEndRCarg1 = tele_CargoEndRCarg1;
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

    //
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

    public void setPre_PlayerSta(int pre_PlayerSta) {
        this.pre_PlayerSta = pre_PlayerSta;
    }

    public boolean isSand_mode() {
        return sand_mode;
    }

    public void setSand_mode(boolean sand_mode) {
        this.sand_mode = sand_mode;
    }

    public boolean isSand_leftHAB() {
        return sand_leftHAB;
    }

    public void setSand_leftHAB(boolean sand_leftHAB) {
        this.sand_leftHAB = sand_leftHAB;
    }

    public String getSand_comment() {
        return sand_comment;
    }

    public void setSand_comment(String sand_comment) {
        this.sand_comment = sand_comment;
    }

    public boolean isSand_LeftRocket_LPan1() {
        return sand_LeftRocket_LPan1;
    }

    public void setSand_LeftRocket_LPan1(boolean sand_LeftRocket_LPan1) {
        this.sand_LeftRocket_LPan1 = sand_LeftRocket_LPan1;
    }

    public boolean isSand_LeftRocket_LPan2() {
        return sand_LeftRocket_LPan2;
    }

    public void setSand_LeftRocket_LPan2(boolean sand_LeftRocket_LPan2) {
        this.sand_LeftRocket_LPan2 = sand_LeftRocket_LPan2;
    }

    public boolean isSand_LeftRocket_LPan3() {
        return sand_LeftRocket_LPan3;
    }

    public void setSand_LeftRocket_LPan3(boolean sand_LeftRocket_LPan3) {
        this.sand_LeftRocket_LPan3 = sand_LeftRocket_LPan3;
    }

    public boolean isSand_LeftRocket_RPan1() {
        return sand_LeftRocket_RPan1;
    }

    public void setSand_LeftRocket_RPan1(boolean sand_LeftRocket_RPan1) {
        this.sand_LeftRocket_RPan1 = sand_LeftRocket_RPan1;
    }

    public boolean isSand_LeftRocket_RPan2() {
        return sand_LeftRocket_RPan2;
    }

    public void setSand_LeftRocket_RPan2(boolean sand_LeftRocket_RPan2) {
        this.sand_LeftRocket_RPan2 = sand_LeftRocket_RPan2;
    }

    public boolean isSand_LeftRocket_RPan3() {
        return sand_LeftRocket_RPan3;
    }

    public void setSand_LeftRocket_RPan3(boolean sand_LeftRocket_RPan3) {
        this.sand_LeftRocket_RPan3 = sand_LeftRocket_RPan3;
    }

    public boolean isSand_LeftRocket_LCarg1() {
        return sand_LeftRocket_LCarg1;
    }

    public void setSand_LeftRocket_LCarg1(boolean sand_LeftRocket_LCarg1) {
        this.sand_LeftRocket_LCarg1 = sand_LeftRocket_LCarg1;
    }

    public boolean isSand_LeftRocket_LCarg2() {
        return sand_LeftRocket_LCarg2;
    }

    public void setSand_LeftRocket_LCarg2(boolean sand_LeftRocket_LCarg2) {
        this.sand_LeftRocket_LCarg2 = sand_LeftRocket_LCarg2;
    }

    public boolean isSand_LeftRocket_LCarg3() {
        return sand_LeftRocket_LCarg3;
    }

    public void setSand_LeftRocket_LCarg3(boolean sand_LeftRocket_LCarg3) {
        this.sand_LeftRocket_LCarg3 = sand_LeftRocket_LCarg3;
    }

    public boolean isSand_LeftRocket_RCarg1() {
        return sand_LeftRocket_RCarg1;
    }

    public void setSand_LeftRocket_RCarg1(boolean sand_LeftRocket_RCarg1) {
        this.sand_LeftRocket_RCarg1 = sand_LeftRocket_RCarg1;
    }

    public boolean isSand_LeftRocket_RCarg2() {
        return sand_LeftRocket_RCarg2;
    }

    public void setSand_LeftRocket_RCarg2(boolean sand_LeftRocket_RCarg2) {
        this.sand_LeftRocket_RCarg2 = sand_LeftRocket_RCarg2;
    }

    public boolean isSand_LeftRocket_RCarg3() {
        return sand_LeftRocket_RCarg3;
    }

    public void setSand_LeftRocket_RCarg3(boolean sand_LeftRocket_RCarg3) {
        this.sand_LeftRocket_RCarg3 = sand_LeftRocket_RCarg3;
    }

    public boolean isSand_CargoLPan1() {
        return sand_CargoLPan1;
    }

    public void setSand_CargoLPan1(boolean sand_CargoLPan1) {
        this.sand_CargoLPan1 = sand_CargoLPan1;
    }

    public boolean isSand_CargoLPan2() {
        return sand_CargoLPan2;
    }

    public void setSand_CargoLPan2(boolean sand_CargoLPan2) {
        this.sand_CargoLPan2 = sand_CargoLPan2;
    }

    public boolean isSand_CargoLPan3() {
        return sand_CargoLPan3;
    }

    public void setSand_CargoLPan3(boolean sand_CargoLPan3) {
        this.sand_CargoLPan3 = sand_CargoLPan3;
    }

    public boolean isSand_CargoRPan1() {
        return sand_CargoRPan1;
    }

    public void setSand_CargoRPan1(boolean sand_CargoRPan1) {
        this.sand_CargoRPan1 = sand_CargoRPan1;
    }

    public boolean isSand_CargoRPan2() {
        return sand_CargoRPan2;
    }

    public void setSand_CargoRPan2(boolean sand_CargoRPan2) {
        this.sand_CargoRPan2 = sand_CargoRPan2;
    }

    public boolean isSand_CargoRPan3() {
        return sand_CargoRPan3;
    }

    public void setSand_CargoRPan3(boolean sand_CargoRPan3) {
        this.sand_CargoRPan3 = sand_CargoRPan3;
    }

    public boolean isSand_CargoLCarg1() {
        return sand_CargoLCarg1;
    }

    public void setSand_CargoLCarg1(boolean sand_CargoLCarg1) {
        this.sand_CargoLCarg1 = sand_CargoLCarg1;
    }

    public boolean isSand_CargoLCarg2() {
        return sand_CargoLCarg2;
    }

    public void setSand_CargoLCarg2(boolean sand_CargoLCarg2) {
        this.sand_CargoLCarg2 = sand_CargoLCarg2;
    }

    public boolean isSand_CargoLCarg3() {
        return sand_CargoLCarg3;
    }

    public void setSand_CargoLCarg3(boolean sand_CargoLCarg3) {
        this.sand_CargoLCarg3 = sand_CargoLCarg3;
    }

    public boolean isSand_CargoRCarg1() {
        return sand_CargoRCarg1;
    }

    public void setSand_CargoRCarg1(boolean sand_CargoRCarg1) {
        this.sand_CargoRCarg1 = sand_CargoRCarg1;
    }

    public boolean isSand_CargoRCarg2() {
        return sand_CargoRCarg2;
    }

    public void setSand_CargoRCarg2(boolean sand_CargoRCarg2) {
        this.sand_CargoRCarg2 = sand_CargoRCarg2;
    }

    public boolean isSand_CargoRCarg3() {
        return sand_CargoRCarg3;
    }

    public void setSand_CargoRCarg3(boolean sand_CargoRCarg3) {
        this.sand_CargoRCarg3 = sand_CargoRCarg3;
    }

    public boolean isSand_CargoEndLPan1() {
        return sand_CargoEndLPan1;
    }

    public void setSand_CargoEndLPan1(boolean sand_CargoEndLPan1) {
        this.sand_CargoEndLPan1 = sand_CargoEndLPan1;
    }

    public boolean isSand_CargoEndLCarg1() {
        return sand_CargoEndLCarg1;
    }

    public void setSand_CargoEndLCarg1(boolean sand_CargoEndLCarg1) {
        this.sand_CargoEndLCarg1 = sand_CargoEndLCarg1;
    }

    public boolean isSand_CargoEndRPan1() {
        return sand_CargoEndRPan1;
    }

    public void setSand_CargoEndRPan1(boolean sand_CargoEndRPan1) {
        this.sand_CargoEndRPan1 = sand_CargoEndRPan1;
    }

    public boolean isSand_CargoEndRCarg1() {
        return sand_CargoEndRCarg1;
    }

    public void setSand_CargoEndRCarg1(boolean sand_CargoEndRCarg1) {
        this.sand_CargoEndRCarg1 = sand_CargoEndRCarg1;
    }

    public boolean isSand_RghtRocket_LPan1() {
        return sand_RghtRocket_LPan1;
    }

    public void setSand_RghtRocket_LPan1(boolean sand_RghtRocket_LPan1) {
        this.sand_RghtRocket_LPan1 = sand_RghtRocket_LPan1;
    }

    public boolean isSand_RghtRocket_LPan2() {
        return sand_RghtRocket_LPan2;
    }

    public void setSand_RghtRocket_LPan2(boolean sand_RghtRocket_LPan2) {
        this.sand_RghtRocket_LPan2 = sand_RghtRocket_LPan2;
    }

    public boolean isSand_RghtRocket_LPan3() {
        return sand_RghtRocket_LPan3;
    }

    public void setSand_RghtRocket_LPan3(boolean sand_RghtRocket_LPan3) {
        this.sand_RghtRocket_LPan3 = sand_RghtRocket_LPan3;
    }

    public boolean isSand_RghtRocket_RPan1() {
        return sand_RghtRocket_RPan1;
    }

    public void setSand_RghtRocket_RPan1(boolean sand_RghtRocket_RPan1) {
        this.sand_RghtRocket_RPan1 = sand_RghtRocket_RPan1;
    }

    public boolean isSand_RghtRocket_RPan2() {
        return sand_RghtRocket_RPan2;
    }

    public void setSand_RghtRocket_RPan2(boolean sand_RghtRocket_RPan2) {
        this.sand_RghtRocket_RPan2 = sand_RghtRocket_RPan2;
    }

    public boolean isSand_RghtRocket_RPan3() {
        return sand_RghtRocket_RPan3;
    }

    public void setSand_RghtRocket_RPan3(boolean sand_RghtRocket_RPan3) {
        this.sand_RghtRocket_RPan3 = sand_RghtRocket_RPan3;
    }

    public boolean isSand_RghtRocket_LCarg1() {
        return sand_RghtRocket_LCarg1;
    }

    public void setSand_RghtRocket_LCarg1(boolean sand_RghtRocket_LCarg1) {
        this.sand_RghtRocket_LCarg1 = sand_RghtRocket_LCarg1;
    }

    public boolean isSand_RghtRocket_LCarg2() {
        return sand_RghtRocket_LCarg2;
    }

    public void setSand_RghtRocket_LCarg2(boolean sand_RghtRocket_LCarg2) {
        this.sand_RghtRocket_LCarg2 = sand_RghtRocket_LCarg2;
    }

    public boolean isSand_RghtRocket_LCarg3() {
        return sand_RghtRocket_LCarg3;
    }

    public void setSand_RghtRocket_LCarg3(boolean sand_RghtRocket_LCarg3) {
        this.sand_RghtRocket_LCarg3 = sand_RghtRocket_LCarg3;
    }

    public boolean isSand_RghtRocket_RCarg1() {
        return sand_RghtRocket_RCarg1;
    }

    public void setSand_RghtRocket_RCarg1(boolean sand_RghtRocket_RCarg1) {
        this.sand_RghtRocket_RCarg1 = sand_RghtRocket_RCarg1;
    }

    public boolean isSand_RghtRocket_RCarg2() {
        return sand_RghtRocket_RCarg2;
    }

    public void setSand_RghtRocket_RCarg2(boolean sand_RghtRocket_RCarg2) {
        this.sand_RghtRocket_RCarg2 = sand_RghtRocket_RCarg2;
    }

    public boolean isSand_RghtRocket_RCarg3() {
        return sand_RghtRocket_RCarg3;
    }

    public void setSand_RghtRocket_RCarg3(boolean sand_RghtRocket_RCarg3) {
        this.sand_RghtRocket_RCarg3 = sand_RghtRocket_RCarg3;
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

    public boolean isTele_CargoLPan1() {
        return tele_CargoLPan1;
    }

    public void setTele_CargoLPan1(boolean tele_CargoLPan1) {
        this.tele_CargoLPan1 = tele_CargoLPan1;
    }

    public boolean isTele_CargoLPan2() {
        return tele_CargoLPan2;
    }

    public void setTele_CargoLPan2(boolean tele_CargoLPan2) {
        this.tele_CargoLPan2 = tele_CargoLPan2;
    }

    public boolean isTele_CargoLPan3() {
        return tele_CargoLPan3;
    }

    public void setTele_CargoLPan3(boolean tele_CargoLPan3) {
        this.tele_CargoLPan3 = tele_CargoLPan3;
    }

    public boolean isTele_CargoRPan1() {
        return tele_CargoRPan1;
    }

    public void setTele_CargoRPan1(boolean tele_CargoRPan1) {
        this.tele_CargoRPan1 = tele_CargoRPan1;
    }

    public boolean isTele_CargoRPan2() {
        return tele_CargoRPan2;
    }

    public void setTele_CargoRPan2(boolean tele_CargoRPan2) {
        this.tele_CargoRPan2 = tele_CargoRPan2;
    }

    public boolean isTele_CargoRPan3() {
        return tele_CargoRPan3;
    }

    public void setTele_CargoRPan3(boolean tele_CargoRPan3) {
        this.tele_CargoRPan3 = tele_CargoRPan3;
    }

    public boolean isTele_CargoLCarg1() {
        return tele_CargoLCarg1;
    }

    public void setTele_CargoLCarg1(boolean tele_CargoLCarg1) {
        this.tele_CargoLCarg1 = tele_CargoLCarg1;
    }

    public boolean isTele_CargoLCarg2() {
        return tele_CargoLCarg2;
    }

    public void setTele_CargoLCarg2(boolean tele_CargoLCarg2) {
        this.tele_CargoLCarg2 = tele_CargoLCarg2;
    }

    public boolean isTele_CargoLCarg3() {
        return tele_CargoLCarg3;
    }

    public void setTele_CargoLCarg3(boolean tele_CargoLCarg3) {
        this.tele_CargoLCarg3 = tele_CargoLCarg3;
    }

    public boolean isTele_CargoRCarg1() {
        return tele_CargoRCarg1;
    }

    public void setTele_CargoRCarg1(boolean tele_CargoRCarg1) {
        this.tele_CargoRCarg1 = tele_CargoRCarg1;
    }

    public boolean isTele_CargoRCarg2() {
        return tele_CargoRCarg2;
    }

    public void setTele_CargoRCarg2(boolean tele_CargoRCarg2) {
        this.tele_CargoRCarg2 = tele_CargoRCarg2;
    }

    public boolean isTele_CargoRCarg3() {
        return tele_CargoRCarg3;
    }

    public void setTele_CargoRCarg3(boolean tele_CargoRCarg3) {
        this.tele_CargoRCarg3 = tele_CargoRCarg3;
    }

    public boolean isTele_CargoEndLPan1() {
        return tele_CargoEndLPan1;
    }

    public void setTele_CargoEndLPan1(boolean tele_CargoEndLPan1) {
        this.tele_CargoEndLPan1 = tele_CargoEndLPan1;
    }

    public boolean isTele_CargoEndLCarg1() {
        return tele_CargoEndLCarg1;
    }

    public void setTele_CargoEndLCarg1(boolean tele_CargoEndLCarg1) {
        this.tele_CargoEndLCarg1 = tele_CargoEndLCarg1;
    }

    public boolean isTele_CargoEndRPan1() {
        return tele_CargoEndRPan1;
    }

    public void setTele_CargoEndRPan1(boolean tele_CargoEndRPan1) {
        this.tele_CargoEndRPan1 = tele_CargoEndRPan1;
    }

    public boolean isTele_CargoEndRCarg1() {
        return tele_CargoEndRCarg1;
    }

    public void setTele_CargoEndRCarg1(boolean tele_CargoEndRCarg1) {
        this.tele_CargoEndRCarg1 = tele_CargoEndRCarg1;
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


//   GLF 1/22/19
// End of Getters/Setters

}