package com.gemstones.service;

import com.gemstones.dto.ProductDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    //List<ProductDTO> findAllBySearchText(String searchText, String orderBy);

    List<ProductDTO> findAllBySearchText(Pageable pageable, String searchText, String orderBy);

    List<ProductDTO> findAllByGender(Pageable pageable, int condition, String orderBy);

    //List<ProductDTO> findAllByGenders(int condition, String orderBy);

    List<ProductDTO> findAllByNewRelease();

    List<ProductDTO> findAllByBestSeller();

    List<ProductDTO> findAllByHotTrend();

    List<ProductDTO> findAllBySeasonal();

    List<ProductDTO> findAll(Pageable pageable, String orderBy);

    //List<ProductDTO> findAll(String orderBy);

    //List<ProductDTO> findAll(Pageable pageable);

    List<ProductDTO> findAll();

    //List<ProductDTO> findAllMiniSize(String orderBy);

    List<ProductDTO> findAllMiniSize(Pageable pageable, String orderBy);

    //List<ProductDTO> findAllMiniSizeByGender(int gender, String orderBy);

    List<ProductDTO> findAllMiniSizeByGender(Pageable pageable, int gender, String orderBy);

    //List<ProductDTO> findAllByProductNameAndOrderBy(String searchText, String orderBy);

    List<ProductDTO> findAllByProductNameAndOrderBy(Pageable pageable, String searchText, String orderBy);

    //List<ProductDTO> findAllByProductNameAndGenderAndOrderBy(String searchText, String gender, String orderBy);

    List<ProductDTO> findAllByProductNameAndGenderAndOrderBy(Pageable pageable, String searchText, String gender, String orderBy);

    //List<ProductDTO> findAllByProductNameAndBestSellerAndOrderBy(String searchText, String orderBy);

    List<ProductDTO> findAllByProductNameAndBestSellerAndOrderBy(Pageable pageable, String searchText, String orderBy);

    //List<ProductDTO> findAllByProductNameAndHotTrendAndOrderBy(String searchText, String orderBy);

    List<ProductDTO> findAllByProductNameAndHotTrendAndOrderBy(Pageable pageable, String searchText, String orderBy);

    //List<ProductDTO> findAllByProductNameAndSeasonalAndOrderBy(String searchText, String orderBy);

    List<ProductDTO> findAllByProductNameAndSeasonalAndOrderBy(Pageable pageable, String searchText, String orderBy);

    //List<ProductDTO> findAllByProductNameAndNewReleaseAndOrderBy(String searchText, String orderBy);

    List<ProductDTO> findAllByProductNameAndNewReleaseAndOrderBy(Pageable pageable, String searchText, String orderBy);

    int getTotalItem();
    int getTotalItemActive();

    int getTotalItemByGender(String gender);

    int getTotalItemMini();

    int getTotalItemMiniByGender(String gender);

    int getTotalItemBySearch(String searchText);

    int getTotalItemByBestSeller();

    int getTotalItemByHotTrend();

    int getTotalItemByNewRelease();

    int getTotalItemBySeasonal();

    ProductDTO findOneById(Long id);

    ProductDTO save(ProductDTO productDTO);

    void delete(Long[] ids);
}
