package javase01.t06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by msid on 13.02.17.
 */
public class NoteBook {
    Note[] data = new Note[0];


    public void add(Note note){
        Note[] newData = new Note[data.length+1];
        System.arraycopy(data,0, newData, 0, data.length);
        newData[newData.length-1] = note;
        data = newData;
    }

    public void edit(int nodeNumber){
        Scanner scanner = new Scanner(System.in);
        System.out.println("now note text is: " + data[nodeNumber].getData());
        System.out.println("enter new text: ");
        edit(nodeNumber,scanner.nextLine());
    }

    public void edit(int nodeNumber, String newText){
        data[nodeNumber].edit(newText);
    }

    public void remove(int nodeNumber){
        if(nodeNumber<data.length-1) {
            Note[] newData = new Note[data.length - 1];
            System.arraycopy(data, 0, newData, 0, nodeNumber);
            System.arraycopy(data, nodeNumber+1, newData, nodeNumber, data.length-nodeNumber-1);
            data = newData;
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void showAllNotes(){
        for(Note n:data){
            n.show();
        }
    }
}
