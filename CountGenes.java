package firstExercise.leo.gr;

public class CountGenes {
	public int findStopCodon(String dna, int start, String stop) {
		int curr = dna.indexOf(stop, start+3);
		while (curr != -1) {
			int diff = curr - start;
			if (diff % 3 == 0) {
				return curr;
			} else {
				curr = dna.indexOf(stop, curr + 1);
			}
		}
		return -1;
	}

	public void printAllGenes(String dna) {
		int start = 0;
		while (start != -1) {
			String gene = findCodon(dna, start);
			if (gene.isEmpty()) {
				break;
			}
			System.out.println(gene);
			start = dna.indexOf(gene, start +gene.length());
		}
	}

	public int countGenes(String dna) {
		int start = 0;
		int occurs = 0;
		while (start != -1) {
			++occurs;
			String gene = findCodon(dna, start);
			if (gene.isEmpty()) {
				break;
			}
			
			
			start = dna.indexOf(gene, start + gene.length());
		}
		return occurs;
	}

	public  String findCodon(String dna, int where) {
		int start = dna.indexOf("ATG", where);
		if (start == -1) {
			return "No gene found";
		}
		int taaInd = findStopCodon(dna, start, "TAA");
		int tagInd = findStopCodon(dna, start, "TAG");
		int tgaInd = findStopCodon(dna, start, "TGA");
		// int temp = Math.min(taaInd,tagInd);
		// int minIndex = Math.min(temp,tgaInd);
		int minIndex = 0;
		if (taaInd == -1 || (tgaInd != -1 && tgaInd < taaInd)) {
			minIndex = tgaInd;

		} else {
			minIndex = taaInd;
		}

		if (minIndex == -1 || (tagInd != -1 && tagInd < minIndex)) {
			minIndex = tagInd;
		}
		if (minIndex == -1) {
			return "";
		}
		return dna.substring(start, minIndex + 3);
	}

	public static void main(String[] args) {
	CountGenes obj = new CountGenes();
	String dna = "AATGCTAACTAGCTGACTAAT";
	obj.printAllGenes(dna);
	}

}
