package io.quarkus.qson.serializer;

import java.util.Map;

public class MapWriter implements QsonObjectWriter {
    private final QsonObjectWriter valueWriter;

    public MapWriter(QsonObjectWriter valueWriter) {
        this.valueWriter = valueWriter;
    }

    @Override
    public void write(JsonWriter writer, Object target) {
        Map map = (Map)target;
        writer.write(map, valueWriter);
    }
}
