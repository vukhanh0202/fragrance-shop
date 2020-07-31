package com.gemstones.repository;

import com.gemstones.entity.IncenseGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncenseGroupRepository extends JpaRepository<IncenseGroupEntity, Long> {

    @Query(
            value = "SELECT *\n" +
                    "from incensegroup\n" +
                    "where  LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<IncenseGroupEntity> findAllByNameAndOrderByASC(String searchText,int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from incensegroup\n" +
                    "where  LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<IncenseGroupEntity> findAllByNameAndOrderByDESC(String searchText,int limit, int offset);
}
