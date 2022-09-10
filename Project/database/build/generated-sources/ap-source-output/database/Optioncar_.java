package database;

import database.Car;
import database.OptioncarPK;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-03T17:16:33", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Optioncar.class)
public class Optioncar_ { 

    public static volatile SingularAttribute<Optioncar, Car> car;
    public static volatile SingularAttribute<Optioncar, Integer> price;
    public static volatile SingularAttribute<Optioncar, OptioncarPK> optioncarPK;

}