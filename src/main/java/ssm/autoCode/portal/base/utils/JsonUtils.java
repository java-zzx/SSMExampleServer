package ssm.autoCode.portal.base.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import org.codehaus.jackson.*;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Json工具类，实现JSON与Java Bean的互相转换
 */

public class JsonUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();
	private static JsonFactory jsonFactory = new JsonFactory();

	static {
		objectMapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
		objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
	}

	public static <T> T fromJson(String jsonAsString, Class<T> pojoClass) throws JsonMappingException,
			JsonParseException, IOException {
		return objectMapper.readValue(jsonAsString, pojoClass);
	}

	public static <T> T fromJson(FileReader fr, Class<T> pojoClass) throws JsonParseException, IOException {
		return objectMapper.readValue(fr, pojoClass);
	}

	public static String toJson(Object pojo) throws JsonMappingException, JsonGenerationException, IOException {
		return toJson(pojo, false);
	}

	public static String toJson(Object pojo, boolean prettyPrint) throws JsonMappingException, JsonGenerationException,
			IOException {
		StringWriter sw = new StringWriter();
		JsonGenerator jg = jsonFactory.createJsonGenerator(sw);
		if (prettyPrint) {
			jg.useDefaultPrettyPrinter();
		}
		objectMapper.writeValue(jg, pojo);
		return sw.toString();
	}

	public static void toJson(Object pojo, FileWriter fw, boolean prettyPrint) throws JsonMappingException,
			JsonGenerationException, IOException {
		JsonGenerator jg = jsonFactory.createJsonGenerator(fw);
		if (prettyPrint) {
			jg.useDefaultPrettyPrinter();
		}
		objectMapper.writeValue(jg, pojo);
	}

	public static Map<String, Object> parseMap(String jsonStr) throws IOException {
		Map<String, Object> map = objectMapper.readValue(jsonStr, Map.class);
		return map;
	}

	public static JsonNode parse(String jsonStr) throws IOException {
		JsonNode node = null;
		node = objectMapper.readTree(jsonStr);
		return node;
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

    public static <T> List<T>  fromJsonToList(String jsonAsString,Class<T> pojoClass)  throws JsonMappingException,
            JsonParseException, IOException {
        return JSONArray.parseArray(jsonAsString, pojoClass);
    }

}
