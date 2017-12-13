import java.util.Scanner;
public class Grid {
	private int rows;
	private int columns;
	private Ship[][] grid;
	private char[][] printableGrid;

	
	public Grid(int rows, int columns)
	{
		this.rows = rows;
		this.columns = columns;
		printableGrid = new char[rows][columns];
		grid = new Ship[rows][columns];
		//make sure after this to initialize to make sure that it worked correctly
	}
	
	public void placeShip(Ship ship, int x, int y)
	{
		int breaker = 0;
		while (breaker == 0)
		{
			if (x > grid.length || y > grid[0].length)
			{
				System.out.println("overflow error on Grid.placeShip");
			}
			else
			{
				grid[x][y] = ship;
				printableGrid[x][y] = grid[x][y].getGraphic(); //printable grid will mirror grid but have representations for blank spaces
				breaker++;
			}
		}
	
		
	}
	
	public void initialize()
	{
		for (int i = 0; i < printableGrid.length; i++)
		{
			for (int j = 0; j < printableGrid[0].length; j++)
			{
				printableGrid[i][j] = '.';
				System.out.print(printableGrid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printGrid()
	{
		for (int i = 0; i < printableGrid.length; i++)
		{
			for (int j = 0; j < printableGrid[0].length; j++)
			{
				System.out.print(printableGrid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int getRows()
	{
		return rows;
	}
	
	public boolean isEmpty(int t, int c)
	{
		if (grid[t][c] == null)
		{
			return true;
		}
		return false;
	}
	
	public int getColumns()
	{
		return columns;
	}
	
	public void finder(int x, int y)
	{
		if (printableGrid[x][y] == '.')
		{
			System.out.println("nothing here");
		}
		else
		{
			System.out.println(grid[x][y].toString());
		}
	}

}
