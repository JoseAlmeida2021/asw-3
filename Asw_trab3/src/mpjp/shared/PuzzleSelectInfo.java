package mpjp.shared;

import java.io.Serializable;
import java.util.Date;

//import mpjp.shared.PuzzleInfo;

/**
 * Information required to select a puzzle currently being solved.
 */
public class PuzzleSelectInfo extends PuzzleInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Percentage of the puzzle solved ([0, 100])
	 */
	private int percentageSolved;
	/**
	 * Moment when the jigsaw puzzle started being solved
	 */
	private Date start;
	
	/**
	 * Creates an instance from a puzzle view and start date and percentage solved
	 * 
	 * @param info - used to create the workspace
	 * start - date/time when this puzzle started being solved
	 * percentageSolved - percentage [0, 100] off the puzzle already solved
	 */

	public PuzzleSelectInfo(PuzzleInfo info,int percentageSolved, Date start){
		super();
		this.percentageSolved = percentageSolved;
		this.start = start;
	}
	
	public PuzzleSelectInfo(){}
	
	
	/**
	 * The moment when the puzzle start being solved
	 * 
	 * @return start date
	 */
	public Date getStart() {
		return start;
	}
	
	/**
	 * Percentage of the puzzle that is solved, an integer in [0,100]
	 * 
	 * @return percentage
	 */
	public int getPercentageSolved() {
		return percentageSolved;
	}

}
