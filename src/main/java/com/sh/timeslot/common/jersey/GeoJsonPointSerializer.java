package com.sh.timeslot.common.jersey;

/**
 * Created by sfaiziev on 2/2/18.
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.io.IOException;


public class GeoJsonPointSerializer extends JsonSerializer<GeoJsonPoint> {
	@Override
	public void serialize(GeoJsonPoint value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
		gen.writeStartObject();
		gen.writeStringField("type", value.getType());
		gen.writeArrayFieldStart("coordinates");

		gen.writeStartObject();
		gen.writeObjectField("x" , value.getX()  );
		//double[] coord=   { value.getX(), value.getY() };
		//gen.writeStringField();
		gen.writeObjectField("y" ,  value.getY());
		//gen.writeArray( coord, 0,2 );
		//gen.writeObject(value.getCoordinates());
		gen.writeEndObject();
		gen.writeEndArray();
		gen.writeEndObject();
	}

}