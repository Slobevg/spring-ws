package ru.slobevg;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class UserEndpoint {

	private UserService userService;
	private XPath nameExpression;
	
	@Autowired
	public UserEndpoint(UserService userService) throws JDOMException {
		this.userService = userService;
		
		Namespace namespace = Namespace.getNamespace("", "http://slobevg.ru/user/schemas");
		nameExpression = XPath.newInstance("//name");
		nameExpression.addNamespace(namespace);
	}
	
	@PayloadRoot(namespace = "http://slobevg.ru/user/schemas", localPart = "UserRequest")
	public String handleUserRequest(@RequestPayload Element userRequest) throws JDOMException {
		return userService.reverse(nameExpression.valueOf(userRequest));
	}
}
