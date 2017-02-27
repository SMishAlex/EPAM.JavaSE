package com.epam.courses.javase.msid.unit02.task6and7;

/**
 * Created by msid on 27.02.17.
 */
public class AtomicSubmarine {

    public AtomicSubmarine(double kpd) {
        KPD = kpd;
    }

    private class Motor {
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

    private Position pos = new Position();
    private Motor motor = new Motor();
    private double angle = 0;

    public class Position {
        public long X = 0;
        public long Y = 0;
        public long deep = 0;

        @Override
        public String toString() {
            return String.format("Position is [%d, %d, %d]", X, Y, deep);
        }
    }

    public void moveForward(long time) {
        for (long i = time; i > 0; i--) {
            double speed = KPD * motor.getPower();
            move(speed);
            System.out.println(pos);
        }
    }

    public void moveReverse(long time) {
        for (long i = time; i > 0; i--) {
            double speed = -KPD * motor.getPower();
            move(speed);
            System.out.println(pos);
        }
    }

    private void move(double speed) {
        pos.X += speed * Math.cos(angle);
        pos.Y += speed * Math.sin(angle);
    }

    public void changeAngle(double angle) {
        this.angle = angle;
    }

    public void moveDown(long time, double downAngle) {
        for (long i = time; i > 0; i--) {
            double speed = KPD * motor.getPower();
            double xySpeed = speed * Math.cos(downAngle);
            move(xySpeed);
            pos.deep += speed * Math.sin(downAngle);
            System.out.println(pos);
        }
    }

    public void moveUp(long time, double upAngle) {
        for (long i = time; i > 0; i--) {
            double speed = KPD * motor.getPower();
            double xySpeed = speed * Math.cos(upAngle);
            move(xySpeed);
            pos.deep -= speed * Math.sin(upAngle);
            System.out.println(pos);
        }
    }

    public void speedUp(long power) {
        try {
            motor.powerUp(power);
        } catch (IllegalArgumentException e) {
            motor.setPower(0);
            System.out.println(e);
        }
    }

    public Position getPos(){
        return pos;
    }

    public void speedDown(long power) {
        speedUp(-power);
    }
}
