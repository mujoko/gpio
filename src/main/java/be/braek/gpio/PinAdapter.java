package be.braek.gpio;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class PinAdapter extends TypeAdapter<Pin> {

    public void write(JsonWriter writer, Pin pin) throws IOException {
        writer.beginObject();
        writer.name("type").value("pins");
        writer.name("id").value(String.valueOf(pin.getId()));
        writer.name("attributes");
        writer.beginObject();
        writer.name("address").value(pin.getAddress());
        writer.name("state").value(pin.getState());
        writer.endObject();
        writer.endObject();
    }

    public Pin read(JsonReader reader) throws IOException {
        return null;
    }
}
