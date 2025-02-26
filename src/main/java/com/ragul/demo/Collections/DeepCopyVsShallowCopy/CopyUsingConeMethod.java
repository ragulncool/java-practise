package com.ragul.demo.Collections.DeepCopyVsShallowCopy;


import lombok.Getter;
import lombok.Setter;

//copy - applicable only for members of class and not class itself or primitives

//Shallow copy - copies reference of members of org. changes in anyone affects both
//Deep copy - replica. hence members of org and copy are independent
//obj and primitives will be of different location it is xerox in both copy

//If the class has only primitive data type members then a completely new copy of the object will be created and the reference to the new object copy will be returned.
//If the class contains members of any class type then only the object references to those members are copied and hence the member references in both the original object as well as the cloned object refer to the same object.

//clone method is used for both

//* Class must implement Clonaebale
//* clone method should be overridden. Call super.clone() for shallow and custo clone for deep
class Emp3 implements Cloneable{
    public int id;
    public String name;
    public Address address;

    public Emp3(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address= address;
    }

    @Override
    public String toString(){
        return "["+this.id+" "+this.name+" "+this.address+" "+Integer.toHexString(hashCode())+"]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //System.out.println("====SHALLOW COPY===");
        return super.clone();

//        System.out.println("====DEEP COPY===");
//        Emp3 cloned = (Emp3)super.clone();
//        cloned.address = (Address) this.address.clone(); //we can comment this line for changing deep to shallow
//        return cloned;
    }
}

class Address implements Cloneable{
    public String street;
    public String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString(){
        return "["+this.street+" "+this.city+" "+ Integer.toHexString(hashCode())+"]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

    public class CopyUsingConeMethod {
        public static void main(String[] args) throws CloneNotSupportedException {
            Emp3 emp1 = new Emp3(1,"one", new Address("street1","coimbatore"));
            Emp3 emp2 = (Emp3)emp1.clone(); //in any copy, it has diff memory location as emp1
            emp1.address.city="Chennai"; //or setting in emp1
            System.out.println(emp1);
            System.out.println(emp2);

            Emp3 emp3 = emp1;//in any copy, it is same memory location as emp1
            System.out.println(emp3);

        }
    }
