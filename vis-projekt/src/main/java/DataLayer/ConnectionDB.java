package DataLayer;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                        + "database=VIL0086;"
                        + "user=vil0086;"
                        + "password=OK4ns5J3LG6r8EQu;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";


        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            String createSql = "CREATE TABLE Menu (" +
                    "    id_menu INTEGER NOT NULL," +
                    "    breakfast VARCHAR(60) NOT NULL," +
                    "    snack_1     VARCHAR(60) NOT NULL," +
                    "    lunch          VARCHAR(60) NOT NULL," +
                    "    snack_2     VARCHAR(60) NOT NULL," +
                    "    dinner        VARCHAR(60) NOT NULL," +
                    "    calories INTEGER NOT NULL," +
                    "    carbohydrate     INTEGER NOT NULL," +
                    "    fat          INTEGER NOT NULL," +
                    "    protein     INTEGER NOT NULL," +
                    "    sugar         INTEGER NOT NULL," +
                    "    salt           INTEGER NOT NULL," +
                    "    fiber      INTEGER NOT NULL" +
                    ");";
            
            statement.executeUpdate(createSql);
            System.out.println("Created table in given database...");
            String alterSql ="ALTER TABLE Menu ADD CONSTRAINT Menu_pk PRIMARY KEY ( id_menu )";
            statement.executeUpdate(alterSql);
            System.out.println("Alter table...");
            
            createSql = "CREATE TABLE Customer (" +
                    "    id_customer INTEGER NOT NULL," +
                    "    firstname VARCHAR(20)," +
                    "    lastname VARCHAR(20)," +
                    "    email VARCHAR(50) NOT NULL," +
                    "	 datum_narozeni DATE," +
                    "	  alergie VARCHAR(150)" +
                    ");";
            statement.executeUpdate(createSql);
            System.out.println("Created table in given database...");
            alterSql ="ALTER TABLE Customer ADD CONSTRAINT Customer_pk PRIMARY KEY ( id_customer )";
            statement.executeUpdate(alterSql);
            System.out.println("Alter table...");

            
            
            
            createSql = "CREATE TABLE Orders (id_orders INTEGER NOT NULL, type_menu VARCHAR(40), customer_id_customer    INTEGER NOT NULL, menu_id_menu INTEGER);";
            statement.executeUpdate(createSql);
            System.out.println("Created table in given database...");
            alterSql ="ALTER TABLE Orders ADD CONSTRAINT Order_pk PRIMARY KEY ( id_orders )";
            statement.executeUpdate(alterSql);
            System.out.println("Alter table...");
            
            
            
            
           
            
            alterSql ="ALTER TABLE Orders"
            		+ "    ADD CONSTRAINT orders_menu_fk FOREIGN KEY ( menu_id_menu )"
            		+ "        REFERENCES Menu ( id_menu )";
            statement.executeUpdate(alterSql);
            System.out.println("Alter table...");
            
            
            
            alterSql ="ALTER TABLE Orders"
            		+ "    ADD CONSTRAINT orders_customer_fk FOREIGN KEY ( customer_id_customer )"
            		+ "        REFERENCES Customer ( id_customer );";
            statement.executeUpdate(alterSql);
            System.out.println("Alter table...");
            
            
            
            
            
            
            
            
            
            
            
            
            
            


        }
        catch (SQLException e) {
            e.printStackTrace();
        }







    }






}