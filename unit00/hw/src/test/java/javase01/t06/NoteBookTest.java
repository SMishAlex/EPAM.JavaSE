package javase01.t06;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 14.02.17.
 */
public class NoteBookTest {
    @Test
    public void add() throws Exception {
        NoteBook noteBook = new NoteBook();
        int n=10;
        for(int i=0; i<n; i++){
            noteBook.add(new Note(""+i));
        }
        for(int i=0; i<n; i++){
            assertEquals((""+i), noteBook.data[i].getData());
        }
    }

    @Test
    public void edit() throws Exception {
        NoteBook noteBook = new NoteBook();
        noteBook.add(new Note("befor"));
        noteBook.edit(0,"after");
        assertEquals("after", noteBook.data[0].getData());
    }

    @Test
    public void remove() throws Exception {
        NoteBook noteBook = new NoteBook();
        int n=10;
        for(int i=0; i<n; i++){
            noteBook.add(new Note(""+i));
        }
        noteBook.remove(5);
        for(int i=0; i<n-1; i++){
            if(i<5) {
                assertEquals(("" + i), noteBook.data[i].getData());
            }
            else {
                assertEquals(("" + (i+1)), noteBook.data[i].getData());
            }
        }
    }

    @Test
    public void showAllNotes() throws Exception {
        NoteBook noteBook = new NoteBook();
        noteBook.add(new Note("some text 2"));
        noteBook.add(new Note("some text 1"));
        noteBook.add(new Note("some text 3"));
        noteBook.showAllNotes();
    }

    @Test
    public void test(){
        Note note = new Note("");
        Note[] data = new Note[10];
        Note[] newData = new Note[data.length+1];
        System.arraycopy(data,0, newData, 0, data.length);
        newData[newData.length-1] = note;
    }

}