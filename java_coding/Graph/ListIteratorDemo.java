// java program to show the usage of listIterator

import java.util.*;

public class ListIteratorDemo {
	public static void main(String[] args)
	{
		// create a list of names
		List<String> names = new LinkedList<>();
		names.add("Welcome");
		names.add("To");
		names.add("Gfg");

		// Getting ListIterator
		ListIterator<String> namesIterator
			= names.listIterator();

		// Traversing elements
		while (namesIterator.hasNext()) {
			System.out.println(namesIterator.next());
		}

		// for-each loop creates Internal Iterator here.
		for (String s : names) {
			System.out.println(s);
		}
	}
}
