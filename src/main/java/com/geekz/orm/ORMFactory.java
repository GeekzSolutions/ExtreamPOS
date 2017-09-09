package com.geekz.orm;

import com.geekz.orm.hibernate.HibernateOperator;

public class ORMFactory {

	public static GeekzORM getORM(String criteria) {
		if (criteria.equals("hibernate")) {
			return HibernateOperator.getInstance();
		} else if (criteria.equals("ebeans")) {
			return null;
		}
		return null;
	}
}
