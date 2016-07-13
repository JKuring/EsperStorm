package data.mc.parser;


import data.CSVParser;
import data.mc.McLocationUpdate;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class McLocationUpdateParser extends CSVParser<McLocationUpdate> {

    @Override
    public int getRequiredFields() {
        return 22;
    }

    @Override
    public int getTotalFields() {
        return 22;
    }

    /**
     * 抽取csvArr赋值给对象属性
     */
    @Override
    public McLocationUpdate doParse(List<String> csvArr) {

        McLocationUpdate mcLocationUpdateEvent = new McLocationUpdate();
        mcLocationUpdateEvent.setStartTime(extractTime(csvArr.get(0)));
        mcLocationUpdateEvent.setEndTime(extractTime(csvArr.get(1)));
        mcLocationUpdateEvent.setOlac(toInt(csvArr.get(7)));
        mcLocationUpdateEvent.setOci(toInt(csvArr.get(8)));
        mcLocationUpdateEvent.setDlac(toInt(csvArr.get(9)));
        mcLocationUpdateEvent.setDci(toInt(csvArr.get(10)));
        mcLocationUpdateEvent.setImsi(trim(csvArr.get(12)));
        mcLocationUpdateEvent.setResult(toInt(csvArr.get(20)));
        mcLocationUpdateEvent.setEventCause(toInt(csvArr.get(22)));

        return mcLocationUpdateEvent;

    }

}
