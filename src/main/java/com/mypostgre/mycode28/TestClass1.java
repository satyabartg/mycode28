package com.mypostgre.mycode28;


public class TestClass1 {

    public static void main(String[] args) {

        //
//        List<Integer> numbers = Arrays.asList(10, 12, 13, 15, 15, 16, 18, 49, 23);
//       Predicate<Integer> val= x->x%2==0;
//        boolean test = val.test(14);
//
//        System.out.println(test);

        //equals for
//        System.out.println("---------------------------------------");
//        Predicate<String>val1=str->str.equals("mike");
//        boolean result = val1.test("stalin");
//        System.out.println(result);

        //= for even number
//        List<Integer> number = Arrays.asList(10, 14, 14, 16, 17, 19, 33, 3, 5);
//        List<Integer> evenNumbers = number.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenNumbers);
//
//        System.out.println("_______________________________");


        //!= oddnumber
//        List<Integer> number = Arrays.asList(10, 14, 14, 16, 17, 19, 33, 3, 5);
//        List<Integer> evenNumbers = number.stream().filter(s -> s % 2 != 0).collect(Collectors.toList());
//        System.out.println(evenNumbers);
        // System.out.println("---------------------------");


//        List<String> name = Arrays.asList("akash", "abhi","amit", "asutas","sipun", "sibu", "pinku", "pinky", "raju", "raka","raka");
//        List<String> data1 = name.stream().filter(m -> m.startsWith("a")).collect(Collectors.toList());
//        List<String> data2 = name.stream().filter(a -> a.endsWith("u")).collect(Collectors.toList());
//        List<String> data3= name.stream().filter(s -> s.equals("raka")).collect(Collectors.toList());
//
//        System.out.println(data1);
//        System.out.println(data2);
//        System.out.println(data3);


        //Function functional interface
//        List<String> number = Arrays.asList("mike", "mika", "riya", "ramiya");
//        Function<String,Integer> result= sm->sm.length();
//        Integer val = result.apply("ramiya");
//        System.out.println(val);


//        List<String> number = Arrays.asList("mike", "mika", "riya", "ramiya");
//        Function<Integer,Integer> result= i->i+10;
//        Integer a = result.apply(10);
//        System.out.println(a);


//        List<Integer> data = Arrays.asList(10, 6, 3, 4, 2, 5, 1);
//        List<Integer> newnNumber = data.stream().map(i -> i + 100).collect(Collectors.toList());
//        System.out.println(newNumber);


//        List<String> data = Arrays.asList("akash","badal","sagar","sriya","alisha");
//        List<String> upper = data.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
//        System.out.println(upper);


//        List<String> data = Arrays.asList("akash","badal","sagar","sriya","alisha");
//        List<String> newdata = data.stream().sorted().collect(Collectors.toList());
//
//        System.out.println(newdata);


//        List<Integer> data = Arrays.asList(12,3,15,17,19,8);
//        List<Integer> upper = data.stream().sorted().collect(Collectors.toList());
//        System.out.println(upper);


//        List<Integer> data = Arrays.asList(12,3,15,17,19,8,65,8,15,17,89);
//        List<Integer> upper = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(upper);


//        List<String> words = Arrays.asList("hello", "world");
//        List<Character> cha = words.stream()
//                .flatMap(str -> str.chars().mapToObj(c -> (char) c)).collect(Collectors.toList());
//
//        System.out.println(cha);

//        List<List<String>> listOfLists = Arrays.asList(
//                Arrays.asList("apple", "orange"),
//                Arrays.asList("cat", "dog", "bird"),
//                Arrays.asList("java", "python", "javascript")
//        );
//        List<String> list = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
//
//        System.out.println(list);


//        Consumer<Integer> result= number-> System.out.println(number);
//                result.accept(10);


        //        ForEach
//        List<String>names=Arrays.asList("mantu","adi","sanu");
//         Consumer<String>val =name-> System.out.println(name);
//         names.forEach(val);


//        Supplier<Integer>val= ()->new Random().nextInt(10);
//        Integer i = val.get();
//        System.out.println(i);


//        List<Login>val=Arrays.asList(
//                new Login("manu","akash"),
//                new Login("sonu","akash"),
//                new Login("janu","akash")
//        );
//
//        List<LoginDto> dtos = val.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
//        System.out.println(dtos);
//    }
//
//   static LoginDto mapToDto(Login login){
//        LoginDto dto=new LoginDto();
//        dto.setUserName(login.getUserName());
//        dto.setPassword(login.getPassword());
//        return dto;
//
//    }




        }



}
