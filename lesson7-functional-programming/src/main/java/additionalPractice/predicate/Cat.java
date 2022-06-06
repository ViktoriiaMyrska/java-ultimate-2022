package additionalPractice.predicate;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }

    public Cat(){
        super();
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Cat [name=" + name + " , age=" + age + "]";
    }
}
