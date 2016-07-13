package data.mc.serializer;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import data.mc.McLocationUpdate;

public class McLocationUpdateSerializer extends Serializer<McLocationUpdate> {

    public McLocationUpdateSerializer() {
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, McLocationUpdate object) {
        output.writeLong(object.getStartTime(), true);
        output.writeLong(object.getEndTime(), true);
        output.writeInt(object.getOlac(), true);
        output.writeInt(object.getOci(), true);
        output.writeInt(object.getDlac(), true);
        output.writeInt(object.getDci(), true);
        output.writeString(object.getImsi());
        output.writeInt(object.getResult(), true);
        output.writeInt(object.getEventCause(), true);
    }

    @Override
    public McLocationUpdate read(Kryo kryo, Input input, Class<McLocationUpdate> type) {
        McLocationUpdate object = new McLocationUpdate();
        object.setStartTime(input.readLong(true));
        object.setEndTime(input.readLong(true));
        object.setOlac(input.readInt(true));
        object.setOci(input.readInt(true));
        object.setDlac(input.readInt(true));
        object.setDci(input.readInt(true));
        object.setImsi(input.readString());
        object.setResult(input.readInt(true));
        object.setEventCause(input.readInt(true));
        return object;
    }

}
