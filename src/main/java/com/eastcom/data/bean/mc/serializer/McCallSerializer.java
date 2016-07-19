package com.eastcom.data.bean.mc.serializer;


import com.eastcom.data.bean.mc.McCallEvent;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class McCallSerializer extends Serializer<McCallEvent> {

    public McCallSerializer() {
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, McCallEvent mcCallEvent) {
        output.writeLong(mcCallEvent.getStartTime(), true);
        output.writeLong(mcCallEvent.getEndTime(), true);
        output.writeInt(mcCallEvent.getEventId(), true);
        output.writeInt(mcCallEvent.getLac(), true);
        output.writeInt(mcCallEvent.getCi(), true);
        output.writeInt(mcCallEvent.getResult(), true);
        output.writeString(mcCallEvent.getCallingNum());
        output.writeString(mcCallEvent.getCalledNum());
        output.writeString(mcCallEvent.getCallingimsi());
        output.writeString(mcCallEvent.getCalledimsi());
        output.writeString(mcCallEvent.getCallingTmsi());
        output.writeString(mcCallEvent.getCalledTmsi());
        output.writeInt(mcCallEvent.getEventCause(), true);
        output.writeInt(mcCallEvent.getEventResult(), true);
        output.writeInt(mcCallEvent.getAssgCause(), true);
        output.writeInt(mcCallEvent.getDisconCause(), true);
        output.writeInt(mcCallEvent.getClearCause(), true);
        output.writeInt(mcCallEvent.getRelCauseValue(), true);
        output.writeInt(mcCallEvent.getSetupResult(), true);
        output.writeInt(mcCallEvent.getCmreqOffset(), true);
        output.writeInt(mcCallEvent.getAuthreqOffset(), true);
        output.writeInt(mcCallEvent.getAssreqOffset(), true);
        output.writeInt(mcCallEvent.getSetupOffset(), true);
        output.writeInt(mcCallEvent.getCpgoffset(), true);
        output.writeInt(mcCallEvent.getCpgrspoffset(), true);
        output.writeInt(mcCallEvent.getConnOffset(), true);
        output.writeInt(mcCallEvent.getConnackoffset(), true);
        output.writeInt(mcCallEvent.getDisconnOffset(), true);
        output.writeInt(mcCallEvent.getAlertOffset(), true);
        output.writeInt(mcCallEvent.getRelOffset(), true);
        output.writeInt(mcCallEvent.getClearOffset(), true);
        output.writeInt(mcCallEvent.getRspdur(), true);
    }

    @Override
    public McCallEvent read(Kryo kryo, Input input, Class<McCallEvent> type) {
        McCallEvent mcCallEvent = new McCallEvent();
        mcCallEvent.setStartTime(input.readLong(true));
        mcCallEvent.setEndTime(input.readLong(true));
        mcCallEvent.setEventId(input.readInt(true));
        mcCallEvent.setLac(input.readInt(true));
        mcCallEvent.setCi(input.readInt(true));
        mcCallEvent.setResult(input.readInt(true));
        mcCallEvent.setCallingNum(input.readString());
        mcCallEvent.setCalledNum(input.readString());
        mcCallEvent.setCallingimsi(input.readString());
        mcCallEvent.setCalledimsi(input.readString());
        mcCallEvent.setCallingTmsi(input.readString());
        mcCallEvent.setCalledTmsi(input.readString());
        mcCallEvent.setEventCause(input.readInt(true));
        mcCallEvent.setEventResult(input.readInt(true));
        mcCallEvent.setAssgCause(input.readInt(true));
        mcCallEvent.setDisconCause(input.readInt(true));
        mcCallEvent.setClearCause(input.readInt(true));
        mcCallEvent.setRelCauseValue(input.readInt(true));
        mcCallEvent.setSetupResult(input.readInt(true));
        mcCallEvent.setCmreqOffset(input.readInt(true));
        mcCallEvent.setAuthreqOffset(input.readInt(true));
        mcCallEvent.setAssreqOffset(input.readInt(true));
        mcCallEvent.setSetupOffset(input.readInt(true));
        mcCallEvent.setCpgoffset(input.readInt(true));
        mcCallEvent.setCpgrspoffset(input.readInt(true));
        mcCallEvent.setConnOffset(input.readInt(true));
        mcCallEvent.setConnackoffset(input.readInt(true));
        mcCallEvent.setDisconnOffset(input.readInt(true));
        mcCallEvent.setAlertOffset(input.readInt(true));
        mcCallEvent.setRelOffset(input.readInt(true));
        mcCallEvent.setClearOffset(input.readInt(true));
        mcCallEvent.setRspdur(input.readInt(true));
        return mcCallEvent;
    }

}
