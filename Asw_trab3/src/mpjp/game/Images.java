package mpjp.game;

import java.io.File;

import java.util.HashSet;
import java.util.Set;

public class Images extends Object {
	

	private static final String DEFAULT_PATH = "test/mpjp/resources";
	private static final String DEFAULT_EXT = "jpg";
	
	private static Set<String> extensions = new HashSet<String>();
	
	private static File imageDirectory ;
	
	
	/**
	 * .........
	 * 
	 * @return -----
	 */
	public static File getImageDirectory() {
		return imageDirectory;
	}
	
	/**
	 * .........
	 * 
	 * @return -----
	 */
	public static void setImageDirectory(File imageDirectory) {
		Images.imageDirectory = imageDirectory;
	}
	
	/**
	 * .........
	 * 
	 * @return -----
	 */
	public static Set<String> getExtensions() {
				
		if (extensions == null || extensions.isEmpty()) {
			extensions= new HashSet<String>();
			extensions.add(DEFAULT_EXT);
		}
		return extensions;
	}
	
	/**
	 * .........
	 * 
	 * @return -----
	 */
	public static void addExtensions(String extension) {
		Images.extensions.add(extension);
	}
	
	/**
	 * .........
	 * 
	 * @return -----
	 */
	static Set<String> getAvailableImages() {
		
		if (imageDirectory == null) {
			imageDirectory = new File(DEFAULT_PATH);
		}

		
		Set<String> images = new HashSet<>();
		
		for (String extension : extensions) {
			for (String file : imageDirectory.list()) {
				if (file.contains(extension)) {
					images.add(file);
				}
			}
		}
		return images;


	}
	
	
	
}