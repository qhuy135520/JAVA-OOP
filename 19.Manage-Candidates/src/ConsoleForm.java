import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleForm {

	CandidateManage candidateManage = new CandidateManage();

	List<String> choices = Arrays.asList("=====Welcome To Candidate Management=====",
			"||1. Experience                        ||", "||2. Fresher                           ||",
			"||3. Internship                        ||", "||4. Searching                         ||",
			"||5. Exit                              ||", "||=====================================||", "Choose: ");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));
		return ExceptionData.inputLimit();
	}

	public void createInfCandidate(int candidateType) {
		int count = 0;
		if (!candidateManage.candidateList.isEmpty()) {
			count = candidateManage.candidateList.size() - 1;
		}
		while (true) {
			Candidate candidate = new Candidate();
			System.out.print("Enter ID: ");
			candidate.setCandidateId(ExceptionData.inputId(candidateManage.candidateList));

			System.out.print("Enter First Name: ");
			candidate.setFirstName(ExceptionData.inputString());

			System.out.print("Enter Last Name: ");
			candidate.setLastName(ExceptionData.inputString());

			System.out.print("Enter Birthdate: ");
			candidate.setBirthDate(ExceptionData.inputBirthDate());

			System.out.print("Enter Address: ");
			candidate.setAddress(ExceptionData.inputString());

			System.out.print("Enter Phone: ");
			candidate.setPhone(ExceptionData.inputPhone());

			System.out.print("Enter Email: ");
			candidate.setEmail(ExceptionData.inputEmail());

			switch (candidateType) {
			case 0:
				createExperienceCandidate(candidate, candidateType);
				break;
			case 1:
				createFresherCandidate(candidate, candidateType);
				break;
			case 2:
				createInternCandidate(candidate, candidateType);
				break;
			}
			System.out.println("Create successful!!");
			if (ExceptionData.yesOrNo().equalsIgnoreCase("n")) {
				displayRecentlyCandidate(count);
				break;
			}
		}
	}

	public void createExperienceCandidate(Candidate candidate, int candidateType) {

		System.out.print("Enter Year of Experience: ");
		int year = ExceptionData.yearExp(candidate.getBirthDate());

		System.out.print("Enter Professional Skill: ");
		String skill = ExceptionData.inputString();

		ExperienceCandidate experience = new ExperienceCandidate(candidate.getCandidateId(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(),
				candidateType, candidate.getEmail(), year, skill);

		candidateManage.addCandidate(experience);
	}

	public void createFresherCandidate(Candidate candidate, int candidateType) {
		System.out.print("Enter Graduated time: ");
		int graduatedTime = ExceptionData.inputGraduateTime(candidate.getBirthDate());

		System.out.print("Enter Rank of Graduation: ");
		String rank = ExceptionData.inputRank();

		System.out.print("Enter Where student graduated: ");
		String university = ExceptionData.inputString();

		FresherCandidate fresher = new FresherCandidate(candidate.getCandidateId(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(),
				candidateType, candidate.getEmail(), graduatedTime, rank, university);

		candidateManage.addCandidate(fresher);
	}

	public void createInternCandidate(Candidate candidate, int candidateType) {
		System.out.print("Enter major: ");
		String major = ExceptionData.inputString();

		System.out.println("Enter Semester: ");
		String semester = ExceptionData.inputSemester();

		System.out.println("Enter University Name: ");
		String universityName = ExceptionData.inputString();

		InternCandidate intern = new InternCandidate(candidate.getCandidateId(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(),
				candidateType, candidate.getEmail(), major, semester, universityName);

		candidateManage.addCandidate(intern);
	}

	public void displayRecentlyCandidate(int count) {
		System.out.println("===========Recently  Candidate===========");
		System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Candidate Name", "BirthDate", "Phone", "Address",
				"Email", "Candidate Type");
		ArrayList<Candidate> temp = candidateManage.candidateList;
		for (int i = count; i < temp.size(); i++) {
			System.out.printf("%-20s%-20d%-20s%-20s%-20s%-20d\n",
					temp.get(i).getFirstName() + " " + temp.get(i).getLastName(), temp.get(i).getBirthDate(),
					temp.get(i).getPhone(), temp.get(i).getAddress(), temp.get(i).getEmail(),
					temp.get(i).getCandidateType());
		}
	}

	public void searchCandidate() {
		if (candidateManage.candidateList.isEmpty()) {
			System.out.println("List is empty!!");
		} else {
			System.out.print("Input Candidate name (First name or Last name): ");
			String name = ExceptionData.inputString();
			System.out.println("Input type of candidate: ");
			int type = ExceptionData.inputInt();
			ArrayList<Candidate> temp = candidateManage.searchCandidate(name, type);
			if (temp.isEmpty()) {
				System.out.println("Not found!!");
			} else {
				System.out.println("=============Search Candidate============");
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Candidate Name", "BirthDate", "Address", "Phone",
						"Email", "Candidate Type");
				for (Candidate c : temp) {
					System.out.printf("%-20s%-20d%-20s%-20s%-20s%-20d\n", c.getFirstName() + " " + c.getLastName(),
							c.getBirthDate(), c.getAddress(), c.getPhone(), c.getEmail(), c.getCandidateType());
				}
			}
		}
	}

	public void execute() {
		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				createInfCandidate(0);
				break;
			case 2:
				createInfCandidate(1);
				break;
			case 3:
				createInfCandidate(2);
				break;
			case 4:
				searchCandidate();
				break;
			case 5:
				System.out.println("Good Bye!!");
				System.exit(0);
			}
		}
	}
}