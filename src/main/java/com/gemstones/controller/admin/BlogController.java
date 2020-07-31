package com.gemstones.controller.admin;

import com.gemstones.dto.BlogDTO;
import com.gemstones.service.IBlogService;
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

@Controller(value = "blogControllerOfAdmin")
public class BlogController {

    @Autowired
    private IBlogService blogService;


    @RequestMapping(value = "/quan-tri/blog/danh-sach-blog", method = RequestMethod.GET)
    public ModelAndView showListBlog(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req,
                                             @RequestParam(value = "tim-kiem", required = false) String searckText,
                                             @RequestParam(value = "orderby", required = false) String orderby) {
        if (orderby == null) {
            orderby = "asc";
        }
        if (searckText == null) {
            searckText = "";
        }

        /*Tất cả sp*/
        BlogDTO model = new BlogDTO();

        model.setPage(page);
        model.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(blogService.findAllByTitleAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(blogService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        model.setOrderBy(orderby);
        /*End tất cả sp*/

        /*Kiến thức nước hoa*/
        BlogDTO modelKnowledge = new BlogDTO();

        modelKnowledge.setPage(page);
        modelKnowledge.setLimit(limit);
        modelKnowledge.setListResult(blogService.findAllByTitleAndTypeBlogAndOrderBy(pageable, searckText, "Kiến thức nước hoa", orderby));
        modelKnowledge.setTotalItem(blogService.getTotalItemByTypeBlog("Kiến thức nước hoa"));
        modelKnowledge.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        modelKnowledge.setOrderBy(orderby);
        /*End Kiến thức nước hoa*/

        /*Review nước hoa*/
        BlogDTO modelReview = new BlogDTO();

        modelReview.setPage(page);
        modelReview.setLimit(limit);
        modelReview.setListResult(blogService.findAllByTitleAndTypeBlogAndOrderBy(pageable, searckText, "Review nước hoa", orderby));
        modelReview.setTotalItem(blogService.getTotalItemByTypeBlog("Review nước hoa"));
        modelReview.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        modelReview.setOrderBy(orderby);
        /*End Kiến thức nước hoa*/

        ModelAndView mav = new ModelAndView("admin/blog/listBlog");
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        mav.addObject("modelKnowledge", modelKnowledge);
        mav.addObject("modelReview", modelReview);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/blog/chinh-sua-blog", method = RequestMethod.GET)
    public ModelAndView editIncenseGroup(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("admin/blog/editBlog");
        BlogDTO model = new BlogDTO();
        if (id != null) {
            model = blogService.findOneById(id);
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
