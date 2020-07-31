package com.gemstones.service;

import com.gemstones.dto.CustomerDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    CustomerDTO save(CustomerDTO customerDTO);
    int getTotalItem();
    List<CustomerDTO> findAll(Pageable pageable);
    List<CustomerDTO> findAll();
    //List<CustomerDTO> findAllByNameAndOrderBy(String searchText, String orderBy);
    List<CustomerDTO> findAllByNameAndOrderBy(Pageable pageable, String searchText, String orderBy);
    CustomerDTO findOneById(Long id);
    void delete(Long[] ids);
}
