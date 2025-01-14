package controllers.evaluation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.matiere.ConfigurationModule;
import Domaine.matiere.Matiere;
import dao.evaluation.UniteModuleMatiereDAO;

/**
 * Servlet implementation class ModuleByMatiereList
 */
@WebServlet("/ModuleByMatiere/List")
public class ModuleByMatiereList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UniteModuleMatiereDAO mbm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleByMatiereList() {
        super();
        // TODO Auto-generated constructor stub
        mbm = new UniteModuleMatiereDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ConfigurationModule> cfm= new ArrayList();
		int matiereId=Integer.parseInt(request.getParameter( "matiereId"));
		//int matiereId = 9;
	    Matiere mt = new Matiere();
		mt.setId(matiereId);
		try {
			cfm = mbm.getByMatiere(mt);
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(cfm).toString();
			System.out.println(json);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
