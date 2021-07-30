package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	//Aqui na connectionFactory, local pra centralizar a conex�o com o bd, foi criado um datasource
	//que � uma interface para lidar com os pools de conex�o.
	//O pool de conex�o reserva um n�mero de conex�es aberta pr� estabelidades para casos onde haja muitas requisi��es.
    //Ao chegar no n�mero m�ximo de conex�es abertas a pr�xima requisi��o aguardaa pr�xima conex�o do pool dispon�vel. O que evita a abertura de conex�es ao banco a todo momento em grandes sistemas.
	
	//Aqui para criar o pool foi necess�rio utilizar a biblioteca c3p0 que fornce o ComboPooledDataSource, mas existem outras.
	private DataSource dataSourse; 
	
	public ConnectionFactory(){
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("tatiana1234");
		
		//define n�mero m�ximo de conex�es abertas
		comboPooledDataSource.setMaxPoolSize(10);
		
		this.dataSourse = comboPooledDataSource;
	}
	
	public Connection createConnection() throws SQLException {
		return this.dataSourse.getConnection();
	}	

}
