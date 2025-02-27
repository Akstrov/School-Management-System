package dao.evaluation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Domaine.classe.Classe;
import Domaine.classe.ClasseGenerique;
import Domaine.matiere.ClasseGUnite;
import Domaine.matiere.ConfigurationMatiere;
import Domaine.matiere.ConfigurationModule;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;
import dao.database.Db;

public class UniteModuleMatiereDAO {
	private Connection con;
	public  UniteModuleMatiereDAO() {
		this.con = Db.getInstance().con;
	}
	
	public ArrayList<ConfigurationModule> getByMatiere (Matiere m) throws SQLException{
		String query="SELECT `module`.`ID`, `module`.`Code`,`module`.`nom_Fr` ,matiere.ID as matId\r\n"
				+ "FROM `module` \r\n"
				+ "	,matiere\r\n"
				+ "	, `configurationmatiere`, `configurationmodule` where `configurationmatiere`.`MatiereID` = `matiere`.`ID` \r\n"
				+ "	and   `configurationmodule`.`ConfigurationMatiereID` = `configurationmatiere`.`ID` and `configurationmodule`.moduleID =module.ID and matiere.ID=? ;";
				
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, m.getId());
		ResultSet rs = statement.executeQuery();
		ArrayList<ConfigurationModule> md = new ArrayList();
		while (rs.next()) {
			ConfigurationModule cmd=new ConfigurationModule();
			ConfigurationMatiere  cmt=new ConfigurationMatiere();
			Matiere matiere = new Matiere();
			matiere.setId(rs.getInt("matId"));
		
			cmt.setMatiere(matiere);
			cmd.setConfigurationMatiere(cmt);
			Module module=new Module();
			module.setId(rs.getInt("ID"));
			module.setCode(rs.getString("Code"));
			module.setNom_Fr(rs.getString("nom_Fr"));
			cmd.setModule(module);
			
			
			
			md.add(cmd);
			
			
			
		}
		rs.close();
		statement.close();
		return md;	
	}

}