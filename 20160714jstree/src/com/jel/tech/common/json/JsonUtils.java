package com.jel.tech.common.json;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

	private static final Gson gsonWithPrettyPrinting = new GsonBuilder().serializeNulls().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	private static final Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	public static <E> String toJson(E obj) {
		return gson.toJson(obj);
	}
	
	public static <E> String toJsonWithPrettyPrint(E obj) {
		return gsonWithPrettyPrinting.toJson(obj);
	}
	
	/**
	 * note:you can build the typeOfSrc in this way:
	 * 	Type fooType = new TypeToken<Foo<Bar>>() {}.getType();
	 * 	where class Bar means the generic class type.
	 * Actually,the toJson with one param is sufficient.
	 * 
	 * @param obj:the generic class
	 * @param typeOfSrc
	 * @return
	 */
	public static <E> String toJson(E obj,Type typeOfSrc) {
			return gson.toJson(obj,typeOfSrc);
	}
	
	public static <E> E fromJson(String jsonStr,Class<E> clazz) {
		return gson.fromJson(jsonStr, clazz);
	}
	
	public static <E> E fromJson(String jsonStr,Type typeOfSrc) {
		return gson.fromJson(jsonStr, typeOfSrc);
	}
	
}
