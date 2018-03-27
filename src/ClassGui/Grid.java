package ClassGui;

public class Grid extends GridBase implements RuleSetInterface{
	private boolean Grid[][];
	private int height = 20;
	private int width = 20;
	private boolean wrapped = true;
	private boolean Conways = true;

	public void setConways(boolean x) {
		Conways = x;
	}

	public boolean getConways() {
		return Conways;
	}

	public void setWrapped(boolean x) {
		wrapped = x;
	}

	public boolean getWrapped() {
		return this.wrapped;
	}

	public Grid() {
		boolean newgrid[][] = new boolean[height][width];

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				newgrid[j][i] = false;
			}
		}
		this.Grid = newgrid;
	}

	public Grid(int height, int width, boolean wrapped, boolean mode) {
		boolean newgrid[][] = new boolean[height][width];
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				newgrid[j][i] = false;
			}
		}
		this.Grid = newgrid;
		this.height = height;
		this.width = width;
		this.wrapped = wrapped;
		this.Conways = mode;
	}

	public void setHeight(int height) {
		boolean newgrid[][] = new boolean[height][this.width];
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < this.width; i++) {
				newgrid[j][i] = false;
			}
		}
		this.Grid = newgrid;
		this.height = height;
	}

	public void setWidth(int width) {
		boolean newgrid[][] = new boolean[this.height][width];
		for (int j = 0; j < this.height; j++) {
			for (int i = 0; i < width; i++) {
				newgrid[j][i] = false;
			}
		}
		this.Grid = newgrid;
		this.width = width;
	}

	public void setGridCell(int x, int y) {
		if (this.Grid[x][y]) {
			this.Grid[x][y] = false;
		} else {
			this.Grid[x][y] = true;
		}
	}

	public void setGridCell(int x, int y, boolean gridSwitch) {
		this.Grid[x][y] = gridSwitch;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public boolean getGridCell(int x, int y) {
		return this.Grid[x][y];
	}

	public void clear() {
		for (int i = 0; i < this.Grid.length; i++) {
			for (int j = 0; j < this.Grid[i].length; j++) {
				this.Grid[i][j] = false;
			}
		}
	}
	public GridBase ApplyRule(GridBase grid) {
		if (Conways) {
			ConwaysRuleSet rules = new ConwaysRuleSet(this.wrapped);
			grid = rules.ApplyRule(grid);
			return grid;
		} else {
			CustomRuleSet rules = new CustomRuleSet(this.wrapped);
			grid = rules.ApplyRule(grid);
			return grid;
		}
	}
}
