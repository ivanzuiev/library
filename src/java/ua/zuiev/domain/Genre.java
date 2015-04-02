/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.domain;

import java.util.Objects;

/**
 *
 * @author Vanes
 */
public class Genre implements Comparable{
    
        private int id;
        
    private String genreName;

    public Genre() {
    }

    public Genre(int id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }
    
    

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Genre{" + "id=" + id + ", genreName=" + genreName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.genreName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genre other = (Genre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.genreName, other.genreName)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        Genre other=(Genre)o;
        return genreName.compareTo(other.getGenreName());
    }

    
    
    
}
