package com.eastcom.data.bean.ltesignal;


import com.eastcom.data.bean.UserCommon;

public class LteS1Mme implements UserCommon {

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
     * 13 Request Cause
     */
    private int requestCause;

    /**
     * 14 FAIL_CAUSE_CODE
     */
    private int failCauseCode;

    /**
     * 29 MME IP Add
     */
    private String mmeIpAdd;

    /**
     * 30 eNB IP Add
     */
    private String enbIpAdd;

    /**
     * 33 TAC
     */
    private int tac;

    /**
     * 34 Cell ID
     */
    private int cellId;

    /**
     * 42 Bearer 1 Status
     */
    private int bearer1Status;

    /**
     * 43 Bearer 1 Request Cause
     */
    private int bearer1RequestCause;

    /**
     * 44 Bearer 1 Failure Cause
     */
    private int bearer1FailureCause;

    /**
     * 134 CSFB response
     */
    private int csfbResponse;

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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getBearer1Status() {
        return bearer1Status;
    }

    public void setBearer1Status(int bearer1Status) {
        this.bearer1Status = bearer1Status;
    }

    public int getBearer1RequestCause() {
        return bearer1RequestCause;
    }

    public void setBearer1RequestCause(int bearer1RequestCause) {
        this.bearer1RequestCause = bearer1RequestCause;
    }

    public int getBearer1FailureCause() {
        return bearer1FailureCause;
    }

    public void setBearer1FailureCause(int bearer1FailureCause) {
        this.bearer1FailureCause = bearer1FailureCause;
    }

    public int getCsfbResponse() {
        return csfbResponse;
    }

    public void setCsfbResponse(int csfbResponse) {
        this.csfbResponse = csfbResponse;
    }

    public int getTac() {
        return tac;
    }

    public void setTac(int tac) {
        this.tac = tac;
    }

    public String getEnbIpAdd() {
        return enbIpAdd;
    }

    public void setEnbIpAdd(String enbIpAdd) {
        this.enbIpAdd = enbIpAdd;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getRequestCause() {
        return requestCause;
    }

    public void setRequestCause(int requestCause) {
        this.requestCause = requestCause;
    }

    public int getFailCauseCode() {
        return failCauseCode;
    }

    public void setFailCauseCode(int failCauseCode) {
        this.failCauseCode = failCauseCode;
    }

    public String getMmeIpAdd() {
        return mmeIpAdd;
    }

    public void setMmeIpAdd(String mmeIpAdd) {
        this.mmeIpAdd = mmeIpAdd;
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

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public int getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(int procedureType) {
        this.procedureType = procedureType;
    }

    public int getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(int procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

}
