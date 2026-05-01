/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author poema
 */
public class ResourceNotFoundException extends RuntimeException{

    /**
     * Creates a new instance of <code>ResourceNotFoundException</code> without
     * detail message.
     */
    public ResourceNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ResourceNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
