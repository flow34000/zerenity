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

import domain.*;
import model.*;

@Path("products")
public class ProductRestful {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() throws IllegalArgumentException, Exception{
		ProductModel pm = new ProductModel();
		return Response.ok().entity(new GenericEntity<List<Product>>(pm.findAll()){})
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProduct(Product p) throws Exception {
		ProductModel pm = new ProductModel();
		pm.save(p);
		
		return Response.ok()
				.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{product_id}")
	public Response getProductById(@PathParam("product_id") Short product_id) throws Exception {
		ProductModel pm = new ProductModel();
		Product p = pm.get(product_id);
		if(p == null)
			return null;
		return Response.ok().entity(new GenericEntity<Product>(p){})
				.build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{product_id}")
	public Response editProduct(Product p) throws Exception{
		ProductModel pm = new ProductModel();
		pm.update(p);
		
		return Response.ok()
				.build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{product_id}")
	public Response deleteProduct(@PathParam("product_id") Short product_id) throws Exception {
		ProductModel pm = new ProductModel();
		pm.delete(pm.get(product_id));
		return Response.ok()
				.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/categories")
	public Response findAllCategories() throws IllegalArgumentException, Exception {
		ProductCategoryModel pcm = new ProductCategoryModel();
		return Response.ok().entity(new GenericEntity<List<ProductCategory>>(pcm.findAll()){})
				.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/categories/{category_id}")
	public Response getCategoryById(@PathParam("category_id") Short category_id) throws Exception {
		ProductCategoryModel pcm = new ProductCategoryModel();
		ProductCategory pc = pcm.get(category_id);
		if(pc == null)
			return null;
		return Response.ok().entity(new GenericEntity<ProductCategory>(pc){})
				.build();
	}
}
