package modelo;

public class Player {
	
	private char coin;
	private String name;
	
	public Player(String name, char coin) {
		this.name = name;
		this.coin = coin;
	}

	public int getColumn() {
		System.out.println(name + " debe seleccionar una columna");	
		int c = Game.getNumber();
		return c;
	}

	public char getCoin() {
		return this.coin;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Player p = (Player) o;
			return this.name.equals(p.getName());
			
		}catch(Exception exc) {
			return false;
		}		
	}
}
