package config;

import config.CConfig;
import config.PropertiesNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnection {

    public static final String TIME_ZONE = "Europe/Brussels";

    private Connection connection;


    private static SingletonConnection ourInstance = new SingletonConnection();

    public static SingletonConnection getInstance() {
        return ourInstance;
    }

    private SingletonConnection() {

        try {
            CConfig config = CConfig.getInstance();

            if(getConnection() == null){
                Class.forName(config.getDriver());
                String url = config.getUrl();
                connection = DriverManager.getConnection(url,config.getLogin(),config.getPassword());
               
            }


        } catch (IOException e) {
            e.printStackTrace();

        } catch (PropertiesNotFoundException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
