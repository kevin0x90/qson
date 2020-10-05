package io.quarkus.qson.desserializer;

public class DoubleParser implements JsonParser {
    @Override
    public ParserState parser() {
        return ObjectParser.PARSER.startNumberValue;
    }

    @Override
    public <T> T getTarget(ParserContext ctx) {
        return (T)Double.valueOf(ctx.popDoubleToken());
    }
}