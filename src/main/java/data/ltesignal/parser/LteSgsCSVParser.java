package data.ltesignal.parser;


import data.CSVParser;
import data.ltesignal.LteSGs;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.math.NumberUtils.toInt;
import static org.apache.commons.lang3.math.NumberUtils.toLong;

public class LteSgsCSVParser extends CSVParser<LteSGs> {

    @Override
    public int getTotalFields() {
        return 33;
    }

    @Override
    public int getRequiredFields() {
        return 23;
    }

    @Override
    public LteSGs doParse(List<String> cs) {

        LteSGs sgs = new LteSGs();
        sgs.setLength(toInt(cs.get(0)));
        sgs.setCity(trim(cs.get(1)));
        sgs.setInterFace(toInt(cs.get(2)));
        sgs.setXdrId(trim(cs.get(3)));
        sgs.setRat(toInt(cs.get(4), 0));
        sgs.setImsi(extractImsi(cs.get(5)));
        sgs.setImei(trim(cs.get(6)));
        sgs.setMsisdn(extractImsi(cs.get(7)));
        sgs.setProcedureType(toInt(cs.get(8), 0));
        sgs.setStartTime(toLong(cs.get(9), 0));
        sgs.setEndTime(toLong(cs.get(10), 0));
        sgs.setProcedureStatus(toInt(cs.get(11), 0)); // xdr字段为空默认为成功
        sgs.setSgsCause(toInt(cs.get(12)));
        sgs.setRejectCause(toInt(cs.get(13)));
        sgs.setCpCause(toInt(cs.get(14)));
        sgs.setRpCause(toInt(cs.get(15)));
        sgs.setMmeIpAdd(trim(cs.get(18)));
        sgs.setMscServerIpAdd(trim(cs.get(19)));
        sgs.setServiceIndicator(toInt(cs.get(22)));

        return sgs;
    }

}
