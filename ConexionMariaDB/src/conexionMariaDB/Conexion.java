package conexionMariaDB;

import java.sql.*;

public class Conexion {
  public static void main(String[] args) {
    try {
      // Cargar el driver de MySQL
        Class.forName("org.mariadb.jdbc.Driver");

      // Conectar a la base de datos
        Connection con = DriverManager.getConnection(
                "jdbc:mariadb://127.0.0.1:3306/practica conectores", "root", "1111");

      // Crear las sentencias
      Statement stmt = con.createStatement();
      Statement stmt2 = con.createStatement();
      Statement stmt3 = con.createStatement();
      Statement stmt4 = con.createStatement();
      Statement stmt5 = con.createStatement();
      Statement stmt6 = con.createStatement();


      // Ejecutar las consultas
     
      consultaC(stmt);
      consultaE(stmt2); //NO DEVUELVE NADA YA QUE AL FINAL DE LA PRACTICA HICIMOS UN UPDATE A LAS COMISIONES Y SALARIOS POR LO QUE NO COINCIDE NINGUNO
      consultaF(stmt3);
      consultaF(stmt4);// NO DEVUELVE NADA YA QUE NO TIENE TANTO PRESUPUESTO NINGUN DEPARTAMENTO
      consultaJ(stmt5);
      consultaK(stmt6);
      // Cerrar la conexión
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void consultaC(Statement stmt) throws SQLException {
	  ResultSet rs = stmt.executeQuery("SELECT AVG(YEAR(CURDATE())-YEAR(fecin)) AS Media\r\n"
	      		+ "FROM temple\r\n"
	      		+ "WHERE numde IN (111,112);");
	      while (rs.next()) {
	        System.out.println(rs.getString("Media") + " " );
	      }
  }
  public static void consultaE(Statement stmt) throws SQLException {
      ResultSet rs = stmt.executeQuery("SELECT nomem, salar \r\n"
      		+ "\r\n"
      		+ "FROM temple \r\n"
      		+ "\r\n"
      		+ "WHERE salar in (SELECT comis FROM temple) \r\n"
      		+ "\r\n"
      		+ "ORDER BY nomem; ");
      while (rs.next()) {
        System.out.println(rs.getString("nomem") + " " + rs.getString("salar"));
      }
      }

public static void consultaF(Statement stmt) throws SQLException {
    ResultSet rs = stmt.executeQuery("SELECT tdepto.NUMDE, COUNT(temple.NUMEM) AS NumEmpleados, SUM(temple.SALAR + temple.COMIS + temple.NUMHI) AS Total\r\n"
    		+ "FROM tdepto\r\n"
    		+ "JOIN temple ON tdepto.NUMDE = temple.NUMDE\r\n"
    		+ "WHERE tdepto.TIDIR = 'F'\r\n"
    		+ "GROUP BY tdepto.NUMDE\r\n"
    		+ "ORDER BY tdepto.NUMDE;");
    while (rs.next()) {
      System.out.println(rs.getString("numde") + " " + rs.getString("NumEmpleados")+" "+ rs.getString("Total"));
    }
    }
public static void consultaG(Statement stmt) throws SQLException {
    ResultSet rs = stmt.executeQuery("SELECT tdepto.NUMDE, AVG(temple.EXTEL) / COUNT(temple.NUMEM) AS \"Empleados por extensión\"\r\n"
    		+ "FROM tdepto\r\n"
    		+ "INNER JOIN temple ON tdepto.NUMDE = temple.NUMDE\r\n"
    		+ "WHERE tdepto.PRESU > 100000\r\n"
    		+ "GROUP BY tdepto.NUMDE");
    while (rs.next()) {
      System.out.println(rs.getString("numde") + " " + rs.getString("NumEmpleados")+" "+ rs.getString("Total"));
    }
    }
public static void consultaJ(Statement stmt) throws SQLException {
    ResultSet rs = stmt.executeQuery("DELIMITER $$ \r\n"
    		+ "DROP PROCEDURE IF EXISTS mostrarEmpleadosDept$$ \r\n"
    		+ "CREATE PROCEDURE mostrarEmpleadosDept(IN num_dept INT) \r\n"
    		+ "BEGIN \r\n"
    		+ "  SELECT * FROM TEMPLE WHERE numde = num_dept; \r\n"
    		+ "END $$ \r\n"
    		+ "DELIMITER ; );");
    while (rs.next()) {
      System.out.println(rs.getString("*"));
    }
    }
public static void consultaK(Statement stmt) throws SQLException {
    ResultSet rs = stmt.executeQuery("DELIMITER $$ \r\n"
    		+ "DROP PROCEDURE IF EXISTS empleados_sin_comision$$ \r\n"
    		+ "CREATE PROCEDURE empleados_sin_comision() \r\n"
    		+ "BEGIN \r\n"
    		+ "DECLARE @contador INT DEFAULT 0$$ \r\n"
    		+ "SELECT numem, \r\n"
    		+ "IFNULL(comis, 0) AS comision \r\n"
    		+ "  INTO @contador \r\n"
    		+ "  FROM temple \r\n"
    		+ "  WHERE comis IS NULL$$ \r\n"
    		+ "  SELECT @contador AS 'Empleados sin comisión'$$ \r\n"
    		+ "END$$ \r\n"
    		+ "DELIMITER ; ");
    while (rs.next()) {
      System.out.println(rs.getString("numde") + " " + rs.getString("NumEmpleados")+" "+ rs.getString("Total"));
    }
    }
}
