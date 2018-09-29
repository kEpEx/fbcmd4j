package org.fbcmd4j.aaguirre;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

public class LinkService {

	AccessToken token = null;
	
	public void Post(String text)
	{

		Facebook facebook = new FacebookFactory().getInstance();
		
		String appId = "324811234937602";
		String appSecret = "";
		
		String commaSeparetedPermissions = "user_posts,publish_actions";
		
		facebook.setOAuthAppId(appId, appSecret);
		facebook.setOAuthPermissions(commaSeparetedPermissions);
		
		
		AccessToken token = null;
		
		try {
			System.out.println("Obteniendo Token");
			token = facebook.getOAuthAppAccessToken();
			System.out.println(token);
		} catch (FacebookException e) {
			System.out.println("Error Obteniendo Token");
			e.printStackTrace();
		}
		
		facebook.setOAuthAccessToken(token);
		try {
			System.out.println("Obteniendo Token");
			token = facebook.getOAuthAppAccessToken();
			System.out.println(token);
		} catch (FacebookException e) {
			System.out.println("Error Obteniendo Token");
			e.printStackTrace();
		}
		
		facebook.setOAuthAccessToken(token);
		
		try {
			System.out.println("Nuevo Post");
			facebook.postStatusMessage("Hello World from Java");
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
