package data.mc.parser;


import data.CSVParser;
import data.mc.McPaging;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class McPagingParser extends CSVParser<McPaging> {

    @Override
    public int getRequiredFields() {
        return 25;
    }

    @Override
    public int getTotalFields() {
        return 25;
    }

    @Override
    public McPaging doParse(List<String> cs) {
        McPaging mc = new McPaging();
        mc.setStartTime(extractTime(cs.get(0)));
        mc.setEndTime(extractTime(cs.get(1)));
        mc.setEventId(toInt(cs.get(3)));
        mc.setCallingImsi(trim(cs.get(11)));
        mc.setCalledImsi(trim(cs.get(12)));
        mc.setPagingResptype(toInt(cs.get(17)));
        mc.setRspdur(toInt(cs.get(18)));
        mc.setXdrtype(toInt(cs.get(19)));

        return mc;
    }

}
