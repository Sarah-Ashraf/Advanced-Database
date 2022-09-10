package database;

import database.Sale;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-03T17:16:33", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Saleperson.class)
public class Saleperson_ { 

    public static volatile SingularAttribute<Saleperson, Integer> phone;
    public static volatile ListAttribute<Saleperson, Sale> saleList;
    public static volatile SingularAttribute<Saleperson, String> name;
    public static volatile SingularAttribute<Saleperson, String> id;

}