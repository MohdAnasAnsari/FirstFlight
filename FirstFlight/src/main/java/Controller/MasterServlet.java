package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Flight;
import models.Passenger;
import transferobjectaccess.FlightDAO;
import transferobjectaccess.PassengerDAO;

@WebServlet("/")
public class MasterServlet extends HttpServlet {

	private FlightDAO ob;
	private Flight f;
	private PassengerDAO ob1;
	private Passenger p;
	private int num;
	private String pd = null;
	private int count;
	private List<Passenger> list1;

	private static final long serialVersionUID = 1L;

	public void init() {

		ob = new FlightDAO();
		ob1 = new PassengerDAO();
		pd = "admin";
		count = 0;
		list1 = null;
		
	}

	public MasterServlet() {
		count = 0;
		list1 = null;
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {

			case "/add":
				showNewForm(request, response);
				break;
			case "/delete":
				deleteDetails(request, response);
				break;
			case "/edit":
				EditDetails(request, response);
				break;
			case "/insert":
				insertDetails(request, response);
				break;
			case "/update":
				updateDetails(request, response);
				break;
			case "/reset":
				changePassword(request, response);
				break;
			case "/register":
				register(request, response);
				break;
			case "/storage":
				storage(request, response);
				break;
			case "/find":
				getflightDetailsById(request, response);
				break;
			case "/login":
				login(request, response);
				break;
			case "/passenger":
				passengerFlightDetails(request, response);
				break;
			case "/insertPassenger":
				count++;
				passengerInsertDetails(request, response);
				break;
			case "/deletePassenger":
				count--;
				passengerDeleteDetails(request, response);
				break;
			case "/booking":
				BookingDetails(request, response);
				break;
			default:
				showAllDetails(response, request);
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void BookingDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Passenger> list = ob1.getAllDetails();
		list1 = list;
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("RegisterPage.jsp");
		rd.forward(request, response);

	}

	private void passengerInsertDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {

		if (count > num)
			response.sendRedirect("HomePage.jsp");
		else {

			String fname = request.getParameter("fname");
			String flname = request.getParameter("lname");
			long contact = Long.parseLong(request.getParameter("contact"));
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			Passenger p = new Passenger(fname, flname, age, contact, email);
			ob1.insertPassengerInDB(p);
			response.sendRedirect("booking");
		}

	}

	private void passengerDeleteDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Passenger p = ob1.getPassengerById(id);
		ob1.deletePassenger(p);
		response.sendRedirect("booking");

	}

	private void EditDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("fid"));
		Flight f = ob.getFlightById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddFlight.jsp");
		request.setAttribute("f", f);
		dispatcher.forward(request, response);

	}

	private void updateDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int fid = Integer.parseInt(request.getParameter("fid"));
		int fnumber = Integer.parseInt(request.getParameter("fnumber"));
		String fname = request.getParameter("fname");
		String forigin = request.getParameter("forigin");
		String ftarget = request.getParameter("ftarget");
		String date = request.getParameter("fdate");
		float fprice = Float.parseFloat(request.getParameter("fprice"));
		Flight fl = new Flight(fid, fnumber, fname, forigin, ftarget, date, fprice);
		ob.updateFlight(fl);
		response.sendRedirect("view");

	}

	private void deleteDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		int id = Integer.parseInt(req.getParameter("fid"));
		Flight f = ob.getFlightById(id);
		ob.deleteFlight(f);
		resp.sendRedirect("view");

	}

	private void showAllDetails(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		List<Flight> list = ob.getAllDetails();
		System.out.println(list);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("FlightDetails.jsp");
		rd.forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("AddFlight.jsp");
		rd.forward(request, response);

	}

	private void insertDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int fnumber = Integer.parseInt(request.getParameter("fnumber"));
		String fname = request.getParameter("fname");
		String forigin = request.getParameter("forigin");
		String ftarget = request.getParameter("ftarget");
		String date = request.getParameter("fdate");
		float fprice = Float.parseFloat(request.getParameter("fprice"));
		Flight fl = new Flight(fnumber, fname, forigin, ftarget, date, fprice);
		ob.insertFlightInDB(fl);
		response.sendRedirect("view");

	}

	private void passengerFlightDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String origin = request.getParameter("origin");
		String target = request.getParameter("target");
		String date = request.getParameter("date");
		num = Integer.parseInt(request.getParameter("qty"));

		List<Flight> list = ob1.getAllDetailsByOriginDate(origin, date, target);
		count = 0;
		request.setAttribute("Selectedlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("PassengerFlights.jsp");
		rd.forward(request, response);

	}

	private void getflightDetailsById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("fid"));
		FlightDAO x = new FlightDAO();
		f = x.getFlightById(id);
		RequestDispatcher rd = request.getRequestDispatcher("booking");
		rd.forward(request, response);

	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (count != 0) {
			ob.relation(f, list1);
			request.setAttribute("n", num);
			request.setAttribute("f", f);
			RequestDispatcher rd = request.getRequestDispatcher("SummaryPage.jsp");
			rd.forward(request, response);
		} else
			response.sendRedirect("HomePage.jsp");

	}

	private void storage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ob1.insertPassengerInDB(p);
		response.sendRedirect("HomePage.jsp");

	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String newpwd = request.getParameter("newpwd");
		String confpwd = request.getParameter("confpwd");

		if (newpwd.compareTo(confpwd) == 0) {
			pd = newpwd;
			response.sendRedirect("AdminLogin.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("ResetPage.jsp");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<center> <span style='color:red'> Invalid Credentials!!! </span></center>");
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		RequestDispatcher rd = null;

		if (email.equalsIgnoreCase("admin@test.com") && pwd.equals(pd)) {
			rd = request.getRequestDispatcher("view");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("AdminLogin.jsp");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<center> <span style='color:red'> Invalid Credentials!!! </span></center>");
		}

	}

}
