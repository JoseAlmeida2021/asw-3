package mpjp.game.cuttings;



import java.lang.String;
import mpjp.shared.MPJPException;
import java.util.Set;


/**
 * Definition of a factory method to produce cuttings
 *
 */
public interface CuttingFactory {
	
	/**
	 * Create a cutting with given name
	 * 
	 * @param name 
	 * @return cutting
	 * @throws MPJPException
	 */
	Cutting createCutting(String name) throws MPJPException;
	
	/***
	 * Set of valid cutting names
	 * 
	 * @return set of valid cutting names
	 */
	Set<String> getAvaliableCuttings();
	
}



