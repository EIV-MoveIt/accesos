package com.emdl.moveit.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Configuration
public class SQLServerConfig {

	// @Value("${url.oracle}")
	private String urlSqlServer = "jdbc:sqlserver://localhost:1433;databaseName=moveit";

	// @Value("${user.oracle}")
	private String userSqlServer = "moveit";

	// @Value("${pass.oracle}")
	private String passSqlServer = "abc123";

	private static final Logger LOGGER = LoggerFactory.getLogger(OracleConfig.class);

	@Bean
	DataSource dataSource() throws SQLException {

		LOGGER.info("Se conecta a BD en " + urlSqlServer);

		if (urlSqlServer.equals(null) || urlSqlServer.isEmpty() || urlSqlServer.equals("")
				|| urlSqlServer.equals("${url.oracle}")) {
			LOGGER.error(
					"NO SE ENCUENTRA LA CONFIGURACIÓN DE ORACLE. REVISAR CONFIG-SERVICE - url.oracle. LA APLICACION SE TERMINARÁ");
			System.exit(0);
		} else if (userSqlServer.equals(null) || userSqlServer.isEmpty() || userSqlServer.equals("")
				|| userSqlServer.equals("${user.oracle}")) {
			LOGGER.error("NO SE ENCUENTRA LA CONFIGURACIÓN DE ORACLE. REVISAR CONFIG-SERVICE - user.oracle");
			System.exit(0);
		} else if (passSqlServer.equals(null) || passSqlServer.isEmpty() || passSqlServer.equals("")
				|| passSqlServer.equals("${pass.oracle}")) {
			LOGGER.error("NO SE ENCUENTRA LA CONFIGURACIÓN DE ORACLE. REVISAR CONFIG-SERVICE - pass.oracle");
			System.exit(0);
		}

		SQLServerDataSource dataSource = new SQLServerDataSource();

		dataSource.setUser(userSqlServer);
		dataSource.setPassword(passSqlServer);
		dataSource.setURL(urlSqlServer);

		return dataSource;

	}

}
