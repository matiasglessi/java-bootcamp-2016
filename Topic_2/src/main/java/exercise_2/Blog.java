package exercise_2;

import java.util.ArrayList;
import java.util.Iterator;


public class Blog {
		
		public static final int MAX_ENTRIES_PER_PAGE = 10;
		
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
		
		public Entry getEntry(String title){
			Iterator<Entry> it = entries.iterator();
			while(it.hasNext()){
				Entry entry = it.next();
				if (entry.getTitle()== title)
					return entry;
			}
			return null;
		}
		
		public ArrayList<Entry> getMostRecentEntries(){
			ArrayList<Entry> mostRecentEntries = new ArrayList<Entry>();
			Iterator<Entry> it = entries.iterator();
			if (totalEntries > MAX_ENTRIES_PER_PAGE){
				for (int i = 0; i < MAX_ENTRIES_PER_PAGE; i++) {
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
			if (totalEntries > MAX_ENTRIES_PER_PAGE){
				for (int i = 0; i < MAX_ENTRIES_PER_PAGE; i++) {
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
