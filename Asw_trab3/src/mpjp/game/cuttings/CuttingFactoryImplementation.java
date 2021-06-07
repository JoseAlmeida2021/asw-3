package mpjp.game.cuttings;

import mpjp.shared.MPJPException;

import java.util.HashSet;
import java.util.Set;
import java.lang.String;



/**
 * A concrete creator implementing a CuttingFactory
 *
 */
public class CuttingFactoryImplementation extends Object implements CuttingFactory {
	
	
	/**
	 * Constructor
	 */
	public CuttingFactoryImplementation() {
		
	}
	
	/**
	 * Create a cutting with given name
	 * 
	 * @param name
	 * @return cutting
	 * @throws MPJPException
	 */
	public Cutting createCutting(String name) throws MPJPException{		
		switch(name) {
		case "RoundCutting":
			return new RoundCutting();
		case "StandardCutting":
			return new StandardCutting();
		case "StraightCutting":
			return new StraightCutting();
		case "TriangularCutting":
			return new TriangularCutting();
		default:
			throw new MPJPException("Cutting not found");
		}
	}
	
	/**
	 * Set of valid cutting names
	 * 
	 * @return available Cuttings - set of valid cutting names
	 */
	public Set<String> getAvaliableCuttings(){
		Set<String> availableCuttings = new HashSet<String>();
		
		availableCuttings.add("RoundCutting");
		availableCuttings.add("StandardCutting");
		availableCuttings.add("StraightCutting");
		availableCuttings.add("TriangularCutting");
		
		return availableCuttings;
	}
}
