public class UserSingletonDemo {

    private static UserSingletonDemo userSingletonDemo;

    private UserSingletonDemo(){
    }
    public static UserSingletonDemo getInstance(){
        if(userSingletonDemo != null){
            return userSingletonDemo;
        }
        else{
            synchronized () {
                UserSingletonDemo userSingletonDemo = new UserSingletonDemo();
                return userSingletonDemo;
            }
        }

    }
}
