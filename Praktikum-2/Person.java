public class Person {
    String name;
    int age;
    boolean isMale;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    void setGender(boolean isMale) {
        this.isMale = isMale;

    }

    String getGender() {
        return isMale ? "Laki-Laki" : "Perempuan";
    }

    public static void main(String[] args) {
        Person someone = new Person();

        someone.setName("Diani");
        someone.setAge(18);
        someone.setGender(false);

        System.out.println("================================");
        System.out.println("Nama   : " + someone.getName());
        System.out.println("Usia   : " + someone.getAge());
        System.out.println("Gender : " + someone.getGender());
        System.out.println("================================");
    }
    
}
