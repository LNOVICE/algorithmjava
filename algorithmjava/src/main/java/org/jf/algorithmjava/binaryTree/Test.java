package org.jf.algorithmjava.binaryTree;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setName("a");
        person.setAge(12);
        Person per1=(Person) person.clone();
        per1.setName("b");
        per1.setAge(14);;
        System.out.println(person.getName()+" "+person.getAge());
        System.out.println(per1.getName()+" "+per1.getAge());
        
    }
}

class Person implements Cloneable{
    private String name;
    private Integer age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException  {
        /*Person p=null;
        try{
            p=(Person) super.clone();
        }catch (CloneNotSupportedException e) {
        }*/
        return super.clone();
    }
}

