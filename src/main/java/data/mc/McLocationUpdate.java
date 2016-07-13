package data.mc;


import data.UserCommon;

/**
 * 位置更新事件LocationUpdate_Event详单
 *
 * @author louyj
 */
public class McLocationUpdate implements UserCommon {

    /*
     * 01 btime
     */
    private long startTime;

    /*
     * 02 etime
     */
    private long endTime;

    /*
     * 08 olac
     *
     */
    private int olac;

    /*
     * 09 oci
     *
     */
    private int oci;

    /*
     * 10 dlac
     */
    private int dlac;

    /*
     * 11 dci
     */
    private int dci;

    /*
     * 13 callingimsi
     *
     */
    private String imsi;

    /*
     * 21 Result
     *
     */
    private int result;

    /*
     * 23 eventcause
     *
     */
    private int eventCause;

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

    public int getOlac() {
        return olac;
    }

    public void setOlac(int olac) {
        this.olac = olac;
    }

    public int getOci() {
        return oci;
    }

    public void setOci(int oci) {
        this.oci = oci;
    }

    public int getDlac() {
        return dlac;
    }

    public void setDlac(int dlac) {
        this.dlac = dlac;
    }

    public int getDci() {
        return dci;
    }

    public void setDci(int dci) {
        this.dci = dci;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getEventCause() {
        return eventCause;
    }

    public void setEventCause(int eventCause) {
        this.eventCause = eventCause;
    }

}
