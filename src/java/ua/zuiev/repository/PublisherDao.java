/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.repository;

import java.util.List;
import ua.zuiev.domain.Publisher;

/**
 *
 * @author Vanes
 */
public interface PublisherDao {
    
    List<Publisher> getAllPublishers();
    
}
