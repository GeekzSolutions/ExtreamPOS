package com.geekz.orm;

import org.apache.log4j.Logger;

import com.geekz.orm.hibernate.HibernateOperator;

public class ORMFactory {

	final static Logger logger = Logger.getLogger(ORMFactory.class);
	
	public static GeekzORM getORM(String criteria) {
		if (criteria.equals("hibernate")) {
			return HibernateOperator.getInstance();
		} else if (criteria.equals("ebeans")) {
			return null;
		}
		logger.error("invalid ORM is selected");
		return null;
	}
}
