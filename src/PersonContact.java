public class PersonContact {
    int phoneNumber;
    String group;
    String name;
    boolean isMan;
    String adress;
    String dayOfBirth;
    String email;

    public PersonContact() {
    }

    public PersonContact(int phoneNumber, String group, String name, boolean isMale, String adress, String dayOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.isMan = isMale;
        this.adress = adress;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String disPlay() {
        return "PersonContact{" +
                "phoneNumber=" + phoneNumber +
                ", Group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", isMale=" + isMan +
                ", adress='" + adress + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
