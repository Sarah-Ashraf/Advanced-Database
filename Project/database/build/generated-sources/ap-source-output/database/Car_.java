package database;

import database.Optioncar;
import database.Sale;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-03T17:16:33", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, String> manufacture;
    public static volatile ListAttribute<Car, Optioncar> optioncarList;
    public static volatile SingularAttribute<Car, Integer> price;
    public static volatile ListAttribute<Car, Sale> saleList;
    public static volatile SingularAttribute<Car, String> model;
    public static volatile SingularAttribute<Car, Integer> serialNO;

}