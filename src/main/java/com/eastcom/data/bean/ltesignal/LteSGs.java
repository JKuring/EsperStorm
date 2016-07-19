package com.eastcom.data.bean.ltesignal;


import com.eastcom.data.bean.UserCommon;

public class LteSGs implements UserCommon {

    /**
     * 1 Length
     */
    private int length;

    /**
     * 2 City
     */
    private String city;

    /**
     * 3 Interface
     */
    private int interFace;

    /**
     * 4 XDR ID
     */
    private String xdrId;

    /**
     * 05 RAT
     */
    private int rat;

    /**
     * 06 IMSI
     */
    private String imsi;

    /**
     * 7 IMEI
     */
    private String imei;

    /**
     * 8 MSISDN (手机号)
     */
    private String msisdn;

    /**
     * 09 Procedure Type
     */
    private int procedureType;

    /**
     * 10 Procedure Start Time
     */
    private long startTime;

    /**
     * 11 Procedure End Time
     */
    private long endTime;

    /**
     * 12 Procedure Status
     */
    private int procedureStatus;

    /**
     * 13 Sgs cause
     */
    private int sgsCause;

    /**
     * 14 Reject cause
     */
    private int rejectCause;

    /**
     * 15 CP Cause
     */
    private int cpCause;

    /**
     * 16 RP Cause
     */
    private int rpCause;

    /**
     * 19 MME IP Add
     */
    private String mmeIpAdd;

    /**
     * 20 MSC Server IP Add
     */
    private String mscServerIpAdd;

    /**
     * 23 Service Indicator
     */
    private int serviceIndicator;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getInterFace() {
        return interFace;
    }

    public void setInterFace(int interFace) {
        this.interFace = interFace;
    }

    public String getXdrId() {
        return xdrId;
    }

    public void setXdrId(String xdrId) {
        this.xdrId = xdrId;
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

    public int getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(int procedureType) {
        this.procedureType = procedureType;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(int procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

    public int getSgsCause() {
        return sgsCause;
    }

    public void setSgsCause(int sgsCause) {
        this.sgsCause = sgsCause;
    }

    public int getRejectCause() {
        return rejectCause;
    }

    public void setRejectCause(int rejectCause) {
        this.rejectCause = rejectCause;
    }

    public int getCpCause() {
        return cpCause;
    }

    public void setCpCause(int cpCause) {
        this.cpCause = cpCause;
    }

    public int getRpCause() {
        return rpCause;
    }

    public void setRpCause(int rpCause) {
        this.rpCause = rpCause;
    }

    public String getMmeIpAdd() {
        return mmeIpAdd;
    }

    public void setMmeIpAdd(String mmeIpAdd) {
        this.mmeIpAdd = mmeIpAdd;
    }

    public String getMscServerIpAdd() {
        return mscServerIpAdd;
    }

    public void setMscServerIpAdd(String mscServerIpAdd) {
        this.mscServerIpAdd = mscServerIpAdd;
    }

    public int getServiceIndicator() {
        return serviceIndicator;
    }

    public void setServiceIndicator(int serviceIndicator) {
        this.serviceIndicator = serviceIndicator;
    }

}
