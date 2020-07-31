package com.gemstones.controller.web;

import com.gemstones.dto.BlogDTO;
import com.gemstones.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "blogControllerOfWeb")
public class ListBlogController extends BaseController {

    @Autowired
    private IBlogService blogService;


    @RequestMapping(value = "/danh-sach-bai-viet", method = RequestMethod.GET)
    public ModelAndView listBlog(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                    @RequestParam(value = "tra-cuu", required = false) String searckText,
                                    HttpServletRequest req) {
        String orderby = "asc";
        if (searckText == null || searckText == ""){
            searckText = "";
        }

        BlogDTO model = new BlogDTO();
        model.setPage(page);
        model.setLimit(limit);

        Pageable pageable = new PageRequest(page - 1, limit);

        model.setListResult(blogService.findAllByTitleAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(blogService.getTotalItem());
        String title = "";
        if (searckText != "")
        {
            if (model.getListResult().size() > 0) {
                title = "Kết quả tìm kiếm cho <strong>" + searckText + "</strong>";
            } else {
                title = "Không tìm thấy kết quả nào";
            }
        }
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        mav.setViewName("web/listBlog");

        mav.addObject("title", title);
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/danh-sach-bai-viet-kien-thuc-nuoc-hoa", method = RequestMethod.GET)
    public ModelAndView listBlogKnowledge(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                 @RequestParam(value = "tra-cuu", required = false) String searckText,
                                 HttpServletRequest req) {
        String orderby = "asc";
        if (searckText == null || searckText == ""){
            searckText = "";
        }

        BlogDTO model = new BlogDTO();
        model.setPage(page);
        model.setLimit(limit);

        Pageable pageable = new PageRequest(page - 1, limit);

        model.setListResult(blogService.findAllByTitleAndTypeBlogAndOrderBy(pageable, searckText,"Kiến thức nước hoa", orderby));
        model.setTotalItem(blogService.getTotalItemByTypeBlog("Kiến thức nước hoa"));
        String title = "";
        if (searckText != "")
        {
            if (model.getListResult().size() > 0) {
                title = "Kết quả tìm kiếm cho <strong>" + searckText + "</strong>";
            } else {
                title = "Không tìm thấy kết quả nào";
            }
        }
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        mav.setViewName("web/listBlog");

        mav.addObject("title", title);
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/danh-sach-bai-viet-review-nuoc-hoa", method = RequestMethod.GET)
    public ModelAndView listBlogReview(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                 @RequestParam(value = "tra-cuu", required = false) String searckText,
                                 HttpServletRequest req) {
        String orderby = "asc";
        if (searckText == null || searckText == ""){
            searckText = "";
        }

        BlogDTO model = new BlogDTO();
        model.setPage(page);
        model.setLimit(limit);

        Pageable pageable = new PageRequest(page - 1, limit);

        model.setListResult(blogService.findAllByTitleAndTypeBlogAndOrderBy(pageable, searckText,"Review nước hoa", orderby));
        model.setTotalItem(blogService.getTotalItemByTypeBlog("Review nước hoa"));
        String title = "";
        if (searckText != "")
        {
            if (model.getListResult().size() > 0) {
                title = "Kết quả tìm kiếm cho <strong>" + searckText + "</strong>";
            } else {
                title = "Không tìm thấy kết quả nào";
            }
        }
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        mav.setViewName("web/listBlog");

        mav.addObject("title", title);
        mav.addObject("model", model);
        return mav;
    }

}
