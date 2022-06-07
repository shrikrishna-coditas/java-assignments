package day3assignment;
class Week{
    public void display(String[] weeks){
        System.out.println("All weeks:");
        for(String week:weeks){
            System.out.println(week);
        }
    }
    public void displaySkip(String[] weeks){
        System.out.println("Skipped today's day:");
        for(String week:weeks){
            if(week.equals("Thursday"))
                continue;
            System.out.println(week);
        }
    }
}
class Day{
    public void display(){
        System.out.println("Skipped today's date:");
        for(int i=0;i<=31;i++){
            System.out.println(i+" jan 2022");
            if(i==20)
                break;
        }
    }
}





public class DisplayWeek {
    public static void main(String[] args){
        String[] weeks={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        Week wk=new Week();
        wk.display(weeks);
        System.out.println();
        wk.displaySkip(weeks);
        System.out.println();

        Day d=new Day();
        d.display();

    }
}
