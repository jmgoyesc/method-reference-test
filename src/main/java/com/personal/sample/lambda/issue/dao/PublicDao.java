package com.personal.sample.lambda.issue.dao;

import com.personal.sample.test.other.PublicClass;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PublicDao {
	private static final Map<String, PublicClass> PUBLIC_CLASSES = init();

	private static Map<String, PublicClass> init(){
		Map<String, PublicClass> publicClasses = new HashMap<>();
		publicClasses.put("1", build("1", 1L));
		publicClasses.put("2", build("2", 2L));
		return publicClasses;
	}

	private static PublicClass build(String id, Long key){
		PublicClass publicClass = new PublicClass();
		publicClass.setId(id);
		publicClass.setKey(key);
		return publicClass;
	}

	public PublicClass findById(String id){
		return PUBLIC_CLASSES.get(id);
	}

	public Collection<PublicClass> findAll(){
		return PUBLIC_CLASSES.values();
	}
}
