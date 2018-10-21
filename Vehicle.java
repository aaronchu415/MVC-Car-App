import java.util.Comparator;


public abstract class Vehicle {
    private String vinNum;
    private VehicleMakes make;
    private String model;
    private String owner;
    private int numOfDoors;

    public Vehicle(String vinNum, VehicleMakes make, String model, String owner, int numOfDoors) {

        this.setVinNum(vinNum);
        this.make = make;
        this.model = model;
        this.setOwner(owner);
        this.setNumOfDoors(numOfDoors);
    }

    //one methods

    public String HonkHorn() { return "Honk Honk!"; }

    //Getters

    public String getVinNum() {
        return vinNum;
    }

    public VehicleMakes getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getOwner() {
        return owner;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    //Setters


    public void setVinNum(String vinNum) {
    	if (vinNum.matches("[a-zA-Z0-9]*") == false || vinNum.isEmpty()) {
    		throw new IllegalArgumentException();
        } else {
        	this.vinNum = vinNum;
        }
    }

    public void setMake(VehicleMakes make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOwner(String owner) {
    	if (owner.matches("[a-zA-Z\\s]*") == false || owner.isEmpty()) {
    		throw new IllegalArgumentException();
    	} else {
    		this.owner = owner;
    	}
    }


    public void setNumOfDoors(int numOfDoors) {

        //doors need to be positive num
        if (numOfDoors < 2 || numOfDoors > 6) {
            throw new IllegalArgumentException();
        } else {
            this.numOfDoors = numOfDoors;
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "vinNum='" + vinNum + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", owner='" + owner + '\'' +
                ", numOfDoors=" + numOfDoors +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Vehicle) {
            Vehicle otherVehicle = (Vehicle) o;

            String otherVinNum = otherVehicle.getVinNum();

            if (otherVinNum.equalsIgnoreCase(this.vinNum)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }
}
