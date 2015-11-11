package ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.UserModel;
import domain.User;

@Path("user")
public class UserRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAll")
	public Response findAll(){
		UserModel um = new UserModel();
		return Response.ok().entity(new GenericEntity<List<User>>(um.findAll()){})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTION, HEAD")
				.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{User_id}")
	public Response getUserById(@PathParam("User_id") Short User_id) {
		UserModel um = new UserModel();
		User u = um.get(User_id);
		if(u == null)
			return null;
		return Response.ok().entity(new GenericEntity<User>(u){})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTION, HEAD")
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response createUser(User u) {
		UserModel um = new UserModel();
		um.save(u);
		
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTION, HEAD")
				.build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{User_id}")
	public Response deleteUser(@PathParam("User_id") Short User_id) {
		UserModel um = new UserModel();
		um.delete(um.get(User_id));
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTION, HEAD")
				.build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/edit")
	public Response editUser(User u){
		UserModel um = new UserModel();
		um.update(u);
		
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTION, HEAD")
				.build();
	}
}