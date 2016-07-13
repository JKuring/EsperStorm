package data.mc.parser;


import data.CSVParser;
import data.mc.McCallEvent;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class McCallParser extends CSVParser<McCallEvent> {

    @Override
    public int getRequiredFields() {
        return 25;
    }

    @Override
    public int getTotalFields() {
        return 25;
    }

    @Override
    public McCallEvent doParse(List<String> csvArr) {
        McCallEvent mcCallEvent = new McCallEvent();
        mcCallEvent.setStartTime(extractTime(csvArr.get(0)));
        mcCallEvent.setEndTime(extractTime(csvArr.get(1)));
        mcCallEvent.setEventId(toInt(csvArr.get(3)));
        mcCallEvent.setLac(toInt(csvArr.get(9)));
        mcCallEvent.setCi(toInt(csvArr.get(10)));
        mcCallEvent.setResult(toInt(csvArr.get(17)));
        mcCallEvent.setCallingNum(trim(csvArr.get(20)));
        mcCallEvent.setCalledNum(trim(csvArr.get(21)));
        mcCallEvent.setCallingimsi(trim(csvArr.get(23)));
        mcCallEvent.setCalledimsi(trim(csvArr.get(24)));
        mcCallEvent.setCallingTmsi(trim(csvArr.get(28)));
        mcCallEvent.setCalledTmsi(trim(csvArr.get(29)));
        mcCallEvent.setEventCause(toInt(csvArr.get(36)));
        mcCallEvent.setEventResult(toInt(csvArr.get(38)));
        mcCallEvent.setAssgCause(toInt(csvArr.get(40)));
        mcCallEvent.setDisconCause(toInt(csvArr.get(41)));
        mcCallEvent.setClearCause(toInt(csvArr.get(42)));
        mcCallEvent.setRelCauseValue(toInt(csvArr.get(43)));
        mcCallEvent.setSetupResult(toInt(csvArr.get(45)));
        mcCallEvent.setCmreqOffset(toInt(csvArr.get(50)));
        mcCallEvent.setAuthreqOffset(toInt(csvArr.get(52)));
        mcCallEvent.setAssreqOffset(toInt(csvArr.get(58)));
        mcCallEvent.setSetupOffset(toInt(csvArr.get(60)));
        mcCallEvent.setCpgoffset(toInt(csvArr.get(61)));
        mcCallEvent.setCpgrspoffset(toInt(csvArr.get(62)));
        mcCallEvent.setConnOffset(toInt(csvArr.get(63)));
        mcCallEvent.setConnackoffset(toInt(csvArr.get(64)));
        mcCallEvent.setDisconnOffset(toInt(csvArr.get(66)));
        mcCallEvent.setAlertOffset(toInt(csvArr.get(69)));
        mcCallEvent.setRelOffset(toInt(csvArr.get(72)));
        mcCallEvent.setClearOffset(toInt(csvArr.get(75)));
        mcCallEvent.setRspdur(toInt(csvArr.get(80)));

        return mcCallEvent;

    }

}
