package in.shubha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shubha.Util.jdbcUtil;


@WebServlet("/Register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SqlInsertQuery = "insert into student1 values(?,?,?)";


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sname=request.getParameter("sname");
		String saddr=request.getParameter("saddr");
		String sage=request.getParameter("sage");
		
		PrintWriter out=response.getWriter();
			
		Connection connection=null;
		PreparedStatement psmt=null;
		
		try {
			connection=jdbcUtil.getDbConnection();
			psmt=connection.prepareStatement(SqlInsertQuery);
			
			psmt.setString(1, sname);
			psmt.setString(2, saddr);
			psmt.setString(3, sage);
			out.println("<html><head><title>Response</html></head></title>");
			
			int x=psmt.executeUpdate();
			
			if(x==1) {
				out.println("<body <h1 style='color:green;text-align:center;'>RECORD INSERT SUCCESSFULLY</body>");
			}else {
				out.println("<body <h1 style='color:red;text-align:center;'>RECORD INSERT FAILED</body>");
			}
			out.println("</html>");
			
			out.close();

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.closeResources(null, psmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
