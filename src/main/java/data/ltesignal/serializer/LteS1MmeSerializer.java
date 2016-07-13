package data.ltesignal.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import data.ltesignal.LteS1Mme;

public class LteS1MmeSerializer extends Serializer<LteS1Mme> {

    public LteS1MmeSerializer() {
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, LteS1Mme object) {
        output.writeInt(object.getLength(), true);
        output.writeString(object.getCity());
        output.writeInt(object.getInterFace(), true);
        output.writeString(object.getXdrId());
        output.writeInt(object.getRat(), true);
        output.writeString(object.getImsi());
        output.writeString(object.getImei());
        output.writeString(object.getMsisdn());
        output.writeInt(object.getProcedureType(), true);
        output.writeLong(object.getStartTime(), true);
        output.writeLong(object.getEndTime(), true);
        output.writeInt(object.getProcedureStatus(), true);
        output.writeInt(object.getRequestCause(), true);
        output.writeInt(object.getFailCauseCode(), true);
        output.writeString(object.getMmeIpAdd());
        output.writeString(object.getEnbIpAdd());
        output.writeInt(object.getTac(), true);
        output.writeInt(object.getCellId(), true);
        output.writeInt(object.getBearer1Status(), true);
        output.writeInt(object.getBearer1RequestCause(), true);
        output.writeInt(object.getBearer1FailureCause(), true);
        output.writeInt(object.getCsfbResponse(), true);
    }

    @Override
    public LteS1Mme read(Kryo kryo, Input input, Class<LteS1Mme> type) {
        LteS1Mme object = new LteS1Mme();
        object.setLength(input.readInt(true));
        object.setCity(input.readString());
        object.setInterFace(input.readInt(true));
        object.setXdrId(input.readString());
        object.setRat(input.readInt(true));
        object.setImsi(input.readString());
        object.setImei(input.readString());
        object.setMsisdn(input.readString());
        object.setProcedureType(input.readInt(true));
        object.setStartTime(input.readLong(true));
        object.setEndTime(input.readLong(true));
        object.setProcedureStatus(input.readInt(true));
        object.setRequestCause(input.readInt(true));
        object.setFailCauseCode(input.readInt(true));
        object.setMmeIpAdd(input.readString());
        object.setEnbIpAdd(input.readString());
        object.setTac(input.readInt(true));
        object.setCellId(input.readInt(true));
        object.setBearer1Status(input.readInt(true));
        object.setBearer1RequestCause(input.readInt(true));
        object.setBearer1FailureCause(input.readInt(true));
        object.setCsfbResponse(input.readInt(true));
        return object;
    }

}
