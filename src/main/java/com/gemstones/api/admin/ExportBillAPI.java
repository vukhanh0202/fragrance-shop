package com.gemstones.api.admin;

import com.gemstones.service.IDetailExportBillService;
import com.gemstones.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "exportBillAPIOfAdmin")
public class ExportBillAPI {

    @Autowired
    private IExportBillService exportBillService;

    @Autowired
    private IDetailExportBillService detailExportBillService;

    @PostMapping("/api/export-bill-admin")
    public void doneBill(@RequestBody Long[] ids) {
        exportBillService.doneBill(ids);
    }

    @DeleteMapping("/api/export-bill-admin")
    public void deleteBill(@RequestBody Long[] ids) {
        for (Long item:
             ids) {
            detailExportBillService.delete(detailExportBillService.findAllByExportBillId(item));
        }
        exportBillService.delete(ids);
    }
}
