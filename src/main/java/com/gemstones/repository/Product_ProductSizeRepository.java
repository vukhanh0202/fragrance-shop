package com.gemstones.repository;

import com.gemstones.entity.Product_ProductSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Product_ProductSizeRepository extends JpaRepository<Product_ProductSizeEntity, Long> {

    @Query(
            value = "SELECT * \n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllActive();

    List<Product_ProductSizeEntity> findByProductIdAndStatus(Long productId, String status);

    @Query(value = "\n" +
            "SELECT *\n" +
            "from product_productsize, productsize, product\n" +
            "where product_productsize.productSizeId=productsize.id and\n" +
            "\tproduct_productsize.productId = product.id and\n" +
            "\tproduct.gender='Nam' and\n" +
            "\tSUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllMiniSizeForMale();

    @Query(
            value = "\n" +
                    "SELECT *\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId=productsize.id and productId = ?1 and\n" +
                    "\tproduct_productsize.productId = product.id and\n" +
                    "\tSUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllMiniSizeByProductId(Long productId);

    @Query(
            value = "SELECT * \n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    "and product_productsize.newPriceSale < ?1\n" +
                    "order by product_productsize.newPriceSale desc\n" +
                    "LIMIT 4 OFFSET 0",
            nativeQuery = true)
    List<Product_ProductSizeEntity> find4ByNewPriceSaleIsLessThan(Double price);

    @Query(
            value = "SELECT * \n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    "and product_productsize.newPriceSale > ?1\n" +
                    "order by product_productsize.newPriceSale asc\n" +
                    "LIMIT 4 OFFSET 0",
            nativeQuery = true)
    List<Product_ProductSizeEntity> find4ByNewPriceSaleIsGreaterThan(Double price);


    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by product.name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductNameAndOrderByASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by product.name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductNameAndOrderByDESC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by cast(SUBSTRING(productsize.size, 1, length(productsize.size)-2) AS SIGNED) asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductSizeAndOrderByASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by cast(SUBSTRING(productsize.size, 1, length(productsize.size)-2) AS SIGNED) desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductSizeAndOrderByDESC(String searchText, int limit, int offset);

    /*Gender*/
    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product.gender=?2\n" +
                    "order by product.name asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductNameAndGenderAndOrderByASC(String searchText, String gender, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product.gender=?2\n" +
                    "order by product.name desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductNameAndGenderAndOrderByDESC(String searchText, String gender, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product.gender=?2\n" +
                    "order by cast(SUBSTRING(productsize.size, 1, length(productsize.size)-2) AS SIGNED) asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductSizeAndGenderAndOrderByASC(String searchText, String gender, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product.gender=?2\n" +
                    "order by cast(SUBSTRING(productsize.size, 1, length(productsize.size)-2) AS SIGNED) desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductSizeAndGenderAndOrderByDESC(String searchText, String gender, int limit, int offset);

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id and product.gender=?1",
            nativeQuery = true)
    int countDistinctByGender(String gender);

    /*Status*/
    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product_productsize.status =?2\n" +
                    "order by product.name asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductNameAndStatusAndOrderByASC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product_productsize.status =?2\n" +
                    "order by product.name desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductNameAndStatusAndOrderByDESC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product_productsize.status=?2\n" +
                    "order by cast(SUBSTRING(productsize.size, 1, length(productsize.size)-2) AS SIGNED) asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductSizeAndStatusAndOrderByASC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and product_productsize.status=?2\n" +
                    "order by cast(SUBSTRING(productsize.size, 1, length(productsize.size)-2) AS SIGNED) desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<Product_ProductSizeEntity> findAllByProductSizeAndStatusAndOrderByDESC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from product_productsize, product\n" +
                    "where product_productsize.productId = product.id and product_productsize.status=?1",
            nativeQuery = true)
    int countDistinctByStatus(String status);


}
