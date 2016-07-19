package com.eastcom.data.bean;

/**
 * 用户IMSI在时间段(StartTime,EndTime)的（Lac CellId）站点下使用某一网络rat
 */
public interface UserCommon {

    /**
     * 用户IMSI
     *
     * @return
     */
    public String getImsi();

    /**
     * Procedure Start Time
     *
     * @return
     */
    public long getStartTime();

    public long getEndTime();

}
