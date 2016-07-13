package data.ltesignal.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import data.ltesignal.LteSGs;

public class LteSgsSerializer extends Serializer<LteSGs> {

    public LteSgsSerializer() {
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, LteSGs lteSgs) {
        output.writeInt(lteSgs.getLength(), true);
        output.writeString(lteSgs.getCity());
        output.writeInt(lteSgs.getInterFace(), true);
        output.writeString(lteSgs.getXdrId());
        output.writeInt(lteSgs.getRat(), true);
        output.writeString(lteSgs.getImsi());
        output.writeString(lteSgs.getImei());
        output.writeString(lteSgs.getMsisdn());
        output.writeInt(lteSgs.getProcedureType(), true);
        output.writeLong(lteSgs.getStartTime(), true);
        output.writeLong(lteSgs.getEndTime(), true);
        output.writeInt(lteSgs.getProcedureStatus(), true);
        output.writeInt(lteSgs.getSgsCause(), true);
        output.writeInt(lteSgs.getRejectCause(), true);
        output.writeInt(lteSgs.getCpCause(), true);
        output.writeInt(lteSgs.getRpCause(), true);
        output.writeString(lteSgs.getMmeIpAdd());
        output.writeString(lteSgs.getMscServerIpAdd());
        output.writeInt(lteSgs.getServiceIndicator(), true);
    }

    @Override
    public LteSGs read(Kryo kryo, Input input, Class<LteSGs> type) {
        LteSGs lteSgs = new LteSGs();
        lteSgs.setLength(input.readInt(true));
        lteSgs.setCity(input.readString());
        lteSgs.setInterFace(input.readInt(true));
        lteSgs.setXdrId(input.readString());
        lteSgs.setRat(input.readInt(true));
        lteSgs.setImsi(input.readString());
        lteSgs.setImei(input.readString());
        lteSgs.setMsisdn(input.readString());
        lteSgs.setProcedureType(input.readInt(true));
        lteSgs.setStartTime(input.readLong(true));
        lteSgs.setEndTime(input.readLong(true));
        lteSgs.setProcedureStatus(input.readInt(true));
        lteSgs.setSgsCause(input.readInt(true));
        lteSgs.setRejectCause(input.readInt(true));
        lteSgs.setCpCause(input.readInt(true));
        lteSgs.setRpCause(input.readInt(true));
        lteSgs.setMmeIpAdd(input.readString());
        lteSgs.setMscServerIpAdd(input.readString());
        lteSgs.setServiceIndicator(input.readInt(true));
        return lteSgs;
    }

}
