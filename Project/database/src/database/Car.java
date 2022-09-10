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
@Table(name = "car")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findBySerialNO", query = "SELECT c FROM Car c WHERE c.serialNO = :serialNO"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByManufacture", query = "SELECT c FROM Car c WHERE c.manufacture = :manufacture"),
    @NamedQuery(name = "Car.findByPrice", query = "SELECT c FROM Car c WHERE c.price = :price")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "serialNO")
    private Integer serialNO;
    @Column(name = "Model")
    private String model;
    @Column(name = "Manufacture")
    private String manufacture;
    @Column(name = "Price")
    private Integer price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Optioncar> optioncarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Sale> saleList;

    public Car() {
    }

    public Car(Integer serialNO) {
        this.serialNO = serialNO;
    }

    public Integer getSerialNO() {
        return serialNO;
    }

    public void setSerialNO(Integer serialNO) {
        this.serialNO = serialNO;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Optioncar> getOptioncarList() {
        return optioncarList;
    }

    public void setOptioncarList(List<Optioncar> optioncarList) {
        this.optioncarList = optioncarList;
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
        hash += (serialNO != null ? serialNO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.serialNO == null && other.serialNO != null) || (this.serialNO != null && !this.serialNO.equals(other.serialNO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Car[ serialNO=" + serialNO + " ]";
    }
    
}
