package net.jcip.examples.ch03;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Animals {

	Ark ark;
	Species species;
	Gender gender;
	
	public int loadTheArk(Collection<Animal> candidates) {
		
		SortedSet<Animal> animals;
		int numPairs = 0;
		Animal candidate = null;
		
		animals = new TreeSet<>(new SpeciesGenderComparator());
		animals.addAll(candidates);
		
		for(Animal a : candidates) {
			if(candidate == null || !candidate.isPotentialMate(a)) {
				candidate = a;
			}
			else {
				ark.load(new AnimalPair(candidate,a));
				numPairs ++;
				candidate = null;
			}
		}
		return numPairs;
	}
	
	
	
	class Animal {
		Species species;
		Gender gender;
		
		public boolean isPotentialMate(Animal other) {
			return species == other.species && gender != other.gender;
		}
		
	}
	
	enum Species {
		AARDVARK, BENGAL_TIGER, CARIBOU, DINGO, ELEPHANT, FROG, GNU, HYENA,
        IGUANA, JAGUAR, KIWI, LEOPARD, MASTADON, NEWT, OCTOPUS,
        PIRANHA, QUETZAL, RHINOCEROS, SALAMANDER, THREE_TOED_SLOTH,
        UNICORN, VIPER, WEREWOLF, XANTHUS_HUMMINBIRD, YAK, ZEBRA
	}
	
	enum Gender {
		MALE,FEMALE
	}
	
	class AnimalPair {
		private final Animal one, two;
		
		public AnimalPair(Animal one, Animal two) {
			this.one = one;
			this.two = two;
		}
	}
	
	class SpeciesGenderComparator implements Comparator<Animal> {

		@Override
		public int compare(Animal one, Animal two) {
			int speciesCompare = one.species.compareTo(two.species);
			
			return speciesCompare != 0 ? speciesCompare :
				one.gender.compareTo(two.gender);
		}
	}
	
	class Ark {
		private final Set<AnimalPair> loadedAnimals = new HashSet<>();
		
		public void load(AnimalPair pair) {
			loadedAnimals.add(pair);
		}
	}
}
