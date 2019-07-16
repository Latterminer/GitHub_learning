package com.wy.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2019-07-10
 * @description
 */
public class Name {
    private String first, last;

    public Name(String first, String last) {
        if (first == null || last == null) {
            throw new NullPointerException();
        }
        this.first = first;
        this.last = last;
    }

    public boolean equals(Name o) {
        return first.equals(o.first) && last.equals(o.last);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Name) {
            return first.equals(((Name) obj).first) && last.equals(((Name) obj).last);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
//        Set s = new HashSet();
//        s.add(new Name("Mickey", "Mouse"));
//        System.out.println(s.contains(new Name("Mickey", "Mouse")));

        String A = "df,dfd,,df,";
        System.out.println(A.split(",").length);
    }
}
