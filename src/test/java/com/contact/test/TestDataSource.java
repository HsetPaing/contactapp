package com.contact.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.contact.config.SpringRootConfig;

public class TestDataSource {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = context.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql = "INSERT INTO `contactdb`.`user` (`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES ('Hsetpaing', '09123456', 'hsetpaing@gmail.com', 'Yangon', 'HsetPaing', 'hsetpaing')";
		//Object[] param = new Object[] {'HsetPaing','09123456','hsetpaing@gmail.com','Yangon','HsetPaing','hsetpaing'};
		jt.update(sql);
		System.out.println("--------SQL EXECUTED-----------");
	}
}
