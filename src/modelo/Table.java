package modelo;

public class Table {

	public static final int MIN_SIZE = 4;
	public static final int MAX_SIZE = 20;
	private char[][] t;
	private int cols, rows, lastR, lastC;

	public Table() {
		 System.out.println("Seleccione cantidad de columnas");
		this.cols = this.getTableProportions();

		 System.out.println("Seleccione cantidad de filas");
		this.rows = this.getTableProportions();
		this.loadTable();
	}

	/*
	 * Obtiene un numero valido para las dimensiones del tablero
	 */
	private int getTableProportions() {
		int a = 0;
		System.out.println("(el numero debe ser mayor a " + MIN_SIZE + " y menor a " + MAX_SIZE + ")");
		while (a < MIN_SIZE || a > MAX_SIZE) {
			a = Game.getNumber();
		}
		return a;
	}

	/*
	 * Carga la matriz con espacios en blanco
	 */
	private void loadTable() {
		this.t = new char[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				t[i][j] = ' ';
	}

	/*
	 * Verifica si una columna tiene espacio para colocar una ficha
	 */
	private boolean validCol(int p) {
		return (p > -1 && p < cols) && this.t[0][p] == ' ';
	}

	/**
	 * Colocar una ficha en el tablero
	 * 
	 * @param c Es la ficha a colocar
	 * @param p Es la columna donde se va a colocar la ficha
	 */
	public boolean insertCoin(char c, int p) {
		if (!validCol(p)) {
			return false;
		}
		int r = rows - 1;
		while (this.t[r][p] != ' ') {
			r--;
		}
		this.t[r][p] = c;
		lastR = r;
		lastC = p;
		return true;
	}

	public boolean isWinner() {
		return (horizontal() || vertical() || diagonales());
	}

	private boolean horizontal() {
		int cont = 1;
		int c = lastC;
		char x = t[lastR][c];
		while (c > 0 && (t[lastR][c - 1] == x)) {
			cont++;
			c--;
		}
		c = lastC;
		while((c < cols-1) && (t[lastR][c + 1] == x)) {
			cont++;
			c++;
		}
		return cont >= Game.NUM_TO_WIN;
	}


	private boolean vertical() {
		int cont = 1;
		int r = lastR;
		char x = t[r][lastC];
		while (r > 0 && (t[r - 1][lastC] == x)) {
			cont++;
			r--;
		}
		r = lastR;
		while((r < rows -1) && (t[r + 1][lastC] == x)) {
			cont++;
			r++;
		}
		return cont >= Game.NUM_TO_WIN;
	}

	private boolean diagonales() {	
		return diagonalUp() || diagonalDown();
	}
	
	private boolean diagonalDown() {
		int cont = 1;
		int c = lastC;
		int r = lastR;
		char x = t[r][c];
		while((c > 0) && (r > 0) && t[r-1][c-1] == x) {
			cont++;
			c--;
			r--;
		}
		c = lastC;
		r = lastR;
		while((c < cols-1) && (r < rows-1) && t[r+1][c+1] == x) {
			cont++;
			c++;
			r++;
		}
		return cont >= Game.NUM_TO_WIN;
	}

	private boolean diagonalUp() {
		int cont = 1;
		int c = lastC;
		int r = lastR;
		char x = t[r][c];
		while((c > 0) && (r < rows-1) && t[r+1][c-1] == x) {
			cont++;
			c--;
			r++;
		}
		c = lastC;
		r = lastR;
		while((c < cols-1) && (r > 0) && t[r-1][c+1] == x) {
			cont++;
			c++;
			r--;
		}
		return cont >= Game.NUM_TO_WIN;
	}

	public boolean free() {
		for (int i = 0; i < cols; i++) {
			if (t[0][i] == ' ')
				return true;
		}
		return false;
	}

	public void imprimir() {
		for (int fila = 0; fila < rows; fila++) {
			System.out.print("| ");
			for (int columna = 0; columna < cols; columna++) {
				System.out.print(t[fila][columna] + " | ");
			}
			System.out.println();
		}
	}

}
