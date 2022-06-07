package day5assignment;

import java.util.Arrays;

class Sort{
    public String[] sortStrings(String[] values){
        for (int i=1 ;i< values.length; i++)
        {
            String temp = values[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < values[j].length())
            {
                values[j+1] = values[j];
                j--;
            }
            values[j+1] = temp;
        }
        return values;
    }
}
class Count{
    public void countVowCons(String str){
        System.out.println("String: "+str);
        int countVow=0,countCons=0;
        str=str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                countVow++;
            }
            else if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                countCons++;
            }
        }
        System.out.println("Vowels:"+countVow+" Consonants:"+countCons);
    }
}
class Remove{
    public void removeRepeated(String s){
        char str[]=s.toCharArray();
        System.out.println("Original String: "+s);
        int n=str.length,index=0;
        for (int i = 0; i < n; i++)
        {
            int j;
            for (j = 0; j < i; j++)
            {
                if (str[i] == str[j])
                {
                    break;
                }
            }
            if (j == i)
            {
                str[index++] = str[i];
            }
        }
        System.out.println("Removed Duplicates: "+String.valueOf(Arrays.copyOf(str,index)));
    }
    public void removeSpacing(String str){
        System.out.println("Original string: "+str);
        str=str.trim();
        System.out.println("Trimmed string: "+str);
        System.out.println("Unicode of 5th character is : "+(int)str.charAt(5));
    }
}
class Replace{
    public void replaceChar(String[] values){
        Sort s=new Sort();
        values=s.sortStrings(values);
        System.out.println(Arrays.toString(values));
        for(String str:values){
            char[] s1=str.toCharArray();
            for(int i=0;i<s1.length;i++){
                if(s1[i]=='a'||s1[i]=='e'||s1[i]=='i'||s1[i]=='o'||s1[i]=='u'||s1[i]=='A'||s1[i]=='E'||s1[i]=='I'||s1[i]=='O'||s1[i]=='U'){
                    s1[i]++;
                }
            }
            System.out.print(String.valueOf(Arrays.copyOf(s1,s1.length))+" ");
        }

    }
}

public class StringClass {
    public static void main(String args[]) {
        String[] values = {"Krishna", "Sharad", "Huilgol", "Ram", "Laxman"};
        Replace rp = new Replace();
        rp.replaceChar(values);


        //Remove r = new Remove();
        //r.removeSpacing("  Coditas  ");

        //Count c = new Count();
        //c.countVowCons("Krishna77");




      /*  String[] values={"Hello","Krishna","How","your","work","in","Coditas","is","going"};
        System.out.println("Original String array: "+Arrays.toString(values));
        Sort s=new Sort();
        String[] ans=s.sortStrings(values);
        System.out.println("Sorted String array: "+Arrays.toString(ans));*/

       // s.sortStrings(values);
        /*count c=new count();
        c.countVowCons("Krishna");
        remove r=new remove();
        r.removeRepeated("krkisahnaa");
        String str=" spacing ";
        remove r=new remove();
        r.removeSpacing(str);
        replace rp=new replace();
        rp.replaceChar(values);*/


    }
}
