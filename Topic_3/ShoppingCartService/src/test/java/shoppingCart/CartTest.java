package shoppingCart;

import org.junit.Assert;
import org.junit.Test;

import shoppingCart.Product;

public class CartTest {
	
	private Cart cartTest;
	private Product productTest;
	private Product productTest2;
	
	public CartTest(){
		this.cartTest = new Cart();
		this.productTest = new Product("ProductName 1", "ProductCategory", 56.99, "ProductDescription");
		this.productTest2 = new Product("ProductName 2", "ProductCategory", 666.66, "ProductDescription");
	}
	
	@Test
	public void whenANewProductIsAddedThenTotalProductsReturnsTotalProductsPlusOne(){
		int totalProducts = cartTest.getTotalItems();
		cartTest.addProduct(productTest);
		Assert.assertEquals(totalProducts + 1, cartTest.getTotalItems());
	}
	
	@Test
	public void whenANewProductIsRemovedThenTotalProductsReturnsTotalProductsMinusOne(){
		cartTest.addProduct(productTest);
		int totalProducts = cartTest.getTotalItems();
		cartTest.deleteProduct(productTest);
		Assert.assertEquals(totalProducts - 1, cartTest.getTotalItems());
	}
	
	@Test
	public void whenAProductIsAddedItGoesOnTopOfTheProductsList(){
		cartTest.addProduct(productTest);
		cartTest.addProduct(productTest2);
		Assert.assertEquals(productTest2, cartTest.getLastProductAdded());
	}
	
	@Test(expected = RuntimeException.class)
	public void whenGettingTheLastProductAddedAndTheCartIsEmptyThenExceptionIsThrown(){	
		cartTest.getLastProductAdded();
	}

}
