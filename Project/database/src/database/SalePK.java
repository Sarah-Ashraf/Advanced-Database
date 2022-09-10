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
public class SalePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SALEPERSON_ID")
    private String salepersonId;
    @Basic(optional = false)
    @Column(name = "CAR_serialNO")
    private int cARserialNO;

    public SalePK() {
    }

    public SalePK(String salepersonId, int cARserialNO) {
        this.salepersonId = salepersonId;
        this.cARserialNO = cARserialNO;
    }

    public String getSalepersonId() {
        return salepersonId;
    }

    public void setSalepersonId(String salepersonId) {
        this.salepersonId = salepersonId;
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
        hash += (salepersonId != null ? salepersonId.hashCode() : 0);
        hash += (int) cARserialNO;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalePK)) {
            return false;
        }
        SalePK other = (SalePK) object;
        if ((this.salepersonId == null && other.salepersonId != null) || (this.salepersonId != null && !this.salepersonId.equals(other.salepersonId))) {
            return false;
        }
        if (this.cARserialNO != other.cARserialNO) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.SalePK[ salepersonId=" + salepersonId + ", cARserialNO=" + cARserialNO + " ]";
    }
    
}
