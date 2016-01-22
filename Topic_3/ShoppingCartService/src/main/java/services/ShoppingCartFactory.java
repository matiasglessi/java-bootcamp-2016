package services;

import shoppingCart.Cart;

public class ShoppingCartFactory {
	
	private ShoppingCartFactory() {}  
	  
    public static ShoppingCartService getLocalService(){  
        return new Cart ();  
    }  
  
    public static ShoppingCartService getRemoteServiceUsingJms(){  
        return new ShoppingCartServiceProxy (new ShoppingCartServiceJmsClient());  
    }  
  
    public static ShoppingCartService getRemoteServiceUsingWebService(){  
        return new ShoppingCartServiceProxy (new ShoppingCartServiceWebServiceClient());  
    }  
}  

