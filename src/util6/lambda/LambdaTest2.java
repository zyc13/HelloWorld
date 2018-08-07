package util6.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class LambdaTest2 {
    public static void main(String[] args) {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };

        System.out.println("所有程序员的名字：");
        javaProgrammers.forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        phpProgrammers.forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();

        System.out.println("给程序员加薪 5% :");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);
        System.out.println();

        System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
        phpProgrammers.stream()
                .filter(p -> p.getSalary() > 1400)
                .forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();

        // 定义 filters
        Predicate<Person> ageFilter = p -> p.getAge() > 25;
        Predicate<Person> salarFilter = p -> p.getSalary() > 1400;
        Predicate<Person> genderFilter = p -> "female".equals(p.getGender());

        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salarFilter)
                .filter(genderFilter)
                .forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();

        System.out.println("年龄大于 24岁的女性 Java programmers:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();

        System.out.println("最前面的3个 Java programmers:");
        javaProgrammers.stream()
                .limit(3)
                .forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();

        System.out.println("最前面的3个女性 Java programmers:");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();

        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .limit(5)
                .collect(toList());
        sortedJavaProgrammers.forEach(p -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        System.out.println("根据 salary 排序 Java programmers:");
        sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .collect(toList());
        sortedJavaProgrammers.forEach(p -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        System.out.println("工资最低的 Java programmer:");
        Person pers = javaProgrammers
                .stream()
                .min(Comparator.comparingInt(Person::getSalary))
                .get();
        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());
        System.out.println();

        System.out.println("工资最高的 Java programmer:");
        Person person = javaProgrammers
                .stream()
                .max(Comparator.comparingInt(Person::getSalary))
                .get();
        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());
        System.out.println();

        System.out.println("将 PHP programmers 的 first name 拼接成字符串:");
        String phpDevelopers = phpProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(joining("; "));
        System.out.println(phpDevelopers);

        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        Set<String> javaDevFirstName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(toSet());
        System.out.println(javaDevFirstName);

        System.out.println("将 Java programmers 的 last name 存放到 TreeSet:");
        TreeSet<String> javaDevLastName = javaProgrammers
                .stream()
                .map(Person::getLastName)
                .collect(toCollection(TreeSet::new));
        System.out.println(javaDevLastName);

        System.out.println("计算付给 Java programmers 的所有money:");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(Person::getSalary)
                .sum();
        System.out.println(totalSalary);

        // 计算 count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }
}

class Person {
    private String firstName, lastName, job, gender;
    private int salary, age;

    public Person(String firstName, String lastName, String job, String gender, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
