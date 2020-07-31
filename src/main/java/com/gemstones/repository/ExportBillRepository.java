package com.gemstones.repository;

import com.gemstones.entity.ExportBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExportBillRepository extends JpaRepository<ExportBillEntity, Long> {

    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndOrderByNameASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by name desc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndOrderByNameDESC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by totalPrice asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndOrderByPriceASC(String searchText, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "order by totalPrice asc\n" +
                    "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndOrderByPriceDESC(String searchText, int limit, int offset);

    /*Query by status*/
    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and exportbill.status = ?2\n" +
                    "order by name asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndStatusAndOrderByNameASC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and exportbill.status = ?2\n" +
                    "order by name desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndStatusAndOrderByNameDESC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and exportbill.status = ?2\n" +
                    "order by totalPrice asc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndStatusAndOrderByPriceASC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT *\n" +
                    "from exportbill,customer\n" +
                    "where exportbill.customerId = customer.id \n" +
                    "and LOWER(name) LIKE CONCAT(\"%\",  LOWER(?1), \"%\")\n" +
                    "and exportbill.status = ?2\n" +
                    "order by totalPrice desc\n" +
                    "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<ExportBillEntity> findAllByNameAndStatusAndOrderByPriceDESC(String searchText, String status, int limit, int offset);

    @Query(
            value = "SELECT count(*)\n" +
                    "from exportbill\n" +
                    "where  exportbill.status=?1",
            nativeQuery = true)
    int countDistinctByStatus(String status);

    @Query(
            value = "SELECT SUM(totalPrice)\n" +
                    "from exportbill\n" +
                    "where status = \"Hoàn thành\"",
            nativeQuery = true)
    int getSumTotalPrice();

    @Query(
            value = "SELECT SUM(totalPrice)\n" +
                    "from exportbill\n" +
                    "where status = \"Hoàn thành\" and MONTH(createdDate) = ?1 and YEAR(createdDate) = ?2",
            nativeQuery = true)
    int getSumTotalPriceByMonthAndYear(int month, int year);
}
