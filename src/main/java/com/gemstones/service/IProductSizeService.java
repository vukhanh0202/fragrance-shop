package com.gemstones.service;

import com.gemstones.dto.ProductSizeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductSizeService {

    int getTotalItem();
    List<ProductSizeDTO> findAll(Pageable pageable);
    List<ProductSizeDTO> findAll();
    //List<ProductSizeDTO> findAllBySizeAndOrderBy(String searchText, String orderBy);
    List<ProductSizeDTO> findAllBySizeAndOrderBy(Pageable pageable, String searchText, String orderBy);
    ProductSizeDTO findOneById(Long id);
    ProductSizeDTO save(ProductSizeDTO productDTO);
    void delete(Long[] ids);
}
