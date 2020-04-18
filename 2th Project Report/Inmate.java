public class Inmate {
    /**
     * Social Security Numver
     */
    private int id;

    /**
     * Full name
     */
    private String name;

    /**
     * What crime did he commit
     */
    private String crimeType;

    /**
     * How many days are left before he leaves prison
     */
    private int remainingDay;

    /**
     * The the ward where it is located in the prison
     */
    private int wardNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public int getRemainingDay() {
        return remainingDay;
    }

    public void setRemainingDay(int remainingDay) {
        this.remainingDay = remainingDay;
    }

    public int getWardNo() {
        return wardNo;
    }

    public void setWardNo(int wardNo) {
        this.wardNo = wardNo;
    }

    public void getHealtCare(){}

    @Override
    public String toString() {
        return "Inmate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crimeType='" + crimeType + '\'' +
                ", remainingDay=" + remainingDay +
                ", wardNo=" + wardNo +
                '}';
    }
}
