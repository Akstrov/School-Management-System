package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.evaluation.ControleDAO;

public class ControleDAOTest {
	private static ControleDAO controleDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controleDAO = new ControleDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testControleDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		try {
			assertNotNull(controleDAO.getAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetByProfByClass() {
		try {
			assertNotNull(controleDAO.getByProfByClass(2, 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

}