
public class FilePath {
	public  String getPath(String path) {
		int fromDisk = path.indexOf("\\");
		int toNameFile = path.lastIndexOf("\\");
		return path.substring(fromDisk + 1, toNameFile);
	}

	public  String getFileName(String path) {
		int positionFrom = path.lastIndexOf("\\");
		int positionTo = path.lastIndexOf(".");
		return path.substring(positionFrom + 1, positionTo);
	}

	public  String getExtension(String path) {
		int positionDot = path.lastIndexOf(".");
		return path.substring(positionDot, path.length());
	}

	public  String getDisk(String path) {
		int positionColon = path.indexOf("\\");
		return path.substring(0, positionColon + 1);
	}

	public  String getFolder(String path) {
		int positionColon = path.indexOf("\\");
		int positionDot = path.lastIndexOf("\\");
		path = path.substring(positionColon, positionDot);
		String[] splitFile = path.split("\\");
		return splitFile[splitFile.length - 1];
	}

}
