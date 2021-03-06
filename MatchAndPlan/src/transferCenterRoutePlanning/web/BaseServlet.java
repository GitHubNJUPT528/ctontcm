package transferCenterRoutePlanning.web;

import transferCenterRoutePlanning.Util.LatLng;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String action =  req.getParameter("action");
         //使用反射解析请求的参数 以唤醒执行对应的方法
            try {
                Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
                method.invoke(this,req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

}