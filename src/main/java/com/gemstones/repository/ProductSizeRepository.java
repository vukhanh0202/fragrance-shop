package com.gemstones.repository;

import com.gemstones.entity.ProductSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductSizeRepository extends JpaRepository<ProductSizeEntity, Long> {

    @Query(
            value = "SELECT *\n" +
                    "from productsize\n" +
                    "where  LOWER(size) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by cast(SUBSTRING(size, 1, length(size)-2) AS SIGNED) asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductSizeEntity> findAllBySizeAndOrderByASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from productsize\n" +
                    "where  LOWER(size) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by cast(SUBSTRING(size, 1, length(size)-2) AS SIGNED) desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ProductSizeEntity> findAllBySizeAndOrderByDESC(String searchText, int limit, int offset);
}
