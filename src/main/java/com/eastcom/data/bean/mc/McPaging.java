package com.eastcom.data.bean.mc;


import com.eastcom.data.bean.UserCommon;

public class McPaging implements UserCommon {

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
     * 12 callingimsi
     *
     */
    private String callingImsi;

    /*
     * 13 calledimsi
     *
     */
    private String calledImsi;

    /*
     * 18 pagingresptype
     *
     */
    private int pagingResptype;

    /*
     * 19 rspdur
     *
     */
    private int rspdur;

    /*
     * 20 xdrtype
     *
     */
    private int xdrtype;

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

    public String getCallingImsi() {
        return callingImsi;
    }

    public void setCallingImsi(String callingImsi) {
        this.callingImsi = callingImsi;
    }

    public String getCalledImsi() {
        return calledImsi;
    }

    public void setCalledImsi(String calledImsi) {
        this.calledImsi = calledImsi;
    }

    public int getPagingResptype() {
        return pagingResptype;
    }

    public void setPagingResptype(int pagingResptype) {
        this.pagingResptype = pagingResptype;
    }

    public int getRspdur() {
        return rspdur;
    }

    public void setRspdur(int rspdur) {
        this.rspdur = rspdur;
    }

    public int getXdrtype() {
        return xdrtype;
    }

    public void setXdrtype(int xdrtype) {
        this.xdrtype = xdrtype;
    }

    @Override
    public String getImsi() {
        if (eventId == 1) {
            return callingImsi;
        } else if (eventId == 3) {
            return calledImsi;
        }
        return callingImsi;
    }

}
