package exercise_2;

import org.junit.Assert;
import org.junit.Test;


public class BlogTest {
	
	private Blog blogTest;
	private Entry entryTest;
	
	public BlogTest(){
		this.blogTest = new Blog();
		this.entryTest = new Entry("Entry Test", "This is the body", "category");	
	}
	
	@Test
	public void whenTheEntriesListHasLessThanTenEntriesThenReturnTheTotalEntries(){
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		Assert.assertEquals(2, blogTest.getMostRecentEntries().size());
	}

	@Test
	public void whenTheEntriesListHasTenOrMoreEntriesThenReturnLastTenEntries(){
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		blogTest.addEntry(entryTest);
		Assert.assertEquals(10, blogTest.getMostRecentEntries().size());
	}
	
	@Test
	public void whenTheEntriesListHasNoEntriesThenReturnNothing(){
		Assert.assertEquals(0, blogTest.getMostRecentEntries().size());
	}
	
	@Test
	public void whenAnEntryIsAddedThenTheEntriesListBecomesEntriesPlusOne() {
		int totalEntries = blogTest.getTotalEntries();
		blogTest.addEntry(entryTest);
		Assert.assertEquals(totalEntries + 1, blogTest.getTotalEntries());
	}
	
	@Test
	public void whenAnEntryIsDeletedThenTheEntriesListBecomesEntriesMinusOne() {
		blogTest.addEntry(entryTest);
		int totalEntries = blogTest.getTotalEntries();
		blogTest.deleteLastEntry();
		Assert.assertEquals(totalEntries - 1, blogTest.getTotalEntries());
	}
	
	@Test
	public void wheAParticularEntryIsDeletedThenTheEntriesListBecomesEntriesMinusOne() {
		blogTest.addEntry(entryTest);
		int totalEntries = blogTest.getTotalEntries();
		blogTest.deleteEntry(entryTest);
		Assert.assertEquals(totalEntries - 1, blogTest.getTotalEntries());
	}

	
		
	@Test(expected = RuntimeException.class)
	public void whenAnEntryIsDeletedAndTheEntriesListIsEmptyThenExceptionIsThrown(){	
		blogTest.deleteLastEntry();
	}
	
	
	
}