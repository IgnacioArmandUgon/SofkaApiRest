package com.ApiRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		/*String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		try {
			Connection conexion = DriverManager.getConnection(url,"root", "ToPro353");
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}*/
		SpringApplication.run(ApiRestApplication.class, args);
	}

}
