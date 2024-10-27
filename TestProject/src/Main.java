import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("Alice", 25, "USA"));
        users.add(new User("Bob", 30, "USA"));
        users.add(new User("Charlie", 42, "France"));
        users.add(new User("David", 18, "Germany"));
        users.add(new User("Emily", 55, "UK"));
        users.add(new User("Fiona", 22, "Australia"));
        users.add(new User("George", 38, "Japan"));
        users.add(new User("Helen", 19, "China"));
        users.add(new User("Isaac", 61, "India"));
        users.add(new User("Jasmine", 27, "India"));

        List<User> userUSA = users.stream()
                .filter(user->user.getCountry()=="USA")
                .collect(Collectors.toList());
        List<User> sortedUsers = users.stream()
                        .sorted((user1,user2)->{
                        return Integer.compare(user2.getAge(), user1.getAge());
                        })

                .collect(Collectors.toList());
        Map<String,Integer> usersByCountry = countryByUser(users);


        System.out.println(usersByCountry.toString());





    }
    public static Map<String,Integer> countryByUser(List<User> userList){
        Map<String,Integer> countryUserMap= new HashMap<>();
        String key;
        for(int i=0;i<userList.size();i++){
            key= userList.get(i).getCountry();
            if(countryUserMap.get(key)!=null)
            {
                countryUserMap.put(key, countryUserMap.get(key)+1);
            }
            else{
                countryUserMap.put(key,1);
            }
        }
        return countryUserMap;
    }
}
