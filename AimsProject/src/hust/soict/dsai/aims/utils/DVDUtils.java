package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DVDUtils {
	// Compare 2 dvds by cost
	public static int compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		/*
		 * Return 1 if dvd1 costs more
		 * Return 0 if 2 dvd have the same cost
		 * Return -1 if dvd2 costs more
		 */
		if (dvd1.getCost() > dvd2.getCost()) return 1;
		else if (dvd1.getCost() == dvd2.getCost()) return 0;
		else return -1;
	}
	
	// Compare 2 dvds by title alphabetically
	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		/*
		 * Return 1 if dvd1 comes before dvd2
		 * Return 0 if 2 dvd have the same title
		 * Return -1 if dvd2 comes before dvd1
		 */
		if (dvd1.getTitle().compareTo(dvd2.getTitle()) < 0) return 1;
		else if (dvd1.getTitle().compareTo(dvd2.getTitle()) == 0) return 0;
		else return -1;
	}
	
	// Sort list of dvds by cost
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
		DigitalVideoDisc temp;
		for (int i = 0; i < dvdList.length; i++) {
			for (int j = i + 1; j < dvdList.length; j++) {
				if (compareByCost(dvdList[i], dvdList[j]) == -1) {
					temp = dvdList[i];
					dvdList[i] = dvdList[j];
					dvdList[j] = temp;
				}
			}
		}
		return dvdList;
	}
	
	// Sort list of dvds by title alphabetically
		public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
			DigitalVideoDisc temp;
			for (int i = 0; i < dvdList.length; i++) {
				for (int j = i + 1; j < dvdList.length; j++) {
					if (compareByTitle(dvdList[i], dvdList[j]) == -1) {
						temp = dvdList[i];
						dvdList[i] = dvdList[j];
						dvdList[j] = temp;
					}
				}
			}
			return dvdList;
		}
}
