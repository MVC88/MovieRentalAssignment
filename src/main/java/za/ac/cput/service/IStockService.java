package za.ac.cput.service;

import za.ac.cput.entity.Stock;

import java.util.Set;

@Deprecated
public interface IStockService extends IService<Stock,String>{
    Set<Stock> getAll();
}
