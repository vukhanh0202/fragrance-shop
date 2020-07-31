package com.gemstones.repository;

import com.gemstones.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.newRelease = 1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize\n" +
                    "\t\t\t\t\twhere  product_productsize.status = \"Đang hoạt động\"\n" +
                    "\t\t\t\t\t)\n" +
                    "order by product.modifiedDate desc",
            nativeQuery = true)
    List<ProductEntity> findAllByNewRelease();

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.bestSeller = 1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize\n" +
                    "\t\t\t\t\twhere  product_productsize.status = \"Đang hoạt động\"\n" +
                    "\t\t\t\t\t)\n" +
                    "order by product.modifiedDate desc",
            nativeQuery = true)
    List<ProductEntity> findAllByBestSeller();

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.hotTrend = 1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize\n" +
                    "\t\t\t\t\twhere  product_productsize.status = \"Đang hoạt động\"\n" +
                    "\t\t\t\t\t)\n" +
                    "order by product.modifiedDate desc",
            nativeQuery = true)
    List<ProductEntity> findAllByHotTrend();

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.seasonal = 1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize\n" +
                    "\t\t\t\t\twhere  product_productsize.status = \"Đang hoạt động\"\n" +
                    "\t\t\t\t\t)\n" +
                    "order by product.modifiedDate desc",
            nativeQuery = true)
    List<ProductEntity> findAllBySeasonal();

    /* Web*/
    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize\n" +
                    "\t\t\t\t\twhere  product_productsize.status = \"Đang hoạt động\"\n" +
                    "\t\t\t\t\t)\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by product.name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findByNameContainingIgnoreCaseAndOrderByNameAsc(String name, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize\n" +
                    "\t\t\t\t\twhere  product_productsize.status = \"Đang hoạt động\"\n" +
                    "\t\t\t\t\t)\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by product.name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findByNameContainingIgnoreCaseAndOrderByNameDesc(String name, int limit, int offset);
    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize, productsize\n" +
                    "                    where product_productsize.productSizeId = productsize.id\n" +
                    "                    and product_productsize.status =\"Đang hoạt động\"\n" +
                    ")" +
                    "order by product.name asc\n" +
                    "LIMIT ?1 OFFSET ?2\n",
            nativeQuery = true)
    List<ProductEntity> findAllByPageableAndOrderByNameASC(int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize, productsize\n" +
                    "                    where product_productsize.productSizeId = productsize.id\n" +
                    "                    and product_productsize.status =\"Đang hoạt động\"\n" +
                    ")" +
                    "order by product.name desc\n" +
                    "LIMIT ?1 OFFSET ?2\n",
            nativeQuery = true)
    List<ProductEntity> findAllByPageableAndOrderByNameDESC(int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.gender=?1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize, productsize\n" +
                    "                    where product_productsize.productSizeId = productsize.id\n" +
                    "                    and product_productsize.status =\"Đang hoạt động\"\n" +
                    ")" +
                    "order by product.name asc\n" +
                    "LIMIT ?2 OFFSET ?3\n",
            nativeQuery = true)
    List<ProductEntity> findAllByPageableAndGenderAndOrderByNameASC(String gender, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.gender=?1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize, productsize\n" +
                    "                    where product_productsize.productSizeId = productsize.id\n" +
                    "                    and product_productsize.status =\"Đang hoạt động\"\n" +
                    ")" +
                    "order by product.name desc\n" +
                    "LIMIT ?2 OFFSET ?3\n",
            nativeQuery = true)
    List<ProductEntity> findAllByPageableAndGenderAndOrderByNameDESC(String gender, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize, productsize\n" +
                    "where product_productsize.productSizeId=productsize.id and\n" +
                    "SUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10\n" +
                    "and product_productsize.status = \"Đang hoạt động\"  )\n" +
                    "order by product.name asc \n" +
                    "LIMIT ?1 OFFSET ?2",
            nativeQuery = true)
    List<ProductEntity> findAllMiniByPageableAndOrderByNameASC(int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize, productsize\n" +
                    "where product_productsize.productSizeId=productsize.id and\n" +
                    "SUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10\n" +
                    "and product_productsize.status = \"Đang hoạt động\"  )\n" +
                    "order by product.name desc \n" +
                    "LIMIT ?1 OFFSET ?2",
            nativeQuery = true)
    List<ProductEntity> findAllMiniByPageableAndOrderByNameDESC(int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where  product.gender=?1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize, productsize\n" +
                    "\t\t\t\t\twhere product_productsize.productSizeId=productsize.id and\t\t\t\t\t\n" +
                    "\t\t\t\t\tSUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10\n" +
                    "\t\t\t\t\tand product_productsize.status = \"Đang hoạt động\")\n" +
                    "order by product.name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllMiniByPageableAndGenderAndOrderByNameASC(String gender, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where  product.gender=?1 and product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize, productsize\n" +
                    "\t\t\t\t\twhere product_productsize.productSizeId=productsize.id and\t\t\t\t\t\n" +
                    "\t\t\t\t\tSUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10\n" +
                    "\t\t\t\t\tand product_productsize.status = \"Đang hoạt động\")\n" +
                    "order by product.name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllMiniByPageableAndGenderAndOrderByNameDESC(String gender, int limit, int offset);
    /*End Web*/

    /*Admin*/
    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndOrderByASC(String searchText, int limit, int offset);


    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndOrderByDESC(String searchText, int limit, int offset);



    /*Gender*/
    @Query(
            value = "SELECT distinct *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and gender=?2\n" +
                    "order by name asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndGenderAndOrderByASC(String searchText, String gender, int limit, int offset);

    @Query(
            value = "SELECT distinct *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and gender=?2\n" +
                    "order by name desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndGenderAndOrderByDESC(String searchText, String gender, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and bestSeller = 1\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndBestSellerAndOrderByASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and bestSeller = 1\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndBestSellerAndOrderByDESC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and hotTrend = 1\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndHotTrendAndOrderByASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and hotTrend = 1\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndHotTrendAndOrderByDESC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and newRelease = 1\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndNewReleaseAndOrderByASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and newRelease = 1\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndNewReleaseAndOrderByDESC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and seasonal = 1\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndSeasonalAndOrderByASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and seasonal = 1\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductEntity> findAllByProductNameAndSeasonalAndOrderByDESC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from product\n" +
                    "where product.gender= ?1 and product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    ")",
            nativeQuery = true)
    int countDistinctByGender(String gender);

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from product\n" +
                    "where product.bestSeller= 1 and product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    ")",
            nativeQuery = true)
    int countDistinctByBestSeller();

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from product\n" +
                    "where product.hotTrend= 1 and product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    ")",
            nativeQuery = true)
    int countDistinctByHotTrend();

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from product\n" +
                    "where product.newRelease and product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    ")",
            nativeQuery = true)
    int countDistinctByNewRelease();

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from product\n" +
                    "where product.seasonal = 1 and product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    ")",
            nativeQuery = true)
    int countDistinctBySeasonal();

    @Query(
            value = "SELECT COUNT(distinct product_productsize.productId)\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and SUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10\n" +
                    "and product_productsize.status = \"Đang hoạt động\";",
            nativeQuery = true)
    int countAllMiniSize();

    @Query(
            value = "SELECT COUNT(distinct product_productsize.productId)\n" +
                    "from product_productsize, productsize, product\n" +
                    "where product_productsize.productSizeId = productsize.id\n" +
                    "and product_productsize.productId = product.id\n" +
                    "and gender = ?1\n" +
                    "and SUBSTRING(productsize.size, 1, length(productsize.size)-2) <= 10\n" +
                    "and product_productsize.status = \"Đang hoạt động\";",
            nativeQuery = true)
    int countAllMiniSizeByGender(String gender);

    @Query(
            value = "SELECT count(*)\n" +
                    "from product_productsize\n" +
                    "where product_productsize.productId = ?1 and product_productsize.status = \"Đang hoạt động\";",
            nativeQuery = true)
    int countTotalProductSize(Long productId);

    @Query(
            value = "SELECT count(*)\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "from product_productsize\n" +
                    "where product_productsize.status = \"Đang hoạt động\"\n" +
                    ")\n",
            nativeQuery = true)
    int countProductActive();

    @Query(
            value = "SELECT *\n" +
                    "from product\n" +
                    "where product.id in (select distinct product_productsize.productId\n" +
                    "\t\t\t\t\tfrom product_productsize\n" +
                    "\t\t\t\t\twhere  product_productsize.status = \"Đang hoạt động\"\n" +
                    "\t\t\t\t\t)\n" +
                    "and LOWER(product.name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by product.name asc",
            nativeQuery = true)
    int countTotalItemBySearch(String searchText);
}
