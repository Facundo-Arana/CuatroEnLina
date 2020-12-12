package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {

	public static final int NUM_TO_WIN = 4;
	private Player j1, j2, playerTurn;
	private Table table;
	private boolean winner;

	public Game(Player j1, Player j2, Table table) {
		this.j1 = j1;
		this.j2 = j2;
		this.table = table;
		this.winner = false;
	}

	public void play() {
		int mod = selectGameMod();
		if (mod == 2)
			this.j2 = new PlayerCPU(j2.getName(), j2.getCoin());

		table.imprimir();
		while (!winner && table.free()) {
			playerTurn = this.changePlayer(playerTurn);
			boolean ok = false;
			int p = -1;
			while (!ok) {
				p = playerTurn.getColumn();
				ok = table.insertCoin(playerTurn.getCoin(), p);
			}
			System.out.println(playerTurn + " jugo la ficha " +playerTurn.getCoin()+ " en la columna " + p);
			table.imprimir();
			if(table.isWinner()) {
				winner = true;
			}
		}
		System.out.println();
		if(!winner)
			System.out.println("Empate !!!!");
		else
			System.out.println("Gano " + playerTurn + " !!!!");
			
	}

	private Player changePlayer(Player playerTurn) {
		if (playerTurn != null) {
			if (playerTurn.equals(j1)) {
				return j2;
			}
		}
		return j1;
	}

	private int selectGameMod() {
		int r = 0;
		System.out.println("Seleccione modo de juego");
		System.out.println();
		System.out.println("1 - jugador vs jugador");
		System.out.println("2 - jugador vs cpu");
		while (r != 1 && r != 2) {
			r = Game.getNumber();
		}
		return r;
	}

	public static int getNumber() {
		int r = -1;
		BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
		while (r < 0) {
			try {
				r = Integer.parseInt(e.readLine());
			} catch (Exception err) {
				System.out.println(err);
				r = -1;
			}
		}
		return r;
	}

}
