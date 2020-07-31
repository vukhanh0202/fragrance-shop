package com.gemstones.service.impl;

import com.gemstones.converter.ProductSizeConverter;
import com.gemstones.dto.ProductSizeDTO;
import com.gemstones.entity.ProductSizeEntity;
import com.gemstones.repository.ProductSizeRepository;
import com.gemstones.service.IProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSizeService implements IProductSizeService {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Autowired
    private ProductSizeConverter productSizeConverter;

    @Override
    public int getTotalItem() {
        return (int) productSizeRepository.count();
    }

    @Override
    public List<ProductSizeDTO> findAll(Pageable pageable) {
        List<ProductSizeDTO> models = new ArrayList<>();
        List<ProductSizeEntity> entities = productSizeRepository.findAll(pageable).getContent();

        for (ProductSizeEntity item :
                entities) {
            ProductSizeDTO dto = productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<ProductSizeDTO> findAll() {
        List<ProductSizeDTO> models = new ArrayList<>();
        List<ProductSizeEntity> entities = productSizeRepository.findAll();

        for (ProductSizeEntity item :
                entities) {
            ProductSizeDTO dto = productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

  /*  @Override
    public List<ProductSizeDTO> findAllBySizeAndOrderBy(String searchText, String orderBy) {
        List<ProductSizeDTO> models = new ArrayList<>();
        List<ProductSizeEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = productSizeRepository.findAllBySizeAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = productSizeRepository.findAllBySizeAndOrderByDESC(searchText);
        }

        for (ProductSizeEntity item :
                entities) {
            ProductSizeDTO dto = productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ProductSizeDTO> findAllBySizeAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<ProductSizeDTO> models = new ArrayList<>();
        List<ProductSizeEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = productSizeRepository.findAllBySizeAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = productSizeRepository.findAllBySizeAndOrderByDESC(searchText, limit, offset);
        }

        for (ProductSizeEntity item :
                entities) {
            ProductSizeDTO dto = productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public ProductSizeDTO findOneById(Long id) {
        return productSizeConverter.toDTO(productSizeRepository.findOne(id));
    }

    @Override
    @Transactional
    public ProductSizeDTO save(ProductSizeDTO productSizeDTO) {
        ProductSizeEntity productSizeEntity;

        if (productSizeDTO.getId() != null) {
            ProductSizeEntity oldEntity = productSizeRepository.findOne(productSizeDTO.getId());
            productSizeEntity = productSizeConverter.toEntity(productSizeDTO, oldEntity);
        } else {
            productSizeEntity = productSizeConverter.toEntity(productSizeDTO);
        }
        productSizeEntity = productSizeRepository.save(productSizeEntity);
        try {
            return productSizeConverter.toDTO(productSizeEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            productSizeRepository.delete(id);
        }
    }
}
