package firstExercise.leo.gr;
import edu.duke.*;
import java.util.ArrayList;

public class FindAllCodons {
	
	public int findStopCodon(String dna ,int start, String stop ) {
		int curr = dna.indexOf(stop, start);
		while(curr != -1) {
			int diff = curr - start ;
			if (diff % 3 ==0) {
				return curr;
				}else {
					curr = dna.indexOf(stop, curr + 1);
				}
				}
		return dna.length();
	}
	
	public ArrayList getAllGenes(String dna,ArrayList gene) {
		int start = 0;
		ArrayList<String> geneList = new ArrayList<String>();
		while(true){
			String curGene = findCodon(dna,start);
			if(curGene.isEmpty()) {
				break;
			}
			geneList.add(curGene);
			start = dna.indexOf(curGene,start+curGene.length());
		}
		return geneList;
	}
	public void printAllGenes(String dna) {
		int start = 0;
		while(true) {
			String gene = findCodon(dna,start);
			if(gene.isEmpty()) {
				break;
			}
			System.out.println(gene);
			start = dna.indexOf(gene,start)+gene.length();
		}
	}
	
	public String findCodon(String dna, int where) {
		int start = dna.indexOf("ATG",where);
	    if(start == -1) {
	    	return "No gene found";
	    }
	    int taaInd = findStopCodon(dna,start,"TAA");
	    int tagInd = findStopCodon(dna,start,"TAG");
	    int tgaInd = findStopCodon(dna,start,"TGA");
	    //int temp = Math.min(taaInd,tagInd);
	    //int minIndex =  Math.min(temp,tgaInd);
	    int minIndex = Integer.MAX_VALUE;
	    if(taaInd == -1 || (tgaInd != -1 && tgaInd < taaInd)) {
	    	minIndex = tgaInd;
	    	
	    }else {
	    	minIndex = taaInd;
	    }
	    
	    if(minIndex == -1 || (tagInd != -1 && tagInd < minIndex)) {
	    	minIndex = tagInd;
	    }
	    if(minIndex == -1) {
	    	return "";
	    }
	    return dna.substring(start, minIndex +3);
	}

	public static void main(String[] args) {
		String dna = "ATGTAATGATAATAGTGA";
		FindAllCodons l = new FindAllCodons();
		ArrayList<String> test = null;
		l.getAllGenes(dna, test);
		for(String g : test) {
			System.out.println(g);
		}
		
		
	}

}
