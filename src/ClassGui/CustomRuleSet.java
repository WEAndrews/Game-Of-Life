package ClassGui;

public class CustomRuleSet implements RuleSetInterface {
	private boolean wrapped;
	
	public CustomRuleSet(){
		this.wrapped = false;
	}
	
	public CustomRuleSet(boolean wrapped){
		this.wrapped = wrapped;
	}
	
	public int numNeighbors(int x, int y, GridBase grid) {
		int neighborCount = 0;
		int maxHeight = grid.getHeight() - 1;
		int maxWidth = grid.getWidth() - 1;
		// System.out.println(Conways);
		// System.out.println(wrapped);
		// System.out.println("MaxHeight is " + maxHeight);
		// System.out.println("MaxWidth is " + maxWidth);
		// System.out.println("x = " + x);
		// System.out.println("y = " + y);
		if (!this.wrapped) {
			if (y == maxWidth && x == maxHeight) {
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
			} else if (x == maxHeight && y > 0 && y < maxWidth) {
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
			} else if (x == maxHeight && y == 0) {
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
			} else if (y == 0 && x > 0 && x < maxHeight) {
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
			} else if (x == 0 && y == 0) {
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, x + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
			} else if (x == 0 && y > 0 && y < maxWidth) {
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y + 1)) {
					neighborCount++;
				}
			} else if (x == 0 && y == maxWidth) {
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
			} else if (y == maxWidth && x > 0 && x < maxHeight) {
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
			} else {
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
			}
		} else {
			if (x == maxHeight && y == maxWidth) {
				if (grid.getGridCell(0, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
			} else if (x == maxHeight && y > 0 && y < maxWidth) {
				if (grid.getGridCell(0, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
			} else if (x == maxHeight && y == 0) {
				if (grid.getGridCell(0, 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
			} else if (y == 0 && x > 0 && x < maxHeight) {
				if (grid.getGridCell(x + 1, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
			} else if (x == 0 && y == 0) {
				if (grid.getGridCell(1, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, maxWidth)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
			} else if (x == 0 && y > 0 && y < maxWidth) {
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, y)) {
					neighborCount++;
				}
			} else if (x == 0 && y == maxWidth) {
				if (grid.getGridCell(maxHeight, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(maxHeight, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(1, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(0, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
			} else if (y == maxWidth && x > 0 && x < maxHeight) {
				if (grid.getGridCell(x, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, 0)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
			} else {
				if (grid.getGridCell(x, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x - 1, y)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y - 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y + 1)) {
					neighborCount++;
				}
				if (grid.getGridCell(x + 1, y)) {
					neighborCount++;
				}
			}
		}
		return neighborCount;
	}

	public GridBase ApplyRule(GridBase grid) {
		Grid temp = new Grid(grid.getHeight(), grid.getWidth(),
		this.wrapped, false);
			for (int i = 0; i < temp.getHeight(); i++) {
				for (int j = 0; j < temp.getWidth(); j++) {
					temp.setGridCell(i, j, false);
					;
				}
			}

// System.out.println("For Loop Height: " + grid.getHeight());
// System.out.println("For Loop Width: " + grid.getWidth());

			for (int j = 0; j < grid.getWidth(); j++) {
				for (int i = 0; i < grid.getHeight(); i++) {
					if (grid.getGridCell(i, j) == true) {
						if (this.numNeighbors(i, j, grid) < 1) {
							temp.setGridCell(i, j, false);
						} else if (this.numNeighbors(i, j, grid) > 2) {
							temp.setGridCell(i, j, false);
						} else {
							temp.setGridCell(i, j, true);
						}
					} else {
						if (this.numNeighbors(i, j, grid) == 2) {
							temp.setGridCell(i, j, true);
						}
					}
				}
			}
		return temp;
	}
}
