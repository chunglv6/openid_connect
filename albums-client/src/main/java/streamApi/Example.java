package streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
//        List<Vehicle> list = new ArrayList<>();
//        list.add(new Vehicle("Mercedes-benz",Type.CAR,5));
//        list.add(new Vehicle("Outlander",Type.CAR,6));
//        list.add(new Vehicle("Foranger",Type.TRUCK,7));
//        list.add(new Vehicle("Raptor",Type.TRUCK,8));
//        list.add(new Vehicle("Limosine",Type.VAN,9));
////        Map<Type, List<Vehicle>> collect = list.stream().collect(Collectors.groupingBy(Vehicle::getType));
////        collect.entrySet().forEach(System.out::println);
//        list.stream().filter(v ->{
//            System.out.println(v.getName());
//            return Type.TRUCK.equals(v.getType());
//        })
//                .limit(1).forEach(System.out::println);
//        List<Integer> nums1 = Arrays.asList(1, 2, 3);
//        nums1.stream()
//                .mapToInt(i -> Integer.valueOf(i))
//                .max().ifPresent(System.out::println);

        System.out.println(sum(4));

    }
    private static int sum(int n){
        if(n<=0)
            return 0;
        else {
            return n + sum(n-1);
        }
    }

    private static long sum(long n){
        return LongStream.rangeClosed(1,n).reduce(0L,Long::sum);
    }

    private static long sumParallel(long n){
        return LongStream.rangeClosed(1,n).parallel().reduce(0L,Long::sum);
    }
}
