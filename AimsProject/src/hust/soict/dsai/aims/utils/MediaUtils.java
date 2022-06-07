package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.media.Media;

public class MediaUtils {
	// Compare 2 medias by cost
	public static int compareByCost(Media media1, Media media2) {
		/*
		 * Return 1 if media1 costs more
		 * Return 0 if 2 media have the same cost
		 * Return -1 if media2 costs more
		 */
		if (media1.getCost() > media2.getCost()) return 1;
		else if (media1.getCost() == media2.getCost()) return 0;
		else return -1;
	}
	
	// Compare 2 medias by title alphabetically
	public static int compareByTitle(Media media1, Media media2) {
		/*
		 * Return 1 if media1 comes before media2
		 * Return 0 if 2 media have the same title
		 * Return -1 if media2 comes before media1
		 */
		if (media1.getTitle().compareTo(media2.getTitle()) < 0) return 1;
		else if (media1.getTitle().compareTo(media2.getTitle()) == 0) return 0;
		else return -1;
	}
	
	// Sort list of media(s) by cost
	public static Media[] sortByCost(Media[] mediaList) {
		Media temp;
		for (int i = 0; i < mediaList.length; i++) {
			for (int j = i + 1; j < mediaList.length; j++) {
				if (compareByCost(mediaList[i], mediaList[j]) == -1) {
					temp = mediaList[i];
					mediaList[i] = mediaList[j];
					mediaList[j] = temp;
				}
			}
		}
		return mediaList;
	}
	
	// Sort list of media(s) by title alphabetically
		public static Media[] sortByTitle(Media[] mediaList) {
			Media temp;
			for (int i = 0; i < mediaList.length; i++) {
				for (int j = i + 1; j < mediaList.length; j++) {
					if (compareByTitle(mediaList[i], mediaList[j]) == -1) {
						temp = mediaList[i];
						mediaList[i] = mediaList[j];
						mediaList[j] = temp;
					}
				}
			}
			return mediaList;
		}
}
