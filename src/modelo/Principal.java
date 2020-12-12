package modelo;

public class Principal {

	public static void main(String[] args) {
		Player j1 = new Player("Facundo", 'X');
		Player j2 = new Player("Fausto", 'O');
		Table t = new Table(); 
		Game game = new Game(j1,j2, t);
		game.play();
	}

}
