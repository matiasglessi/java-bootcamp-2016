package tdd;

import java.util.ArrayList;
import java.util.Iterator;

public class Blog {
	
		private int totalEntries;
		private ArrayList<Entry> entries;
		
		public Blog(){
			this.entries = new ArrayList<Entry>();
			this.totalEntries = 0;
		}
		
		public int getTotalEntries(){
			return this.totalEntries;
		}
		
		public ArrayList<Entry> getEntries(){
			return this.entries;
		}
		
		public void addEntry(Entry entry){
			entries.add(0,entry);
			totalEntries++;
		}
		
		public void deleteLastEntry(){
			entries.remove(0);
			totalEntries--;
		}
		
		public void deleteEntry(Entry entry){
			entries.remove(entry);
			totalEntries--;
		}
		
		public ArrayList<Entry> getMostRecentEntries(){
			ArrayList<Entry> mostRecentEntries = new ArrayList<Entry>();
			Iterator<Entry> it = entries.iterator();
			if (totalEntries > 10){
				for (int i = 0; i <= 9; i++) {
					Entry entry = it.next();
					mostRecentEntries.add(entry);
				}
			}
			else
				while(it.hasNext()){
					Entry entry = it.next();
					mostRecentEntries.add(entry);
				}				
			return mostRecentEntries;
		}
		
		public void showMostRecentEntries(){
			Iterator<Entry> it = entries.iterator();
			if (totalEntries > 10){
				for (int i = 0; i <= 9; i++) {
					Entry entry = it.next();
					entry.showEntry();
				}
			}
			else
				while(it.hasNext()){
					Entry entry = it.next();
					entry.showEntry();
				}				
		}
}
