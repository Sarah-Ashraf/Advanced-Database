/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Fayrouz
 */
@Entity
@Table(name = "saleperson")
@NamedQueries({
    @NamedQuery(name = "Saleperson.findAll", query = "SELECT s FROM Saleperson s"),
    @NamedQuery(name = "Saleperson.findById", query = "SELECT s FROM Saleperson s WHERE s.id = :id"),
    @NamedQuery(name = "Saleperson.findByName", query = "SELECT s FROM Saleperson s WHERE s.name = :name"),
    @NamedQuery(name = "Saleperson.findByPhone", query = "SELECT s FROM Saleperson s WHERE s.phone = :phone")})
public class Saleperson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Phone")
    private Integer phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleperson")
    private List<Sale> saleList;

    public Saleperson() {
    }

    public Saleperson(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saleperson)) {
            return false;
        }
        Saleperson other = (Saleperson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Saleperson[ id=" + id + " ]";
    }
    
}
