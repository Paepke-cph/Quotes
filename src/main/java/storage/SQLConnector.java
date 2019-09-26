package storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alexander
 * @author Benjamin
 * @author Mads
 * @author Tobias
 */
public class SQLConnector implements AutoCloseable {

    private final static String USER = "";
    private final static String PASSWORD = "";
    private final static String IP = "127.0.0.1";
    private final static String PORT = "3306";
    private final static String DATABASE = "";
    private final static String SERVERTIME = "serverTimezone=UTC";
    private final static String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?" + SERVERTIME;
    private Connection connection;
    private Statement statement;
    
    public SQLConnector(boolean useProperties) throws SQLException, ClassNotFoundException {
        if(!useProperties) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.prepareStatement(URL);
        } else {
            try(FileInputStream fileInput = new FileInputStream("C:\\Users\\Benjamin\\Documents\\NetBeansProjects\\Quotes\\db.properties")) {
                Class.forName("com.mysql.jdbc.Driver");
                Properties properties = new Properties();
                properties.load(fileInput);
                String fileURL = properties.getProperty("url");
                fileURL += "?"+SERVERTIME;
                String fileUSER = properties.getProperty("user");
                String filePASSWORD = properties.getProperty("password");
                connection = DriverManager.getConnection(fileURL, fileUSER, filePASSWORD);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<HashMap<String, String>> selectQuery(PreparedStatement query) {
        ArrayList<HashMap<String, String>> result = new ArrayList<>();
        try {
            ResultSet rs = query.executeQuery();
            ResultSetMetaData rsdm = rs.getMetaData();
            while (rs.next()) {
                HashMap<String, String> column = new HashMap<>();
                for (int i = 1; i <= rsdm.getColumnCount(); i++) {
                    String name = rsdm.getColumnLabel(i).toLowerCase();
                    column.put(name, rs.getString(name));
                }
                result.add(column);
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean insertUpdateDeleteQuery(PreparedStatement query) {
        try {
            return query.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void close() throws Exception {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
