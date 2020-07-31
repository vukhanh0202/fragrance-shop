package com.gemstones.api.web;

import com.gemstones.dto.CustomerDTO;
import com.gemstones.dto.DetailExportBillDTO;
import com.gemstones.dto.ExportBillDTO;
import com.gemstones.service.ICustomerService;
import com.gemstones.service.IDetailExportBillService;
import com.gemstones.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "exportBillAPIOfWeb")
public class ExportBillAPI {


    @Autowired
    private IExportBillService exportBillService;

    @Autowired
    private IDetailExportBillService detailExportBillService;

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/api/export-bill")
    public CustomerDTO createExportBill(@RequestBody CustomerDTO customer, HttpSession session) {
        ExportBillDTO cart = (ExportBillDTO) session.getAttribute("Cart");
        cart.setStatus("Chưa hoàn thành");
        customer = customerService.save(customer);

        cart.setCustomer(customer);
        cart.setDateExport(LocalDate.now());
        List<DetailExportBillDTO> listDetail = new ArrayList<>();

        List<DetailExportBillDTO> oldListDetail = cart.getListResultDetailProduct();
        cart.setListResultDetailProduct(null);
        cart = exportBillService.save(cart);
        cart.setListResultDetailProduct(oldListDetail);
        for (DetailExportBillDTO item:
                cart.getListResultDetailProduct()) {
            item.setExportBillId(cart.getId());
            item.setExportBill(cart);

            DetailExportBillDTO detail = detailExportBillService.save(item);
            listDetail.add(detail);
        }

        return customer;
    }
}
