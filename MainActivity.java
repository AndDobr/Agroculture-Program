package eduard.zaripov.innocamp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import eduard.zaripov.innocamp2022.app.service.MqttHelper;
import eduard.zaripov.innocamp2022.model.Thing;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        TextView idView =  findViewById(R.id.idView);
        ArrayList<Thing> things = new ArrayList<>();
        ThingAdapter arrayAdapter = new ThingAdapter(getApplicationContext(), R.layout.list_item, things);
        listView.setAdapter(arrayAdapter);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MqttHelper.connect(getApplicationContext(), () -> {
                String content = MqttHelper.getContent();
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    String id = jsonObject.getString("thingId");
                    String type = jsonObject.getString("type");
                    Long timeStamp = jsonObject.getLong("timeStamp");
                    Double hwVer = jsonObject.getDouble("hwVer");
                    Double swVer = jsonObject.getDouble("swVer");
                    Double contractVer = jsonObject.getDouble("contractVer");
                    Double lat0 = jsonObject.getJSONObject("current").getJSONObject("geo0").getDouble("lat");
                    Double lon0 = jsonObject.getJSONObject("current").getJSONObject("geo0").getDouble("lon");
                    Double lat1 = jsonObject.getJSONObject("current").getJSONObject("geo1").getDouble("lat");
                    Double lon1 = jsonObject.getJSONObject("current").getJSONObject("geo1").getDouble("lon");
                    boolean isWatering = jsonObject.getBoolean("isWatering");
                    boolean isWorking = jsonObject.getBoolean("isWorking");
                    Thing thingcon = new Thing(id, type, isWatering, isWorking, timeStamp, hwVer, swVer, contractVer, lat0, lon0, lat1, lon1);
                    boolean isAdded = false;
                    int  isAddednum = 0;
                    for (int i = 0; i < things.size(); i++) {
                        if (things.get(i).getId().equals(thingcon.getId())) {
                            isAdded = true;
                            isAddednum = i;
                        }
                    }
                    if (isAdded) {
                        things.get(isAddednum).setter(thingcon, things, isAddednum);
                    } else {
                        things.add(thingcon);
                    }
                    arrayAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                        Log.d("TAG", "JSON exception");
                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                {
                    Intent intent = new Intent(getApplicationContext(), DeviceActivity.class);
                    intent.putExtra("thing", things.get(position));
                    startActivity(intent);

                }
            });
        }
    });
        thread.start();
    }

}