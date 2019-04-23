package lesson04.task01;

import lesson04.task02.ObjectBox;

import java.util.*;

public class MathBox extends ObjectBox {
    @Override
    public void addObject(Object o) {
        try {
            super.addObject((Number) o);
        }
        catch (ClassCastException e)
        {
            System.out.println("ClassCast exception in addObject MathBox");
        }
    }

    @Override
    public void deleteObject(Object o) {
        super.deleteObject(o);
    }

    public static void main(String[] args)
    {
        Number[] arr = new Number[]{1, 2, 3.5, 4};
        MathBox mathBox = new MathBox(arr);
        mathBox.addObject(new Object());
        System.out.println(mathBox);
        mathBox.delete(1);
        System.out.println(mathBox);
        System.out.println(mathBox.summator());
        mathBox.splitter(2);
        System.out.println(mathBox);

    }

    public MathBox(Number[] arr)
    {
        set = new LinkedHashSet<>();
        set.addAll(Arrays.asList(arr));
    }
    public Number summator()
    {

        Number sum = 0;
        for (Object number : set) {
            try
            {
                sum = sum.doubleValue() + ((Number) number).doubleValue();
            }
            catch (ClassCastException e)
            {
                System.out.println("ClassCastException in summator");
            }
        }

        return sum;
    }
    public void splitter(Number value)
    {
        Set<Object> newSet = new HashSet<>();
        for (Object number: set)
        {
            try {
                newSet.add(((Number) number).doubleValue() / value.doubleValue());
            } catch(ClassCastException e)
            {
                System.out.println("ClassCast exception in splitter");
            }
        }
        set = newSet;
    }

    @Override
    public String toString() {
        return super.dump();
    }

    @Override
    public boolean equals(Object obj) {
        Set<Object> s = (Set<Object>) obj;
        return (s.containsAll(set) && set.containsAll(s));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Object o: set)
        {
            hash+=o.hashCode();
        }
        return hash;
    }

    public void delete(Integer number)
    {
        super.deleteObject(number);
    }
}
