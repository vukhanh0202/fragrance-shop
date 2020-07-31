package com.gemstones.converter;

import com.gemstones.dto.CustomerDTO;
import com.gemstones.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public CustomerDTO toDTO(CustomerEntity entity) {
        CustomerDTO dto = new CustomerDTO();
        try {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setAddress(entity.getAddress());
            dto.setCity(entity.getCity());
            dto.setEmail(entity.getEmail());
            dto.setPhone(entity.getPhone());

            dto.setCreatedBy(entity.getCreatedBy());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedBy(entity.getModifiedBy());
            dto.setModifiedDate(entity.getModifiedDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public CustomerEntity toEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();

        try {
            entity.setName(dto.getName());
            entity.setAddress(dto.getAddress());
            entity.setCity(dto.getCity());
            entity.setEmail(dto.getEmail());
            entity.setPhone(dto.getPhone());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public CustomerEntity toEntity(CustomerDTO dto, CustomerEntity entity) {

        try {

            entity.setName(dto.getName());
            entity.setAddress(dto.getAddress());
            entity.setCity(dto.getCity());
            entity.setEmail(dto.getEmail());
            entity.setPhone(dto.getPhone());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
