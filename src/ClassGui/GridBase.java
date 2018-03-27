package ClassGui;

public abstract class GridBase implements RuleSetInterface {

	protected int width;
	protected int height;
	protected boolean grid[][];

	// -- gets the number of cells in the width of the grid
	public int getWidth() {
		return this.width;
	}

	// -- sets the number of cells in the width of the grid and resizes the grid
	// keeping the currently state of cells. If cells are
	// "resized out of the grid"
	// they are lost
	public void setWidth(int width) {
		boolean newgrid[][] = new boolean[this.height][width];
		int w = Math.max(this.width, width);
		for (int i = 0; i < this.height; ++i) {
			for (int j = 0; j < w; ++j) {
				newgrid[i][j] = this.grid[i][j];
			}
		}
		this.width = width;
		this.grid = newgrid;
	}

	// -- gets the number of cells in the height of the grid
	public int getHeight() {
		return this.height;
	}

	// -- sets the number of cells in the height of the grid and resizes the
	// grid
	// keeping the currently state of cells. If cells are
	// "resized out of the grid"
	// they are lost
	public void setHeight(int height) {
		boolean newgrid[][] = new boolean[height][this.width];
		int h = Math.max(this.height, height);
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < this.width; ++j) {
				newgrid[i][j] = this.grid[i][j];
			}
		}
		this.height = height;
		this.grid = newgrid;

	}

	// -- sets a grid cell to value. If x or y is off the grid, does nothing
	public abstract void setGridCell(int x, int y, boolean value);

	// -- returns the grid cell value at x, y. If x or y is off the grid return
	// 0
	public abstract boolean getGridCell(int x, int y);

	// -- clears all cells
	public abstract void clear();
}