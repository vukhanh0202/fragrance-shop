package com.gemstones.controller.admin;

import com.gemstones.dto.IncenseGroupDTO;
import com.gemstones.service.IIncenseGroupService;
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

@Controller(value = "incenseGroupControllerAdmin")
public class IncenseGroupController {

    @Autowired
    private IIncenseGroupService incenseGroupService;


    @RequestMapping(value = "/quan-tri/san-pham/danh-sach-nhom-huong", method = RequestMethod.GET)
    public ModelAndView showListIncenseGroup(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req,
                                             @RequestParam(value = "tim-kiem", required = false) String searckText,
                                             @RequestParam(value = "orderby", required = false) String orderby) {
        if (orderby == null) {
            orderby = "asc";
        }
        if (searckText == null) {
            searckText = "";
        }

        IncenseGroupDTO model = new IncenseGroupDTO();

        model.setPage(page);
        model.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(incenseGroupService.findAllByNameAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(incenseGroupService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        model.setOrderBy(orderby);

        ModelAndView mav = new ModelAndView("admin/products/listIncenseGroup");
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/san-pham/chinh-sua-nhom-huong", method = RequestMethod.GET)
    public ModelAndView editIncenseGroup(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("admin/products/editIncenseGroup");
        IncenseGroupDTO model = new IncenseGroupDTO();
        if (id != null) {
            model = incenseGroupService.findOneById(id);
        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
}
