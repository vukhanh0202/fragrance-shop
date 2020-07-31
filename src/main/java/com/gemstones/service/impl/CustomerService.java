package com.gemstones.service.impl;

import com.gemstones.converter.CustomerConverter;
import com.gemstones.dto.CustomerDTO;
import com.gemstones.entity.CustomerEntity;
import com.gemstones.repository.CustomerRepository;
import com.gemstones.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) {
        CustomerEntity entity;

        if (customerDTO.getId() != null) {
            CustomerEntity oldEntity = customerRepository.findOne(customerDTO.getId());
            entity = customerConverter.toEntity(customerDTO, oldEntity);
        } else {
            entity = customerConverter.toEntity(customerDTO);
        }
        entity = customerRepository.save(entity);
        try {
            return customerConverter.toDTO(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getTotalItem() {
        return (int) customerRepository.count();
    }

    @Override
    public List<CustomerDTO> findAll(Pageable pageable) {
        List<CustomerDTO> models = new ArrayList<>();
        List<CustomerEntity> entities = customerRepository.findAll(pageable).getContent();

        for (CustomerEntity item :
                entities) {
            CustomerDTO dto = customerConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> models = new ArrayList<>();
        List<CustomerEntity> entities = customerRepository.findAll();

        for (CustomerEntity item :
                entities) {
            CustomerDTO dto = customerConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

   /* @Override
    public List<CustomerDTO> findAllByNameAndOrderBy(String searchText, String orderBy) {
        List<CustomerDTO> models = new ArrayList<>();
        List<CustomerEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = customerRepository.findAllByNameAndOrderByNameASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = customerRepository.findAllByNameAndOrderByNameDESC(searchText);
        } else if (orderBy.equalsIgnoreCase("date-asc")) {
            entities = customerRepository.findAllByNameAndOrderByDateASC(searchText);
        } else if (orderBy.equalsIgnoreCase("date-desc")) {
            entities = customerRepository.findAllByNameAndOrderByDateDESC(searchText);
        }

        for (CustomerEntity item :
                entities) {
            CustomerDTO dto = customerConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<CustomerDTO> findAllByNameAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<CustomerDTO> models = new ArrayList<>();
        List<CustomerEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = customerRepository.findAllByNameAndOrderByNameASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = customerRepository.findAllByNameAndOrderByNameDESC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("date-asc")) {
            entities = customerRepository.findAllByNameAndOrderByDateASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("date-desc")) {
            entities = customerRepository.findAllByNameAndOrderByDateDESC(searchText, limit, offset);
        }

        for (CustomerEntity item :
                entities) {
            CustomerDTO dto = customerConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public CustomerDTO findOneById(Long id) {
        return customerConverter.toDTO(customerRepository.findOne(id));
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            customerRepository.delete(id);
        }
    }
}
