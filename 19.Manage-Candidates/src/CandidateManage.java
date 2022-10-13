import java.util.ArrayList;

public class CandidateManage {
	ArrayList<Candidate> candidateList = new ArrayList<>();

	public CandidateManage() {
	}

	public CandidateManage(ArrayList<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public ArrayList<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(ArrayList<Candidate> candidatsList) {
		this.candidateList = candidateList;
	}

	public void addCandidate(Candidate c) {
		candidateList.add(c);
	}

	public ArrayList<Candidate> searchCandidate(String name, int type) {
		ArrayList<Candidate> candidateFound = new ArrayList<>();
		for (Candidate c : candidateList) {
			if ((c.getFirstName().contains(name) && c.getCandidateType() == type)
					|| (c.getLastName().contains(name) && c.getCandidateType() == type)) {
				candidateFound.add(c);
			}
		}
		return candidateFound;
	}
}
