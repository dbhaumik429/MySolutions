package com.debu.javapractise;

import java.util.Arrays;
import java.util.Objects;

class Car {
    String carName; // BMW
    Integer engineNumber; // 1242343

    public int hashCode() {
        //int primeNumber = 29;

        //int hashVal = primeNumber * carName.hashCode() + engineNumber.hashCode();
        //return hashVal;

        //return Arrays.hashCode(new Object[]{ carName, engineNumber});
        return Objects.hash(carName, engineNumber);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        if (!(other instanceof Car))
            return false;

        Car otherCar = (Car) other;

        if (this.getCarName() != ((Car) other).getCarName()
                && this.getEngineNumber() != ((Car) other).getEngineNumber())
            return false;

        return true;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(Integer engineNumber) {
        this.engineNumber = engineNumber;
    }
}

public class EqualsAndHashCode {

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car();

        System.out.println(c1 == c2);

    }


}
