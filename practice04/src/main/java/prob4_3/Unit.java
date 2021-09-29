package prob4_3;

public class Unit {

	public static void main(String[] args) {
		Tank tank = new Tank();
		tank.move(1, 3);
		tank.stop();
		Marine marine = new Marine();
		marine.move(0, 0);
		marine.stop();
		DropShip dropship = new DropShip();
		dropship.move(0, 0);
		dropship.stop();
		
	}
	
	void move(int x, int y) {
		/* 지정된 위치로 이동 */
	}

	void stop() {
		/* 현재 위치에 정지 */
	}

}
