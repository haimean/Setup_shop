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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
         request.getRequestDispatcher("./user/blog/blogdetails.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

}
