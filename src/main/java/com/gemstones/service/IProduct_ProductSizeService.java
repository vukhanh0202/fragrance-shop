package com.gemstones.service;

import com.gemstones.dto.Product_ProductSizeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProduct_ProductSizeService {

    //List<Product_ProductSizeDTO> findAllByGender(Pageable pageable, int condition);

    //List<Product_ProductSizeDTO> findAllByGenders(int condition);

    List<Product_ProductSizeDTO> findAll(Pageable pageable);

    List<Product_ProductSizeDTO> findAll();

    List<Product_ProductSizeDTO> findAllByProductIdAndStatus(Long id, int status);

    //List<Product_ProductSizeDTO> findAllMiniSizeForMale();

    List<Product_ProductSizeDTO> findAllMiniSizeByProductId(Long productId);

    List<Product_ProductSizeDTO> find4GreaterPrice(Double price);

    List<Product_ProductSizeDTO> find4LessPrice(Double price);

    //List<Product_ProductSizeDTO> findAllByProductNameAndOrderBy(String searchText, String orderBy);

    List<Product_ProductSizeDTO> findAllByProductNameAndOrderBy(Pageable pageable, String searchText, String orderBy);

    //List<Product_ProductSizeDTO> findAllByProductNameAndGenderAndOrderBy(String searchText, String gender, String orderBy);

    List<Product_ProductSizeDTO> findAllByProductNameAndGenderAndOrderBy(Pageable pageable, String searchText, String gender, String orderBy);

    //List<Product_ProductSizeDTO> findAllByProductNameAndStatusAndOrderBy(String searchText, String status, String orderBy);

    List<Product_ProductSizeDTO> findAllByProductNameAndStatusAndOrderBy(Pageable pageable, String searchText, String status, String orderBy);

    int getTotalItem();

    int getTotalItemByGender(String gender);

    int getTotalItemByStatus(String status);

    Product_ProductSizeDTO findOneById(Long id);

    Product_ProductSizeDTO save(Product_ProductSizeDTO dto);

    void delete(Long[] ids);

    int getTotalListResult(List<Product_ProductSizeDTO> list);
}
