package source;
import java.util.*;

public abstract class RecordedCommand implements Command{
	public abstract void undoMe();
	public abstract void redoMe();

	private static ArrayList<RecordedCommand> undolist = new ArrayList<>();
	private static ArrayList<RecordedCommand> redolist = new ArrayList<>();
	
	protected static void addUndoCommand(RecordedCommand rc) {
		undolist.add(rc);
	}

	protected static void addRedoCommand(RecordedCommand rc) {
		redolist.add(rc);
	}

	protected static void clearRedoList() {
		redolist.clear();
	}

	public static void undoOneCommand() {
		if (undolist.size() == 0) {
			System.out.println("Nothing to undo.");
		} else
			undolist.remove(undolist.size() - 1).undoMe();

	}

	public static void redoOneCommand() {
		if (redolist.size() == 0) {
			System.out.println("Nothing to redo.");
		} else
			redolist.remove(redolist.size() - 1).redoMe();
	}

}
