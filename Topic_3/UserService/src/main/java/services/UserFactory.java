package services;

import entities.UserData;

public class UserFactory {
	
	private UserFactory() {}  
	  
    public static UserService getLocalService(){  
        return new UserData ();  
    }  
  
    public static UserService getRemoteServiceUsingJms(){  
        return new UserServiceProxy (new UserServiceJmsClient());  
    }  
  
    public static UserService getRemoteServiceUsingWebService(){  
        return new UserServiceProxy (new UserServiceWebServiceClient());  
    }  
}  

