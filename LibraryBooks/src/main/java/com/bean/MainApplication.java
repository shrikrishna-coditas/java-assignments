package com.bean;

import com.dao.LibraryDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch;
        String bname,publisher;
        List<Books> books=new ArrayList<>();
        do{
            System.out.println("1.Insert\n2.Update\n3.Delete\n4.Fetch\n5.Exit\n");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(br.readLine());

            switch (ch){
                case 1:
                    Library library=new Library();
                    System.out.println("Enter library id and name");
                    int id=Integer.parseInt(br.readLine());
                    String name=br.readLine();
                    System.out.println("How many books you want to add?");
                    int n=Integer.parseInt(br.readLine());
                    for(int i=0;i<n;i++){
                        System.out.println("Enter book name");
                        bname=br.readLine();
                        System.out.println("Enter publisher name");
                        publisher=br.readLine();
                        Books book=new Books();
                        book.setName(bname);
                        book.setPublisher(publisher);
                        books.add(book);
                    }
                    library.setId(id);
                    library.setName(name);
                    library.setBooksList(books);
                    LibraryDao.insertLibrary(library);
                    break;

                case 2:
                    System.out.println("Enter library id");
                    id=Integer.parseInt(br.readLine());
                    System.out.println("Enter new library name");
                    name=br.readLine();
                    LibraryDao.updateLibrary(name,id);
                    break;

                case 3:
                    System.out.println("Delete library name");
                    name= br.readLine();
                    LibraryDao.deleteLibrary(name);
                    break;

                case 4:
                    List<Library> libraries=LibraryDao.fetchLibrary();
                    for(Library library1:libraries){
                        System.out.println(library1);
                    }
                    break;

                case 5:System.exit(0);
            }

        }while (true);
    }
}
