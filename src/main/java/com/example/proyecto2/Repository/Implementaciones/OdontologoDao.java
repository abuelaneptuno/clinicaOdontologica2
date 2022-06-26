package com.example.proyecto2.Repository.Implementaciones;

import com.example.proyecto2.Repository.IDao;
import com.example.proyecto2.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class OdontologoDao implements IDao<Odontologo> {

    private static final String DB_JDBC_DRIVER ="org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private static final Logger logger = Logger.getLogger(IDao.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            logger.info("Intentando guardar");
            Class.forName(DB_JDBC_DRIVER);
            connection = getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS(id, matricula, nombre, apellido) VALUES(?,?,?,?)");
            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setInt(2, odontologo.getMatricula());
            preparedStatement.setString(3, odontologo.getNombre());
            preparedStatement.setString(4, odontologo.getApellido());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Guardado correctamente");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("No se pudo guardar");
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar(){
        ArrayList<Odontologo> listaOdontologos = new ArrayList<Odontologo>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Odontologo odontologo = null;

        try {
            logger.info("Intentando listar");
            Class.forName(DB_JDBC_DRIVER);
            connection = getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT id, matricula, nombre, apellido FROM ODONTOLOGOS");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idOdontologo = rs.getInt("id");
                int matriculaOdontologo = rs.getInt("matricula");
                String nombreOdontologo = rs.getString("nombre");
                String apellidoOdontologo = rs.getString("apellido");
                odontologo = new Odontologo(idOdontologo, matriculaOdontologo, nombreOdontologo, apellidoOdontologo);
                listaOdontologos.add(odontologo);
                System.out.println(odontologo.toString());
            }

            preparedStatement.close();
            logger.info("Listado correctamente");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("No se pudo listar");
        }
        return listaOdontologos;

    }

    @Override
    public Odontologo buscar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id, matricula, nombre, apellido FROM ODONTOLOGOS WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idOdontologo = rs.getInt("id");
                int matriculaOdontologo = rs.getInt("matricula");
                String nombreOdontologo = rs.getString("nombre");
                String apellidoOdontologo = rs.getString("apellido");
                odontologo = new Odontologo(idOdontologo, matriculaOdontologo, nombreOdontologo, apellidoOdontologo);
            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public Odontologo eliminar(int id) {
        logger.debug("Borrando odontologo con id : " + id);
        Connection connection = null;
        try {
            connection = getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("DELETE FROM odontologos where id = %s", id);
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("No se pudo eliminar odontologo con id: " + id);
        }


        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        logger.debug("Actualizando odontologo con id : " + odontologo.getId());
        Connection connection = null;
        try {
            connection = getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query =
                    String.format("UPDATE odontologos SET nombre = '%s', apellido = '%s',matricula = '%s'  WHERE id = '%s'",
                            odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula(),
                            odontologo.getId());
            execute(connection, query);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("error de conexión al intentar actualizar");
        }

        return odontologo;
    }

    private void execute(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
