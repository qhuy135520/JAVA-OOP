
public class ConsoleForm {
	public void EnterPath() {
		while (true) {
			AnalyzePath();
			if (ExceptionData.yesOrNo().equalsIgnoreCase("n")) {
				System.out.println("Good bye!!");
				break;
			}
		}
	}

	public void AnalyzePath() {
		System.out.println("===== Analysis Path Program =====");
		System.out.print("Please input Path: ");
		FilePath fp = new FilePath();
		String path = ExceptionData.inputString();
		if (ExceptionData.checkInputPath(path) == true) {
			System.out.println("Disk: " + fp.getDisk(path));
			System.out.println("Extension: " + fp.getExtension(path));
			System.out.println("File name: " + fp.getFileName(path));
			System.out.println("Path: " + fp.getPath(path));
		} else {
			System.err.println("Path isn't file.");
		}
	}
}
