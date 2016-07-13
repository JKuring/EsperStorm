package data.mc.serializer;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import data.mc.McPaging;

public class McPagingSerializer extends Serializer<McPaging> {

    public McPagingSerializer() {
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, McPaging mcPaging) {
        output.writeLong(mcPaging.getStartTime(), true);
        output.writeLong(mcPaging.getEndTime(), true);
        output.writeInt(mcPaging.getEventId(), true);
        output.writeString(mcPaging.getCallingImsi());
        output.writeString(mcPaging.getCalledImsi());
        output.writeInt(mcPaging.getPagingResptype(), true);
        output.writeInt(mcPaging.getRspdur(), true);
        output.writeInt(mcPaging.getXdrtype(), true);
    }

    @Override
    public McPaging read(Kryo kryo, Input i, Class<McPaging> type) {
        McPaging mc = new McPaging();
        mc.setStartTime(i.readLong(true));
        mc.setEndTime(i.readLong(true));
        mc.setEventId(i.readInt(true));
        mc.setCallingImsi(i.readString());
        mc.setCalledImsi(i.readString());
        mc.setPagingResptype(i.readInt(true));
        mc.setRspdur(i.readInt(true));
        mc.setXdrtype(i.readInt(true));
        return mc;
    }

}
