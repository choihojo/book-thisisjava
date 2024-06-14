package ch15.sec03;

import ch13.sec01.Box;

public class Member {

    public Box<Integer> box;
    public String name;
    public int age;
    public Integer test;

    public Member(Box<Integer> box, String name, int age, Integer test) {
        this.box = box;
        this.name = name;
        this.age = age;
        this.test = test;
    }

    @Override
    public int hashCode() { // String의 hashCode는 문자열 내용에 기반하므로 주의 (new String("최호조"), new String("최호조") 이렇게 하더라도 둘의 hashCode는 동일함)
//        System.out.println(this.name.hashCode());
//        return this.name.hashCode() + this.age;
        System.out.println(this.box.hashCode());
        return this.box.hashCode() + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member target) {
//            return target.name.equals(this.name) && (target.age == this.age);
//            return target.test == this.test && target.age == this.age;
            return target.box == this.box && target.age == this.age;
        }
        return false;
    }

}
