/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.zuiev.domain.Publisher;

/**
 *
 * @author Vanes
 */
public class PublisherDaoImpl implements PublisherDao {

    @Override
    public List<Publisher> getAllPublishers() {
        List<Publisher> publishers = new ArrayList<>();

        try (Connection conn = (new LibraryConnectionFactory()).getConnection();
                PreparedStatement prepSt = conn
                .prepareStatement("SELECT * FROM publisher");
                ResultSet rs = prepSt.executeQuery();) {

            while (rs.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(rs.getInt(1));
                publisher.setName(rs.getString(2));

                publishers.add(publisher);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publishers;
    }
}
