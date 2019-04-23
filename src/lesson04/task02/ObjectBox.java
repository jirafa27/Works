package lesson04.task02;

import java.util.LinkedHashSet;
import java.util.Set;

public class ObjectBox {
    public Set<Object> set = new LinkedHashSet<>();

    public void addObject(Object o)
    {
        set.add(o);
    }
    public void deleteObject(Object o)
    {
        set.remove(o);
    }
    public String dump()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object number: set)
        {
            stringBuilder.append(number.toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
