package io.github.cisumer.wcfbin4j;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/**
* 加载字典json
*/
public class Dictionary {
	private static Map<Integer,String> DICT;
	static{
		Gson gson=new GsonBuilder().registerTypeAdapter(Integer.class, new TypeAdapter<Integer>() {
			@Override
			public void write(JsonWriter out, Integer value) throws IOException {//不需要写入
			}

			@Override
			public Integer read(JsonReader in) throws IOException {
				if (in.peek() == JsonToken.NULL) {
					in.nextNull();
					return null;
				}
				String value=in.nextString();
				if("".equals(value)||value==null)
					return null;
				return Integer.decode(value);//加载16进制
			}
		}).create();
		try {
		    String json=IOUtils.toString(Dictionary.class.getClassLoader().getResourceAsStream("dict.json"),"UTF-8");
		    DICT = gson.fromJson(json, new TypeToken<Map<Integer,String>>(){}.getType());
		} catch (Exception e) {
		    System.err.println(e);
		}
	}
	public static String getDictionary(Integer key){
	    return DICT.get(key);
	}
}
