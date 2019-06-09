package com.sh.timeslot.common.jersey;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.io.IOException;

/**
 * Created by sfaiziev on 2/2/18.
 */
@Slf4j
public class GeoJsonPointDeserializer extends JsonDeserializer<GeoJsonPoint> {
	@Override
	public GeoJsonPoint deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		ObjectCodec oc = jp.getCodec();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
		JsonNode node = oc.readTree(jp);
		Double valueX , valueY;

		try {
			valueX = mapper.treeToValue(node.get("x"), Double.class);
			valueY = mapper.treeToValue(node.get("y"), Double.class);
			return new GeoJsonPoint(valueX , valueY);
		}
		catch (IOException e) {
			e.printStackTrace();
			log.error("Exception GeoJsonPointDeserializer : " + e.getMessage());
		}
		return null;
	}

}
