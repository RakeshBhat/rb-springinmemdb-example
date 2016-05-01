package com.example.rbspinginmemdb.main;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBRouter extends RouteBuilder {
		
	@Autowired
	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void configure() throws Exception {
		
		from("timer://timer1?period=1000")
		.setBody(constant("select * from Employee"))
		.to("jdbc:dataSource")
		.split().simple("${body}")
		.log("process row ${body}")
		.process(new Processor(){

			public void process(Exchange xchg) throws Exception {
				
				Map<String, Object> row = xchg.getIn().getBody(Map.class);
				System.out.println("Processing....."+row);
				Employee emp = new Employee();
				
				emp.setId(row.get("ID").toString());
				emp.setName(row.get("NAME").toString());
				emp.setDob(row.get("DOB").toString());
				emp.setSalary((Integer)row.get("SALARY"));
				
				System.out.println("Employee: "+ emp);
			}
			
		})
		.to("mock:result");
		
	}

}
