package ru.slobevg.ws;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ru.slobevg.model.Response;

@Endpoint
public class UserEndpoint {

	private static final String namespaceUri = "http://ru.slobevg/schemas";
	
	private UserService userService;
	
	@Autowired
	public UserEndpoint(UserService userService) throws JDOMException {
		this.userService = userService;
	}
	
	@PayloadRoot(namespace = namespaceUri, localPart = "user")
	@ResponsePayload
	public Response handleUser(@RequestPayload Element user) throws JDOMException {
		Response response = new Response();
		response.setName(userService.reverse(user.getChild("name").getValue()));
		return response;
	}
}
