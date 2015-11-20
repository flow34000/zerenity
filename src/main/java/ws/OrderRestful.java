package ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.*;
import model.*;

@Path("orders")
public class OrderRestful {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() throws IllegalArgumentException, Exception{
		OrderModel om = new OrderModel();
		return Response.ok().entity(new GenericEntity<List<Userorder>>(om.findAll()){})
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createOrder(Userorder o) throws Exception {
		OrderModel om = new OrderModel();
		om.save(o);
		
		return Response.ok()
				.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{order_id}")
	public Response getOrderById(@PathParam("order_id") Short order_id) throws Exception {
		OrderModel om = new OrderModel();
		Userorder o = om.get(order_id);
		if(o == null)
			return null;
		return Response.ok().entity(new GenericEntity<Userorder>(o){})
				.build();
	}
}
