package modelo;

public class PlayerCPU extends Player {

	public PlayerCPU(String name, char coin) {
		super(name, coin);
	}

	@Override
	public int getColumn() {
		return (int) (Math.random() * Table.MAX_SIZE);
	}

}
