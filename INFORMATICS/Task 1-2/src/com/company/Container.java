package com.company;

public class Container<Type1, Type2> {

    private final Type1 obj1;
    private final Type2 obj2;

    Container(Type1 obj1, Type2 obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    private Type1 getValueObject1() {
        return obj1;
    }

    private Type2 getValueObject2() {
        return obj2;
    }
}
