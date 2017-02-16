package javase01.t06;

import java.util.Arrays;
import java.util.Scanner;

/** Simple container for Note.
 *
 *
 */
public class NoteBook {
    Note[] data = new Note[0];


    /**
     * Add Note to end of NoteBook.
     *
     * @param note
     */
    public void add(Note note){
        Note[] newData = new Note[data.length+1];
        System.arraycopy(data,0, newData, 0, data.length);
        newData[newData.length-1] = note;
        data = newData;
    }

    /**
     * Edit note in noteBook by note index.
     *
     * @param nodeNumber note index (starts with 0)
     */
    public void edit(int nodeNumber){
        Scanner scanner = new Scanner(System.in);
        System.out.println("now note text is: " + data[nodeNumber].getData());
        System.out.println("enter new text: ");
        edit(nodeNumber,scanner.nextLine());
    }

    /**
     * Put some string data into note by index.
     *
     * @param nodeNumber note index (starts with 0)
     * @param newText new note data
     */
    public void edit(int nodeNumber, String newText){
        data[nodeNumber].edit(newText);
    }

    /**
     * Remove note by index.
     *
     * Remove note by index. Move all data array after removed element at one position left.
     * @param nodeNumber note index (starts with 0)
     */
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
