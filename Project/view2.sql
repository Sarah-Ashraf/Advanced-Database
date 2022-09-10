create view report2 as( 
			select c.Model,c.Price as CarPrice , p.Name as PersonName, s.Date , s.SalePrice
			from  saleperson p,car c,sale s
            where c.serialNO=s.CAR_serialNO and s.SALEPERSON_ID=p.ID
    
);