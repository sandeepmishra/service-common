package org.webservice.userservice;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.webservice.userbean.UserBean;
import org.webservice.utils.CsvReader;

@Path("/userservice")
@Produces("application/json")
@Service("userService")
public class UserService {

	@GET
    @Path("/userinfo")
    public Response welcomePlayer(@QueryParam("name") String name){
		UserBean bean = new UserBean();
		bean.setFirstName(name);
		bean.setUserEmail("abc.sdf@xyz.com");
		bean.setUserId(new BigDecimal(20));
		return Response.status(200).entity(bean).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/userinfo")
    public Response registerUser(UserBean userBean){
		userBean.setUserId(new BigDecimal("26"));
		return Response.status(200).entity(userBean).build();
	}
	
	@GET
    @Path("/returncsvuser")
    public Response returnCsvUser(){
		List<UserBean> beanList =new CsvReader().csvToList("csv/user.csv");
		return Response.status(200).entity(beanList).build();
	}
}


