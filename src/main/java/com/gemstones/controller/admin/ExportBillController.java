package com.gemstones.controller.admin;

import com.gemstones.dto.ExportBillDTO;
import com.gemstones.service.IExportBillService;
import com.gemstones.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "exportBillControllerOfAdmin")
public class ExportBillController {

    @Autowired
    private IExportBillService exportBillService;

    @RequestMapping(value = "/quan-tri/hoa-don/danh-sach-phieu-ban-hang", method = RequestMethod.GET)
    public ModelAndView showListExportBill(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req,
                                           @RequestParam(value = "tim-kiem", required = false) String searckText,
                                           @RequestParam(value = "orderby", required = false) String orderby) {
        if (orderby == null) {
            orderby = "asc";
        }
        if (searckText == null) {
            searckText = "";
        }
        /*All Bill*/
        ExportBillDTO model = new ExportBillDTO();

        model.setPage(page);
        model.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(exportBillService.findAllByNameAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(exportBillService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        model.setOrderBy(orderby);
        /*End All Bill*/

        /*Finish Bill*/
        ExportBillDTO modelFinish = new ExportBillDTO();

        modelFinish.setPage(page);
        modelFinish.setLimit(limit);
        modelFinish.setListResult(exportBillService.findAllByNameAndStatusAndOrderBy(pageable, searckText,"Hoàn thành", orderby));
        modelFinish.setTotalItem(exportBillService.getTotalItemByStatus("Hoàn thành"));
        modelFinish.setTotalPage((int) Math.ceil((double) modelFinish.getTotalItem() / modelFinish.getLimit()));
        modelFinish.setOrderBy(orderby);
        /*End Finish Bill*/

        /*Unfinish Bill*/
        ExportBillDTO modelUnfinish = new ExportBillDTO();

        modelUnfinish.setPage(page);
        modelUnfinish.setLimit(limit);
        modelUnfinish.setListResult(exportBillService.findAllByNameAndStatusAndOrderBy(pageable, searckText,"Chưa hoàn thành", orderby));
        modelUnfinish.setTotalItem(exportBillService.getTotalItemByStatus("Chưa hoàn thành"));
        modelUnfinish.setTotalPage((int) Math.ceil((double) modelUnfinish.getTotalItem() / modelUnfinish.getLimit()));
        modelUnfinish.setOrderBy(orderby);
        /*End Unfinish Bill*/


        ModelAndView mav = new ModelAndView("admin/bill/listExportBill");
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        mav.addObject("modelFinish", modelFinish);
        mav.addObject("modelUnfinish", modelUnfinish);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/hoa-don/chi-tiet-phieu-ban-hang", method = RequestMethod.GET)
    public ModelAndView detailExportBill(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("admin/bill/detailExportBill");
        ExportBillDTO exportBill = exportBillService.findOneById(id);
        mav.addObject("model", exportBill);
        return mav;
    }
}
