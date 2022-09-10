package database;

import database.Car;
import database.SalePK;
import database.Saleperson;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-03T17:16:33", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, Date> date;
    public static volatile SingularAttribute<Sale, SalePK> salePK;
    public static volatile SingularAttribute<Sale, Integer> salePrice;
    public static volatile SingularAttribute<Sale, Car> car;
    public static volatile SingularAttribute<Sale, Saleperson> saleperson;

}