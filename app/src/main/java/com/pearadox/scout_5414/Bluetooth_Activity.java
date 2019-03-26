package com.pearadox.scout_5414;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import static android.util.Log.w;

public class Bluetooth_Activity extends AppCompatActivity {
    String TAG = "Bluetooth_Activity";          // This CLASS name
    String param1 = "";  String param2 = "";
    private String deviceId;                    // Android Device ID
    TextView txt_Device, txt_bt;
    ListView listView_bonded;
    public int devSelected = -1;
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 0;
    ArrayAdapter<String> adapter_dev;
    String MY_UUID = "";
    p_Firebase.devicesObj dev_inst = new p_Firebase.devicesObj();


    // ===========================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        Log.d(TAG, "@@@@@ Bluetooth_Activity  @@@@@");
        Bundle bundle = this.getIntent().getExtras();
        param1 = bundle.getString("dev");
        param2 = bundle.getString("andid");
        Log.w(TAG, param1 + " " + param2);      // ** DEBUG **
        deviceId = param2;

        txt_Device = (TextView) findViewById(R.id.txt_Device);
        txt_Device.setText(param1);
        txt_bt = (TextView) findViewById(R.id.txt_bt);
        listView_bonded = (ListView) findViewById(R.id.listView_bonded);
        Pearadox.dev_List.clear();

        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mReceiver, filter);

        final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast toast = Toast.makeText(getBaseContext(), "Bluetooth device not supported", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                txt_bt.setText("OFF");
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                txt_bt.setText("ON");
            }
            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            if (pairedDevices.size() > 0) {
                // There are paired devices. Get the name and address of each paired device.
                ArrayList list = new ArrayList();
                for (BluetoothDevice device : pairedDevices) {
                    list.add(device.getName());
                    String deviceName = device.getName();
                    String deviceHardwareAddress = device.getAddress(); // MAC address
                    Log.w(TAG, ">>> Device: " + deviceName + "  Addr: " + deviceHardwareAddress);
                    if (deviceId == "Scout Master") {
                        MY_UUID = deviceName;
                        dev_inst.setDev_name(deviceName);
                        dev_inst.setDev_id("SM");
                        dev_inst.setBtUUID(deviceHardwareAddress);
                        Pearadox.dev_List.add(dev_inst);
                    } else {        // all others
                        switch (deviceId) {
                            case "Red-1":
                                dev_inst.setDev_id("R1");
                                dev_inst.setDev_name(deviceName);
                                dev_inst.setBtUUID(deviceHardwareAddress);
                                Pearadox.dev_List.add(dev_inst);
                                break;
                            case "Red-2":
                                dev_inst.setDev_id("R2");
                                dev_inst.setDev_name(deviceName);
                                dev_inst.setBtUUID(deviceHardwareAddress);
                                Pearadox.dev_List.add(dev_inst);
                                break;
                            case "Red-3":
                                dev_inst.setDev_id("R3");
                                dev_inst.setDev_name(deviceName);
                                dev_inst.setBtUUID(deviceHardwareAddress);
                                Pearadox.dev_List.add(dev_inst);
                                break;
                            case "Blue-1":
                                dev_inst.setDev_id("B1");
                                dev_inst.setDev_name(deviceName);
                                dev_inst.setBtUUID(deviceHardwareAddress);
                                Pearadox.dev_List.add(dev_inst);
                                break;
                            case "Blue-2":
                                dev_inst.setDev_id("B2");
                                dev_inst.setDev_name(deviceName);
                                dev_inst.setBtUUID(deviceHardwareAddress);
                                Pearadox.dev_List.add(dev_inst);
                                break;
                            case "Blue-3":
                                dev_inst.setDev_id("B3");
                                dev_inst.setDev_name(deviceName);
                                dev_inst.setBtUUID(deviceHardwareAddress);
                                Pearadox.dev_List.add(dev_inst);
                                break;
                            default:                //
                                Log.w(TAG, "DEV not a Scout");
                                break;
                        }
                    }
                } //end FOR
                Log.w(TAG, "Device list = " + Pearadox.dev_List.size());      // ** DEBUG **

                final ArrayAdapter adapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
                listView_bonded.setAdapter(adapter);
            }
        }

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        listView_bonded.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View view, int pos, long id) {
                Log.w(TAG, "*** lstView_Teams ***   Item Selected: " + pos);
                devSelected = pos;
                listView_bonded.setSelector(android.R.color.holo_blue_light);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing.
            }
        });

    }


    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            Log.d(TAG, "*** BroadcastReceiver  ***  " + action);
            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF:
                        txt_bt.setText("OFF");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        txt_bt.setText("OFF");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        txt_bt.setText("ON");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        txt_bt.setText("ON");
                        break;
                }
            }
        }
    };




//###################################################################
//###################################################################
//###################################################################
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "<<<<<  onStart  >>>>>");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "*** onResume ***");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Unregister broadcast listeners
        unregisterReceiver(mReceiver);
    }

}
