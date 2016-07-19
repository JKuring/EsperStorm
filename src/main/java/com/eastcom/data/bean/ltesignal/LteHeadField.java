package com.eastcom.data.bean.ltesignal;

/**
 * Created by linghang.kong on 2016/5/12.
 */
public class LteHeadField {
    /**
     * 01 Length
     */
    private int length;
    /**
     * 02 City
     */
    private int city;
    /**
     * 03 Interface
     */
    private int interFace;
    /**
     * 04 XDR ID
     */
    private String xdrID;
    /**
     * 05 Rat
     */
    private int rat;
    /**
     * 06 IMSI
     */
    private String imsi;
    /**
     * 07 IMEI
     */
    private String imei;
    /**
     * 08 MSSISDN
     */
    private String msisdn;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getInterFace() {
        return interFace;
    }

    public void setInterFace(int interFace) {
        this.interFace = interFace;
    }

    public String getXdrID() {
        return xdrID;
    }

    public void setXdrID(String xdrID) {
        this.xdrID = xdrID;
    }

    public int getRat() {
        return rat;
    }

    public void setRat(int rat) {
        this.rat = rat;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
