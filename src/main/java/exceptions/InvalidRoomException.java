/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author poema
 */
public class InvalidRoomException extends RuntimeException{

    /**
     * Creates a new instance of <code>InvalidRoomException</code> without
     * detail message.
     */
    public InvalidRoomException() {
    }

    /**
     * Constructs an instance of <code>InvalidRoomException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidRoomException(String msg) {
        super(msg);
    }
}
