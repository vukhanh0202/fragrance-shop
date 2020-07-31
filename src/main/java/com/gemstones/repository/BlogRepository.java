package com.gemstones.repository;

import com.gemstones.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    @Query(
            value = "SELECT *\n" +
                    "from blog\n" +
                    "where  LOWER(title) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by title asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<BlogEntity> findAllByTitleAndOrderByNameASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from blog\n" +
                    "where  LOWER(title) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by title desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<BlogEntity> findAllByTitleAndOrderByNameDESC(String searchText, int limit, int offset);

    @Query(
            value = "\n" +
                    "SELECT *\n" +
                    "from blog\n" +
                    "where  LOWER(title) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and typeBlog = ?2\n" +
                    "order by title asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<BlogEntity> findAllByTitleAndTypeBlogAndOrderByNameASC(String searchText, String typeBlog, int limit, int offset);

    @Query(
            value = "\n" +
                    "SELECT *\n" +
                    "from blog\n" +
                    "where  LOWER(title) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and typeBlog = ?2\n" +
                    "order by title desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<BlogEntity> findAllByTitleAndTypeBlogAndOrderByNameDESC(String searchText, String typeBlog, int limit, int offset);

    @Query(
            value = "SELECT COUNT(*)\n" +
                    "from blog\n" +
                    "where typeBlog = ?1",
            nativeQuery = true)
    int countDistinctByTypeBlog(String status);

    @Query(
            value = "SELECT *\n" +
                    "from blog\n" +
                    "where typeBlog = ?1\n" +
                    "order by modifiedDate desc",
            nativeQuery = true)
    List<BlogEntity> findAllByTypeBlogAndOrOrderByModifiedDate(String typeBlog);

}
