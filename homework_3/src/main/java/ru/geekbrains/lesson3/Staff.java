package ru.geekbrains.lesson3;

import java.util.*;

import static ru.geekbrains.lesson3.Employee.randomChoice;

public class Staff implements Iterable<Employee>{

//region Fields
    protected List<Employee> list;
    protected int count;
//endregion

    public Staff (int count)
    {
        this.count = count;
        this.list = new ArrayList<>();
        for (int i = 0; i < count; i++){
            if (randomChoice())
                this.list.add(Freelancer.getInstance());
            else
                this.list.add(Worker.getInstance());
        }
    }
//region Iterator
    @Override
    public Iterator<Employee> iterator() {
        return new StaffIterator();
    }

    class StaffIterator implements Iterator<Employee>{
        int count = 0;
        @Override
        public boolean hasNext() {
            return (count< list.size());
        }

        @Override
        public Employee next() {
            if (!hasNext())
                throw new NoSuchElementException();
            else
                return list.get(count++);
        }
    }
//endregion
}
