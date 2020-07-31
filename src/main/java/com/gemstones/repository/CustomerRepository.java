package com.gemstones.repository;

import com.gemstones.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query(
            value = "SELECT *\n" +
                    "from customer\n" +
                    "where  LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<CustomerEntity> findAllByNameAndOrderByNameASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from customer\n" +
                    "where  LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<CustomerEntity> findAllByNameAndOrderByNameDESC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from customer\n" +
                    "where  LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by createdDate asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<CustomerEntity> findAllByNameAndOrderByDateASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from customer\n" +
                    "where  LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by createdDate desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<CustomerEntity> findAllByNameAndOrderByDateDESC(String searchText, int limit, int offset);
}
