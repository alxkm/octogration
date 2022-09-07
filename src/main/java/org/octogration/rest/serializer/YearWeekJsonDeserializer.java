package org.octogration.rest.serializer;

import java.io.IOException;
import org.threeten.extra.YearWeek;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

public class YearWeekJsonDeserializer extends JsonDeserializer<YearWeek> {

    public static final String YEAR_FIELD = "year";
    public static final String WEEK_FIELD = "week";

    @Override
    public YearWeek deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        try {
            ObjectCodec codec = jp.getCodec();
            JsonNode tree = codec.readTree(jp);
            int year = tree.get(YEAR_FIELD).asInt();
            int week = tree.get(WEEK_FIELD).asInt();
            return YearWeek.of(year, week);
        } catch (IOException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new JsonMappingException(jp, "Object deserialize error", ex);
        }

    }

}