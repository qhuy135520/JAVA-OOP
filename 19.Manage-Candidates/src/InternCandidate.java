
public class InternCandidate extends Candidate {
	private String majors;
	private String semester;
	private String universityName;

	public InternCandidate() {
	}

	public InternCandidate(String candidateId, String firstName, String lastName, int birthDate, String address,
			String phone, int candidateType, String email, String majors, String semester, String universityName) {
		super(candidateId, firstName, lastName, birthDate, address, phone, candidateType, email);
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
}
