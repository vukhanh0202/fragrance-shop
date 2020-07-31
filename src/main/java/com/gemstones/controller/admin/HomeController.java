package com.gemstones.controller.admin;

import com.gemstones.dto.ExportBillDTO;
import com.gemstones.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

    @Autowired
    private IExportBillService exportBillService;

    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ExportBillDTO exportBillDTO = new ExportBillDTO();

        double profit = exportBillService.getSumTotalPrice();
        double profitMonth = exportBillService.getSumTotalPriceByMonthAndYear(LocalDate.now().getMonthValue() ,LocalDate.now().getYear());
        int quantityBillfinished = exportBillService.getTotalItemByStatus("Hoàn thành");
        int quantityBillUnfinished = exportBillService.getTotalItemByStatus("Chưa hoàn thành");
        double percent = ((double)quantityBillfinished  / (quantityBillfinished + quantityBillUnfinished));

        ModelAndView mav = new ModelAndView("admin/home");

        mav.addObject("profit", profit);
        mav.addObject("profitMonth", profitMonth);
        mav.addObject("quantityBillUnfinished", quantityBillUnfinished);
        mav.addObject("FinishPercent", (double) Math.round(percent * 100));
        return mav;
    }
}
