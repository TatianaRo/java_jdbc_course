package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	//Aqui na connectionFactory, local pra centralizar a conexão com o bd, foi criado um datasource
	//que é uma interface para lidar com os pools de conexão.
	//O pool de conexão reserva um número de conexões aberta pré estabelidades para casos onde haja muitas requisições.
    //Ao chegar no número máximo de conexões abertas a próxima requisição aguardaa próxima conexão do pool disponível. O que evita a abertura de conexões ao banco a todo momento em grandes sistemas.
	
	//Aqui para criar o pool foi necessário utilizar a biblioteca c3p0 que fornce o ComboPooledDataSource, mas existem outras.
	private DataSource dataSourse; 
	
	public ConnectionFactory(){
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("tatiana1234");
		
		//define número máximo de conexões abertas
		comboPooledDataSource.setMaxPoolSize(10);
		
		this.dataSourse = comboPooledDataSource;
	}
	
	public Connection createConnection() throws SQLException {
		return this.dataSourse.getConnection();
	}	

}
