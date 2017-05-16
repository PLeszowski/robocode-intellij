package asrobots;

import robocode.BulletHitEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Created by RENT on 2017-05-16.
 */
public class RoboCap extends Robot {

	double turnMyGun = 45;
	double distance = 0;
	int count = 0;

	@Override
	public void run() {


		while (true) {

			ahead(getRadarHeading());
			turnLeft(45);
			turnGunLeft(30);
			turnRadarLeft(45);

		}
	}

	@Override
	public void onScannedRobot (ScannedRobotEvent event){
		super.onScannedRobot(event);

		if (event.getDistance() < 50 && getEnergy() > 50) {
			fire(3);
		} // otherwise, fire 1.
		else {
			fire(1);
		}
		// Call scan again, before we turn the gun
		scan();
	}

	@Override
	public void onHitWall(HitWallEvent event) {
		super.onHitWall(event);
		back(100);
	}

	//@Override
	//public void onBulletHit(BulletHitEvent event) {
	//	super.onBulletHit(event);
	//}
}
