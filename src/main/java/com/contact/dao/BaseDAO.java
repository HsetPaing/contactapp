package com.contact.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//NOTE: do not @repository or @Sefvice or @Componet annotation
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
	
	@Autowired
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);
	}
}
