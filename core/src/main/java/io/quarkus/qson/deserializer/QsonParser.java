package io.quarkus.qson.deserializer;

import io.quarkus.qson.serializer.JsonByteWriter;

import java.io.IOException;
import java.io.InputStream;

public interface QsonParser {
    /**
     * Initial state
     *
     * @return
     */
    ParserState startState();

    /**
     * Get end target on successful parse
     *
     * @param ctx
     * @param <T>
     * @return
     */
    default
    <T> T getTarget(ParserContext ctx) {
        return ctx.target();
    }

    /**
     * Read object from InputStream
     *
     * @param is
     * @param <T>
     * @return
     * @throws IOException
     */
    default <T> T readFrom(InputStream is) throws IOException {
        ByteArrayParserContext ctx = new ByteArrayParserContext(this);
        return ctx.finish(is);
    }

    /**
     * Read object from byte buffer.  Expects fully buffered json.
     *
     * @param bytes
     * @param <T>
     * @return
     * @throws IOException
     */
    default <T> T readFrom(byte[] bytes) {
        ByteArrayParserContext ctx = new ByteArrayParserContext(this);
        return ctx.finish(bytes);
    }

    /**
     * Read object from json string.
     *
     * @param string
     * @param <T>
     * @return
     * @throws IOException
     */
    default <T> T readFrom(String string) throws IOException {
        return readFrom(string.getBytes(JsonByteWriter.UTF8));
    }
}
