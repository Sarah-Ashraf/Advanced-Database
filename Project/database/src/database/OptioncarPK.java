/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Fayrouz
 */
@Embeddable
public class OptioncarPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "CAR_serialNO")
    private int cARserialNO;

    public OptioncarPK() {
    }

    public OptioncarPK(String name, int cARserialNO) {
        this.name = name;
        this.cARserialNO = cARserialNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCARserialNO() {
        return cARserialNO;
    }

    public void setCARserialNO(int cARserialNO) {
        this.cARserialNO = cARserialNO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        hash += (int) cARserialNO;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OptioncarPK)) {
            return false;
        }
        OptioncarPK other = (OptioncarPK) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        if (this.cARserialNO != other.cARserialNO) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.OptioncarPK[ name=" + name + ", cARserialNO=" + cARserialNO + " ]";
    }
    
}
