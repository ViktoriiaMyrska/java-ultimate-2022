package additionalPractice.optional.sample1;

public class Cat {
    private String name;
    private String color;

    public Cat(String name, String color){
        super();
        this.name = name;
        this.color = color;
    }

    public Cat(){
        super();
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Cat [name=" + name + " , color=" + color + "]";
    }
}
