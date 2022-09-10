create view report1 as( 
			select c.Model,c.Manufacture,c.Price as CarPrice,
            p.Name as OptionName,p.Price as OptionPrice, (p.Price + c.Price) as TotalPrice
			from  optioncar p,car c
            where c.serialNO=p.CAR_serialNO
    
);