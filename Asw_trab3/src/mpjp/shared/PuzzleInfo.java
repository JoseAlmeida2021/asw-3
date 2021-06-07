package mpjp.shared;

import java.io.Serializable;

/**
 * 	Information required to create a jigsaw puzzle.
 */
public class PuzzleInfo extends Object implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Number of columns in the puzzle
	 */
	private int columns;
	/**
	 * Name of the cutting used for producing pieces
	 */
	private String cuttingName;
	/**
	 * Height of the jigsaw puzzle
	 */
	private double height;
	/**
	 * Name of the file with the jigsaw puzzle's background
	 */
	private String imageName;
	/**
	 * Number of rows in the puzzle
	 */
	private int rows;
	/**
	 * Width of the jigsaw puzzle
	 */
	private double width;
	
	/**
	 * Constructor
	 */
	public PuzzleInfo() {
		
	}
	
	/**
	 * Constructor
	 */
	public PuzzleInfo(String imageName,
					  String cuttingName, 
					  int rows, 
					  int columns, 
					  double width, 
					  double height) {
		this.columns = columns;
		this.cuttingName = cuttingName;
		this.height = height;
		this.imageName = imageName;
		this.rows = rows;
		this.width = width;
	}
	
	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	/**
	 * @return the cuttingName
	 */
	public String getCuttingName() {
		return cuttingName;
	}

	/**
	 * @param cuttingName the cuttingName to set
	 */
	public void setCuttingName(String cuttingName) {
		this.cuttingName = cuttingName;
	}
	
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
}
