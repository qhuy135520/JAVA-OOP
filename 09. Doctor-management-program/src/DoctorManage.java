import java.util.ArrayList;

public class DoctorManage {
	ArrayList<Doctor> doctorList = new ArrayList<>();

	public DoctorManage() {
	}

	public DoctorManage(ArrayList<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	public ArrayList<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(ArrayList<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	public void addDoctor(Doctor doctor) {
		doctorList.add(doctor);
	}

	public void deleteContact(ArrayList<Doctor> doctor, String codeDelete) {

		Doctor doctorDelete = getCodeDoctor(doctor, codeDelete);
		if (doctorDelete == null) {
			System.err.println("Not found contact.");
			return;
		} else {
			doctor.remove(doctorDelete);
		}
		System.err.println("Successful.");
	}

	public static Doctor getCodeDoctor(ArrayList<Doctor> doctor, String code) {
		for (Doctor c : doctor) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}

}
