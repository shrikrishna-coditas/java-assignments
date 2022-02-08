package session15CE;

public class InvalidAgeException extends Exception {
    InvalidAgeException(){
        System.out.println("Default Constructor==>InvalidAgeException");
    }

    InvalidAgeException(String msg){
        System.out.println("Parameter String:: Constructor==>"+msg);
    }

    InvalidAgeException(Throwable cause){
        System.out.println("Parameter  Throwable:: Constructor==>"+cause);
    }

    InvalidAgeException(String msg,Throwable cause){
        System.out.println("Parameters String,Throwable:: Constructor==>InvalidAgeException");
    }

    public String getMessage(){
        return  "Message: Please enter age >= 18";
    }

}
