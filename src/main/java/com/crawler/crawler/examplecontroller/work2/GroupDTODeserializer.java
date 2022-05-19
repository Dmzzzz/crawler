package com.crawler.crawler.examplecontroller.work2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class GroupDTODeserializer extends JsonDeserializer<GroupRestDTO> {

    @Override
    public GroupRestDTO deserialize(JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return null;
    }
}
