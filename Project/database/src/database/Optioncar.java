/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Fayrouz
 */
@Entity
@Table(name = "optioncar")
@NamedQueries({
    @NamedQuery(name = "Optioncar.findAll", query = "SELECT o FROM Optioncar o"),
    @NamedQuery(name = "Optioncar.findByName", query = "SELECT o FROM Optioncar o WHERE o.optioncarPK.name = :name"),
    @NamedQuery(name = "Optioncar.findByPrice", query = "SELECT o FROM Optioncar o WHERE o.price = :price"),
    @NamedQuery(name = "Optioncar.findByCARserialNO", query = "SELECT o FROM Optioncar o WHERE o.optioncarPK.cARserialNO = :cARserialNO")})
public class Optioncar implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OptioncarPK optioncarPK;
    @Column(name = "Price")
    private Integer price;
    @JoinColumn(name = "CAR_serialNO", referencedColumnName = "serialNO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Car car;

    public Optioncar() {
    }

    public Optioncar(OptioncarPK optioncarPK) {
        this.optioncarPK = optioncarPK;
    }

    public Optioncar(String name, int cARserialNO) {
        this.optioncarPK = new OptioncarPK(name, cARserialNO);
    }

    public OptioncarPK getOptioncarPK() {
        return optioncarPK;
    }

    public void setOptioncarPK(OptioncarPK optioncarPK) {
        this.optioncarPK = optioncarPK;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optioncarPK != null ? optioncarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Optioncar)) {
            return false;
        }
        Optioncar other = (Optioncar) object;
        if ((this.optioncarPK == null && other.optioncarPK != null) || (this.optioncarPK != null && !this.optioncarPK.equals(other.optioncarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Optioncar[ optioncarPK=" + optioncarPK + " ]";
    }
    
}
