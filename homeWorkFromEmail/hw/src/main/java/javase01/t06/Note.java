package javase01.t06;

/**
 * Created by msid on 13.02.17.
 */
public class Note {
    private String data;

    public Note(String data){
        this.data=data;
    }

    public String getData(){
        return data;
    }

    public void edit(String newData){
        data=newData;
    }

    public void show(){
        System.out.println(data);
    }
}
