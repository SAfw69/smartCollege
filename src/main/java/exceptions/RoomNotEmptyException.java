package exceptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */

/**
 *
 * @author poema
 */
public class RoomNotEmptyException extends RuntimeException {

    /**
     * Creates a new instance of <code>RoomNotEmptyException</code> without
     * detail message.
     */
    public RoomNotEmptyException() {
    }

    /**
     * Constructs an instance of <code>RoomNotEmptyException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RoomNotEmptyException(String msg) {
        super("ERROR 409: Conflict. "+msg);
    }
}
