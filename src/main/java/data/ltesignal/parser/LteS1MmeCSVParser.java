package data.ltesignal.parser;


import data.CSVParser;
import data.ltesignal.LteS1Mme;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.math.NumberUtils.toInt;
import static org.apache.commons.lang3.math.NumberUtils.toLong;

public class LteS1MmeCSVParser extends CSVParser<LteS1Mme> {

    @Override
    public int getTotalFields() {
        return 135;
    }

    @Override
    public int getRequiredFields() {
        return 134;
    }

    @Override
    public LteS1Mme doParse(List<String> csvArr) {

        LteS1Mme lteS1Mme = new LteS1Mme();
        lteS1Mme.setLength(toInt(csvArr.get(0)));
        lteS1Mme.setCity(trim(csvArr.get(1)));
        lteS1Mme.setInterFace(toInt(csvArr.get(2)));
        lteS1Mme.setXdrId(trim(csvArr.get(3)));
        lteS1Mme.setRat(toInt(csvArr.get(4), 0));
        lteS1Mme.setImsi(extractImsi(csvArr.get(5)));
        lteS1Mme.setImei(trim(csvArr.get(6)));
        lteS1Mme.setMsisdn(extractImsi(csvArr.get(7)));
        lteS1Mme.setProcedureType(toInt(csvArr.get(8), 0));
        lteS1Mme.setStartTime(toLong(csvArr.get(9), 0));
        lteS1Mme.setEndTime(toLong(csvArr.get(10), 0));
        lteS1Mme.setProcedureStatus(toInt(csvArr.get(11), 0)); // xdr字段为空默认为成功
        lteS1Mme.setRequestCause(toInt(csvArr.get(12)));
        lteS1Mme.setFailCauseCode(toInt(csvArr.get(13)));
        lteS1Mme.setMmeIpAdd(extractString(csvArr.get(28)));
        lteS1Mme.setEnbIpAdd(extractString(csvArr.get(29)));
        lteS1Mme.setTac(toInt(csvArr.get(32)));
        lteS1Mme.setCellId(toInt(csvArr.get(33)));
        lteS1Mme.setBearer1Status(toInt(csvArr.get(41)));
        lteS1Mme.setBearer1RequestCause(toInt(csvArr.get(42)));
        lteS1Mme.setBearer1FailureCause(toInt(csvArr.get(43)));
        lteS1Mme.setCsfbResponse(toInt(csvArr.get(133)));
        return lteS1Mme;
    }

}
