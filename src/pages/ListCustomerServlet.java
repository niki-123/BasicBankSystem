package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;
import pojos.Customer;


/**
 * Servlet implementation class listFlowerServlet
 */
@WebServlet("/listCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CustomerDaoImpl cdao;
   
   
      
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			System.out.println("in list customer");
		  cdao=new CustomerDaoImpl();
		HttpSession hs=request.getSession();

		List<Customer> list=new ArrayList<Customer>();
		list=cdao.displayCustomers();
        hs.setAttribute("flist", list);
      

		response.sendRedirect("listCustomer.jsp");
		}catch (Exception e) {
		e.printStackTrace();
		}
	
	}

}
