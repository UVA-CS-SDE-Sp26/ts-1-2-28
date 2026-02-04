TopSecret documentation starter file

From Command Line, take in either nothing, a (small) number, or a (small) number and a .txt file

If nothing: print a list of file names (with their access-code numbers), from an internal (private)
    list of files, into the terminal

If just a number: validate the number and display the (decrypted) contents of the associated .txt
    file in the same terminal window

If a number and a .txt file: validate the number, validate the .txt file, and display the
    (decrypted using the key in the .txt file) contents of the associated .txt file in the same
    terminal window

As I understand it:
Student A writes a class (possibly the main function) that calls Student C's class, which calls
    Student B's class, which calls Student D's class. Student D's class returns a data type that
    Student B's class uses and returns to Student C's class, which returns to Student A's class,
    which prints the result
    A->C->B->D and back.