package eduard.zaripov.innocamp2022;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import eduard.zaripov.innocamp2022.model.Thing;

public class DeviceActivity extends Activity {
    TextView id;
    TextView type;
    TextView isWatering;
    TextView isWorking;
    TextView timeStamp;
    TextView hardware;
    TextView software;
    TextView contract;
    TextView lat0;
    TextView lon0;
    TextView lat1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        TextView id = findViewById(R.id.idView1);
        TextView type= findViewById(R.id.typeView1);
        TextView isWatering = findViewById(R.id.wateringView1);
        TextView isWorking = findViewById(R.id.workingView1);
        TextView timeStamp = findViewById(R.id.timeStampView1);
        TextView hardware = findViewById(R.id.hardwareView1);
        TextView software = findViewById(R.id.softwareView1);
        TextView contract = findViewById(R.id.contractView1);
        TextView lat0 = findViewById(R.id.lat0View1);
        TextView lon0 = findViewById(R.id.lon0View1);
        TextView lat1 = findViewById(R.id.lat1View1);
        TextView lon1 = findViewById(R.id.lon1View1);

        Thing thing = (Thing) getIntent().getSerializableExtra("thing");
        id.setText(thing.getId());
        type.setText(thing.getType());
        if (thing.getWatering() == false) {
            isWatering.setText("No");
        } else {
            isWatering.setText("Yes");
        }
        if (thing.getWorking() == false) {
            isWorking.setText("No");
        } else {
            isWorking.setText("Yes");
        }
        timeStamp.setText(Long.toString(thing.getTimeStamp()));
        hardware.setText(Double.toString(thing.getHwVer()));
        software.setText(thing.getId());
        contract.setText(Double.toString(thing.getContractVer()));
        lat0.setText(Double.toString(thing.getLat0()));
        lon0.setText(Double.toString(thing.getLon0()));
        lat1.setText(Double.toString(thing.getLat1()));
        lon1.setText(Double.toString(thing.getLon1()));
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
