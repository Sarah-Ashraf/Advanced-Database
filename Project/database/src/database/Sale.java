/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fayrouz
 */
@Entity
@Table(name = "sale")
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s"),
    @NamedQuery(name = "Sale.findBySalepersonId", query = "SELECT s FROM Sale s WHERE s.salePK.salepersonId = :salepersonId"),
    @NamedQuery(name = "Sale.findByCARserialNO", query = "SELECT s FROM Sale s WHERE s.salePK.cARserialNO = :cARserialNO"),
    @NamedQuery(name = "Sale.findByDate", query = "SELECT s FROM Sale s WHERE s.date = :date"),
    @NamedQuery(name = "Sale.findBySalePrice", query = "SELECT s FROM Sale s WHERE s.salePrice = :salePrice")})
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalePK salePK;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "SalePrice")
    private Integer salePrice;
    @JoinColumn(name = "CAR_serialNO", referencedColumnName = "serialNO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Car car;
    @JoinColumn(name = "SALEPERSON_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Saleperson saleperson;

    public Sale() {
    }

    public Sale(SalePK salePK) {
        this.salePK = salePK;
    }

    public Sale(String salepersonId, int cARserialNO) {
        this.salePK = new SalePK(salepersonId, cARserialNO);
    }

    public SalePK getSalePK() {
        return salePK;
    }

    public void setSalePK(SalePK salePK) {
        this.salePK = salePK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Saleperson getSaleperson() {
        return saleperson;
    }

    public void setSaleperson(Saleperson saleperson) {
        this.saleperson = saleperson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salePK != null ? salePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.salePK == null && other.salePK != null) || (this.salePK != null && !this.salePK.equals(other.salePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Sale[ salePK=" + salePK + " ]";
    }
    
}
