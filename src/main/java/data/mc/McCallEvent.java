package data.mc;


import data.UserCommon;

/**
 * A/IU口呼叫事件VoiceCall_Event详单
 *
 * @author louyj
 */
public class McCallEvent implements UserCommon {

    /*
     * 01 btime
     */
    private long startTime;

    /*
     * 02 etime
     */
    private long endTime;

    /*
     * 04 eventid
     *
     */
    private int eventId;

    /*
     * 10 lac
     *
     */
    private int lac;

    /*
     * 11 ci
     *
     */
    private int ci;

    /*
     * 18 Result
     *
     */
    private int result;

    /*
     * 21 callingnum
     *
     */
    private String callingNum;

    /*
     * 22 callednum
     *
     */
    private String calledNum;

    /*
     * 24 callingimsi
     */
    private String callingimsi;

    /**
     * 25 calledimsi
     */
    private String calledimsi;

    /*
     * 29 callingtmsi
     *
     */
    private String callingTmsi;

    /*
     * 30 calledtmsi
     *
     */
    private String calledTmsi;

    /*
     * 37 eventcause
     *
     */
    private int eventCause;

    /*
     * 39 eventresult
     *
     */
    private int eventResult;

    /*
     * 41 assg_cause
     *
     */
    private int assgCause;

    /*
     * 42 discon_cause
     *
     */
    private int disconCause;

    /*
     * 43 clear_cause
     *
     */
    private int clearCause;

    /*
     * 44 relCauseValue
     *
     */
    private int relCauseValue;

    /*
     * 46 setupResult
     *
     */
    private int setupResult;

    /*
     * 51 cmreqoffset
     *
     */
    private int cmreqOffset;

    /*
     * 53 authreqoffset
     *
     */
    private int authreqOffset;

    /*
     * 59 assreqoffset
     *
     */
    private int assreqOffset;

    /*
     * 61 setupoffset
     *
     */
    private int setupOffset;

    /*
     * 62 cpgoffset
     *
     */
    private int cpgoffset;

    /*
     * 63 cpgrspoffset
     *
     */
    private int cpgrspoffset;

    /*
     * 64 connoffset
     *
    */
    private int connOffset;

    /*
     * 65 connackoffset
     *
     */
    private int connackoffset;
    /*
     * 67 disconnOffset
     *
     */
    private int disconnOffset;
    /*
     * 70 alertoffset
     *
     */
    private int alertOffset;

    /*
     * 73 reloffset
     *
     */
    private int relOffset;

    /*
     * 76 clearoffset
     *
     */
    private int clearOffset;

    /*
     81 rspdur
     */
    private int rspdur;

    public String getImsi() {
        if (eventId == 1) {
            return callingimsi;
        } else if (eventId == 3) {
            return calledimsi;
        }
        return callingimsi;
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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getLac() {
        return lac;
    }

    public void setLac(int lac) {
        this.lac = lac;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCallingNum() {
        return callingNum;
    }

    public void setCallingNum(String callingNum) {
        this.callingNum = callingNum;
    }

    public String getCalledNum() {
        return calledNum;
    }

    public void setCalledNum(String calledNum) {
        this.calledNum = calledNum;
    }

    public String getCallingimsi() {
        return callingimsi;
    }

    public void setCallingimsi(String callingimsi) {
        this.callingimsi = callingimsi;
    }

    public String getCalledimsi() {
        return calledimsi;
    }

    public void setCalledimsi(String calledimsi) {
        this.calledimsi = calledimsi;
    }

    public String getCallingTmsi() {
        return callingTmsi;
    }

    public void setCallingTmsi(String callingTmsi) {
        this.callingTmsi = callingTmsi;
    }

    public String getCalledTmsi() {
        return calledTmsi;
    }

    public void setCalledTmsi(String calledTmsi) {
        this.calledTmsi = calledTmsi;
    }

    public int getEventCause() {
        return eventCause;
    }

    public void setEventCause(int eventCause) {
        this.eventCause = eventCause;
    }

    public int getEventResult() {
        return eventResult;
    }

    public void setEventResult(int eventResult) {
        this.eventResult = eventResult;
    }

    public int getAssgCause() {
        return assgCause;
    }

    public void setAssgCause(int assgCause) {
        this.assgCause = assgCause;
    }

    public int getDisconCause() {
        return disconCause;
    }

    public void setDisconCause(int disconCause) {
        this.disconCause = disconCause;
    }

    public int getClearCause() {
        return clearCause;
    }

    public void setClearCause(int clearCause) {
        this.clearCause = clearCause;
    }

    public int getRelCauseValue() {
        return relCauseValue;
    }

    public void setRelCauseValue(int relCauseValue) {
        this.relCauseValue = relCauseValue;
    }

    public int getSetupResult() {
        return setupResult;
    }

    public void setSetupResult(int setupResult) {
        this.setupResult = setupResult;
    }

    public int getCmreqOffset() {
        return cmreqOffset;
    }

    public void setCmreqOffset(int cmreqOffset) {
        this.cmreqOffset = cmreqOffset;
    }

    public int getAuthreqOffset() {
        return authreqOffset;
    }

    public void setAuthreqOffset(int authreqOffset) {
        this.authreqOffset = authreqOffset;
    }

    public int getAssreqOffset() {
        return assreqOffset;
    }

    public void setAssreqOffset(int assreqOffset) {
        this.assreqOffset = assreqOffset;
    }

    public int getSetupOffset() {
        return setupOffset;
    }

    public void setSetupOffset(int setupOffset) {
        this.setupOffset = setupOffset;
    }

    public int getCpgoffset() {
        return cpgoffset;
    }

    public void setCpgoffset(int cpgoffset) {
        this.cpgoffset = cpgoffset;
    }

    public int getCpgrspoffset() {
        return cpgrspoffset;
    }

    public void setCpgrspoffset(int cpgrspoffset) {
        this.cpgrspoffset = cpgrspoffset;
    }

    public int getDisconnOffset() {
        return disconnOffset;
    }

    public void setDisconnOffset(int disconnOffset) {
        this.disconnOffset = disconnOffset;
    }

    public int getAlertOffset() {
        return alertOffset;
    }

    public void setAlertOffset(int alertOffset) {
        this.alertOffset = alertOffset;
    }

    public int getConnOffset() {
        return connOffset;
    }

    public void setConnOffset(int connOffset) {
        this.connOffset = connOffset;
    }

    public int getConnackoffset() {
        return connackoffset;
    }

    public void setConnackoffset(int connackoffset) {
        this.connackoffset = connackoffset;
    }

    public int getRelOffset() {
        return relOffset;
    }

    public void setRelOffset(int relOffset) {
        this.relOffset = relOffset;
    }

    public int getClearOffset() {
        return clearOffset;
    }

    public void setClearOffset(int clearOffset) {
        this.clearOffset = clearOffset;
    }


    public int getRspdur() {
        return rspdur;
    }

    public void setRspdur(int rspdur) {
        this.rspdur = rspdur;
    }
}
