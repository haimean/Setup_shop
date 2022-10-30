/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.BlogDaoImpl;
import Dao.Impl.UserDaoImpl;
import Model.AddressReceiver;
import Model.Blog;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class UserBlogDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
       //lay ra thong tin user
        UserDaoImpl daoUser = new UserDaoImpl();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
      
//        AddressReceiver userInformation = daoUser.getUserById(u.getId());
        
        
        
        //lay ra list top 3 popular blog va blog detail voi id da lay duoc
        int id = Integer.parseInt(request.getParameter("id"));
        BlogDaoImpl daoB = new BlogDaoImpl();
        Blog b = daoB.get(id);
        Blog bRemove = null;
        ArrayList<Blog> listB = daoB.getTop3Blog();
        for (Blog blog : listB) {
            if(b.getId() == blog.getId()){
                bRemove = blog;
            }
        }
        listB.remove(bRemove);
        if(listB.size() > 3){
            listB.remove(3);
        }
        request.setAttribute("listB", listB);
        request.setAttribute("blog", b);
//        request.setAttribute("userInformation", userInformation);
        request.setAttribute("lstzsize", listB.size() - 1);
         request.getRequestDispatcher("blogdetails.jsp").forward(request, response);
    }

    

}
