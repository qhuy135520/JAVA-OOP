
public class FresherCandidate extends Candidate {
	private int graduationDate;
	private String rankOfGraduation;
	private String education;

	public FresherCandidate() {
	}

	public FresherCandidate(String candidateId, String firstName, String lastName, int birthDate, String address,
			String phone, int candidateType, String email, int graduationDate, String rankOfGraduation,
			String education) {
		super(candidateId, firstName, lastName, birthDate, address, phone, candidateType, email);
		this.graduationDate = graduationDate;
		this.rankOfGraduation = rankOfGraduation;
		this.education = education;
	}

	public int getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(int graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getRankOfGraduation() {
		return rankOfGraduation;
	}

	public void setRankOfGraduation(String rankOfGraduation) {
		this.rankOfGraduation = rankOfGraduation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
}
