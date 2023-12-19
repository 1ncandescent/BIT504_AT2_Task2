import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cell {
    // content of this cell (empty, cross, nought)
	Player content;
	// row and column of this cell
	int row, col;
	
	/** Constructor to initialise this cell with the specified row and col */
	public Cell(int row, int col) {
		
		/*
		 * When a new cell is created, this constructor uses 'this' to assign 
		 * the ROWS and COLS variables provided in GameMain via Board when 
		 * instantiating the game board. if either of those variables are altered,
		 * the size of the grid will change upon creation.
		 */
		this.row = row;
		this.col = col;
		
		/*
		 * The clear method is called here to ensure that cells are generated
		 * as empty by default, ensuring a clear gameboard upon beginning each game
		 */
		clear();
	}
	

	/** Paint itself on the graphics canvas, given the Graphics context g */ 
	public void paint(Graphics g) {
		// Graphics2D allows setting of pen's stroke size
		Graphics2D graphic2D = (Graphics2D) g;
		graphic2D.setStroke(new BasicStroke(GameMain.SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		// draw the symbol in the position
		int x1 = col * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		int y1 = row * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		if (content == Player.Cross) {
			graphic2D.setColor(Color.RED);
			int x2 = (col + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			int y2 = (row + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			graphic2D.drawLine(x1, y1, x2, y2);
			graphic2D.drawLine(x2, y1, x1, y2);
		}else if (content == Player.Nought) {
			graphic2D.setColor(Color.BLUE);
			graphic2D.drawOval(x1, y1, GameMain.SYMBOL_SIZE, GameMain.SYMBOL_SIZE);
		}
	}
	
	/** Set this cell's content to EMPTY */
	public void clear() {
		
		/*
		 * This method simply sets the 'Player' enum to set the cell in question
		 * to Empty (No nought or cross markings)
		 */
		content = Player.Empty;
		
	}
}
