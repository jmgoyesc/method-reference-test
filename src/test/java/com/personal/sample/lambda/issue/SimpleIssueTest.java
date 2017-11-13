package com.personal.sample.lambda.issue;

import com.personal.sample.lambda.issue.dao.PublicDao;
import com.personal.sample.test.other.PublicClass;
import java.util.Collection;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleIssueTest {

	private PublicDao publicDao;
	private Collection<PublicClass> elements;

	@Before
	public void setUp(){
		//Create list of PublicClass objects
		publicDao = new PublicDao();
		elements = publicDao.findAll();
	}

	@Test
	public void testIssue01() {
		//The problem is because package visibility
		String message = elements.stream()
								 .map(PublicClass::getId)
								 .map(publicDao::findById)
								 .map(Object::toString)
								 .collect(Collectors.joining(", "));

		Assert.assertEquals("PublicClass{id=1, key=1}, PublicClass{id=2, key=2}", message);
	}

	@Test
	public void testIssue02() {
		//The problem is because package visibility
		String message = elements.stream()
								 .map(a -> publicDao.findById(a.getId()))
								 .map(Object::toString)
								 .collect(Collectors.joining(", "));

		Assert.assertEquals("PublicClass{id=1, key=1}, PublicClass{id=2, key=2}", message);
	}

}
