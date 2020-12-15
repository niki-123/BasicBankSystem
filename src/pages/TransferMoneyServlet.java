package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransactionDaoImpl;

/**
 * Servlet implementation class TransferMoneyServlet
 */
@WebServlet("/transferMoneyServlet")
public class TransferMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in transfer money servlet");
		String[] toCustomers = request.getParameterValues("customers[]");
		int amount=Integer.parseInt(request.getParameter("amount"));
		int fromCust=Integer.parseInt(request.getParameter("fromCustid"));
		
		List<String> toCust=Arrays.asList(toCustomers);
		
		TransactionDaoImpl tdao=new TransactionDaoImpl();
		tdao.addTransaction(fromCust, toCust, amount);
		
		response.sendRedirect("redirect.jsp");
	}

}
