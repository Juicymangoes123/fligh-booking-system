package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class sql_queries {

    //Registering a username and password to the database
    public static void registerNameAndPassword(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightseats?autoReconnect=true&useSSL=false", "root", "password");
        String sql = "Insert into userandpassword(Username, Password) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.executeUpdate();
    }

    //Registering the seats to a user's name
    public static void registerSeats(String user, String bookedSeat) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightseats?autoReconnect=true&useSSL=false", "root", "password");
        String sql = "Insert into bookedseats(username, seat) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user);
        statement.setString(2, bookedSeat);
        statement.executeUpdate();
    }

    //Getting the Seats that have been booked so the user cannot book them
    public static ArrayList<String> getBookedSeats() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightseats?autoReconnect=true&useSSL=false", "root", "password");
        String sql = "Select seat from bookedseats";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<String> seats = new ArrayList<>();
        while (rs.next()){
            seats.add(rs.getString("seat"));
        }
        return seats;
    }

    //Checking if the username and password
    public static boolean checkIfExists(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightseats?autoReconnect=true&useSSL=false", "root", "password");
        String sql = "Select Username, Password from userandpassword where Username = ? and Password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            return true;
        } else {
            return false;
        }

    }
}
