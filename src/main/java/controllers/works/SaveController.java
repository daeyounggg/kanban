package controllers.works;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.works.SaveService;
import models.works.WorkServiceManager;

import java.io.IOException;
import java.io.PrintWriter;

public class SaveController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        String URI = req.getRequestURI();
        String mode = URI.indexOf("edit") != -1 ? "edit" : "add";

        String[] addScript = { "ckeditor/ckeditor", "work/form" };
        req.setAttribute("addScript",addScript);

        ViewUtils.load(req, resp,"works", mode);
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {
        SaveService saveService = WorkServiceManager.getInstance().saveService();
        try{
            saveService.save(req);

        }catch (Exception e){
            try {
                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.printf("<script>alert('%s');</script>",e.getMessage());
            }catch (IOException e2) {
                e.printStackTrace();
            }
        }
    }
}