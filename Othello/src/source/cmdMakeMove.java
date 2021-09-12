package source;

public class cmdMakeMove extends RecordedCommand{
	private int[][] prevBoard;
	private int[] prevScore;
	private int[][] currBoard;
	private int[] currScore;
	@Override
	public void execute(Move m) {
		/*try {
			if (cmdParts.length < 2) {
				throw new ExInsufficientArguments();
			}
			oldD = SystemDate.getInstance().toString();
			SystemDate.getInstance().set(cmdParts[1]);
			newD = cmdParts[1];
			
			addUndoCommand(this); 
			clearRedoList();

			System.out.println("Done.");
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format!");
		} catch (ExInsufficientArguments e) {
			System.out.println(e.getMessage());
		}*/
		
		BoardState bs = BoardState.getInstance();
		
		prevBoard = bs.getBoard().clone();
		prevScore = bs.getScore().clone();
		
		bs.changeState(m);
		
		currBoard = bs.getBoard().clone();
		currScore = bs.getScore().clone();
		addUndoCommand(this);
	}
	@Override
	public void undoMe() {
		// TODO Auto-generated method stub
		BoardState bs = BoardState.getInstance();
		bs.revertState(prevBoard, prevScore);
		addRedoCommand(this);
	}
	@Override
	public void redoMe() {
		// TODO Auto-generated method stub
		BoardState bs = BoardState.getInstance();
		bs.revertState(currBoard, currScore);
		addRedoCommand(this);
		
	}
	
}
