package net.jcip.examples.ch03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import net.jcip.annotations.Immutable;

@Immutable
public class ThreeStooges {

	private final Set<String> stooges = new HashSet<>();
	
	public ThreeStooges() {
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}
	
	public boolean isStooge(String name) {
		return stooges.contains(name);
	}
	
	public String getStoogNames() {
		List<String> stooges = new Vector<String>();
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
		
		return stooges.toString();
	}
}
