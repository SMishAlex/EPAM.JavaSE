package com.epam.courses.javase.msid.unit02.task6;

/**
 * Created by msid on 27.02.17.
 */
public class AtomicSubmarine {

    public AtomicSubmarine(double kpd) {
        KPD = kpd;
    }

    public class Motor {
        private long power = 0;
        public final long MAX_POWER = Long.MAX_VALUE;

        public long getPower() {
            return power;
        }

        public void setPower(long power) {
            if (power < 0)
                throw new IllegalArgumentException("Power cant be negative");
            if (this.power + power < MAX_POWER)
                this.power = power;
            else
                throw new IllegalArgumentException("Motor can broke!");
        }

        public void powerUp(long addingPower) {
            setPower(power + addingPower);
        }

        public void powerDown(long downingPower) {
            powerUp(-downingPower);
        }
    }

    private final double KPD;

    Position pos = new Position();
    Motor motor = new Motor();
    double angle = 0;

    private class Position {
        public long X = 0;
        public long Y = 0;
        public long deep = 0;
    }

    public void moveForward(long time) {
        for (long i = time; i > 0; i--) {
            double speed = KPD * motor.getPower();
            move(speed);
            System.out.println();
        }
    }

    public void moveReverse(long time) {
        for (long i = time; i > 0; i--) {
            double speed = -KPD * motor.getPower();
            move(speed);
            System.out.println();
        }
    }

    private void move(double speed) {
        pos.X += speed * Math.cos(angle);
        pos.Y += speed * Math.sin(angle);
    }

    public void chageAngle(double angle) {
        this.angle = angle;
    }

    public void moveDown(long time, double downAngle) {
        double speed = -KPD * motor.getPower();
        double xySpeed = speed * Math.sin(downAngle);
        move(xySpeed);
        pos.deep += speed * Math.cos(downAngle);
    }

    public void moveUp(long time, double upAngle) {
        double speed = -KPD * motor.getPower();
        double xySpeed = speed * Math.cos(upAngle);
        move(xySpeed);
        pos.deep += speed * Math.sin(upAngle);
    }

    public void speedUp(long power) {
        try {
            motor.powerUp(power);
        } catch (IllegalArgumentException e) {
            motor.setPower(0);
            System.out.println(e);
        }
    }

    public void speedDown(long power) {
        speedUp(-power);
    }
}
