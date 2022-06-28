package eduard.zaripov.innocamp2022.model;


import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;


public class Thing implements Serializable {
    private String id;
    private String type;
    private boolean isWatering;
    private boolean isWorking;
    private Long timeStamp;
    private Double hwVer;
    private Double swVer;
    private Double contractVer;
    private Double lat0;
    private Double lon0;
    private Double lat1;
    private Double lon1;

    public Long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public Double getHwVer() {
        return hwVer;
    }
    public void setHwVer(Double hwVer) {
        this.hwVer = hwVer;
    }
    public Double getSwVer() {
        return swVer;
    }
    public void setSwVer(Double swVer) {
        this.swVer = swVer;
    }
    public Double getContractVer() {
        return contractVer;
    }
    public void setContractVer(Double contractVer) {
        this.contractVer = contractVer;
    }
    public Double getLat0() {
        return lat0;
    }
    public void setLat0(Double lat0) {
        this.lat0 = lat0;
    }
    public Double getLon0() {
        return lon0;
    }
    public void setLon0(Double lon0) {
        this.lon0 = lon0;
    }
    public Double getLat1() {
        return lat1;
    }
    public void setLat1(Double lat1) {
        this.lat1 = lat1;
    }
    public Double getLon1() {
        return lon1;
    }
    public void setLon1(Double lon1) {
        this.lon1 = lon1;
    }
    public boolean getWatering() {
        return isWatering;
    }
    public boolean getWorking() {
        return isWorking;
    }


    public Thing(String id, String type, boolean isWatering, boolean isWorking, Long timeStamp, Double hwVer, Double swVer, Double contractVer,  Double lat0,  Double lon0,  Double lat1,  Double lon1) {
        this.id = id;
        this.type = type;
        this.isWatering = isWatering;
        this.isWorking = isWorking;
        this.timeStamp = timeStamp;
        this.hwVer = hwVer;
        this.swVer = swVer;
        this.contractVer = contractVer;
        this.lat0 = lat0;
        this.lon0 = lon0;
        this.lat1 = lat1;
        this.lon1 = lon1;
    }

    @Override
    public String toString() {
        return id + " " + type + " " + isWatering + " " + isWorking;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isWatering() {
        return isWatering;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWatering(boolean watering) {
        isWatering = watering;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
    public void setter(Thing thingcon, ArrayList<Thing> things, int i) {
        things.get(i).setId(thingcon.getId());
        things.get(i).setType(thingcon.getType());
        things.get(i).setWatering(thingcon.isWatering());
        things.get(i).setWorking(thingcon.isWorking());
        things.get(i).setTimeStamp(thingcon.getTimeStamp());
        things.get(i).setHwVer(thingcon.getHwVer());
        things.get(i).setSwVer(thingcon.getSwVer());
        things.get(i).setContractVer(thingcon.getContractVer());
        things.get(i).setLat0(thingcon.getLat0());
        things.get(i).setLon0(thingcon.getLon0());
        things.get(i).setLat1(thingcon.getLat1());
        things.get(i).setLon1(thingcon.getLon1());
    }
}
