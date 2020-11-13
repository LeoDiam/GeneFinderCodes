package firstExercise.leo.gr;

public class FindGeneWhile {
    public String findGenes(String dna) {
    	int start = dna.indexOf("ATG");
    	int end = dna.indexOf("TAA",start+3);
    	while (end!= -1) {
    		if((end-start) % 3 == 0) {
    			return dna.substring(start, end+3);
    		}else {
    			end = dna.indexOf("TAA", end +1);
    		}
    	}
    	return "";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
