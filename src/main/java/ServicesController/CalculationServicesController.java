package ServicesController;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entities.Calculation;
import Services.CalculaionServices;

@Stateless
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationServicesController {
	
	
	@PersistenceContext(unitName = "hello")
	private EntityManager em;

	
	@EJB
	private CalculaionServices calc = new CalculaionServices();
	
	private ArrayList<Calculation> calculations = new ArrayList<Calculation>();
	
	
	
	@POST
	@Path("/calc")
	public int calculate(Calculation calculation) 
	{
		em.persist(calculation);
		return calc.calculate(calculation);
	}
	
	
	@GET
	@Path("/calculations")
	public ArrayList<Calculation> getAllCalculations()
	{
		Query query = em.createQuery("Select c from Calculation c");
		calculations=(ArrayList<Calculation>) query.getResultList();
		return calculations;
		
	}
	

}
