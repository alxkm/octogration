package org.octogration.rest.serializer;

import java.io.IOException;
import org.threeten.extra.YearWeek;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class YearWeekJsonSerializer extends JsonSerializer<YearWeek> {

    public static final String YEAR_FIELD = "year";
    public static final String WEEK_FIELD = "week";

    @Override
    public final void serialize(YearWeek yearWeek, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        try {
            jgen.writeStartObject();
            jgen.writeNumberField(YEAR_FIELD, yearWeek.getYear());
            jgen.writeNumberField(WEEK_FIELD, yearWeek.getWeek());
            jgen.writeEndObject();
        } catch (IOException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new JsonMappingException(jgen, "Object serialize error", ex);
        }
    }

}