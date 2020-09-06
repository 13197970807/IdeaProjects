package package1;

public class instance {
    String name;
    int age;
    public static void main(String[] args){
        instance posonse = new instance("sam_liu", 16);
        System.out.println(posonse.name);
        String add = posonse.method();
        System.out.println(add);
    }
    public instance(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String method() {
        return name + age;
    }
}
