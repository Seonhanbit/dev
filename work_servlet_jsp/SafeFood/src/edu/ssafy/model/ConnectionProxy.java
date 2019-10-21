package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProxy {
/*	create database ssafy1018;
	use ssafy1018;

	CREATE TABLE food (
	    code INT UNIQUE NOT NULL PRIMARY KEY,
	    name VARCHAR(30),
	    maker VARCHAR(30),
	    material VARCHAR(1000),
	    img VARCHAR(30)
	);

	CREATE TABLE foodNutrition (
	    code INT UNIQUE NOT NULL PRIMARY KEY,
	    name VARCHAR(30),
		supportpereat DOUBLE,
	    calory DOUBLE,
	    carbo DOUBLE,
	    protein DOUBLE,
	    fat DOUBLE,
	    sugar DOUBLE,
	    natrium DOUBLE,
	    chole DOUBLE,
	    fattyacid DOUBLE,
	    transfat DOUBLE,
	   -- allergy VARCHAR(200),
	    year varchar(5),	-- 마지막에서 두번째 정보가 알러지가 아니라 년도 였음
	    maker VARCHAR(30)
	);

	CREATE TABLE members (
	    id VARCHAR(20) PRIMARY KEY,
	    pw VARCHAR(20),
	    name VARCHAR(20),
	    addr VARCHAR(200),
	    tel VARCHAR(15),
	    allergy VARCHAR(200)
	);

	CREATE TABLE visiting (
	    num INTEGER auto_increment primary key,
	    present VARCHAR(50)
	);

	select *from food;
	select *from members;
	select *from visiting;*/
	
	
	public static Connection getConnection() throws SQLException {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafy1018?serverTimezone="
					+ "UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy", "ssafy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Loading Failed...");
		}
		
		return con;
	}
}
