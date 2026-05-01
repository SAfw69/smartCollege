/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author poema
 */
public class FallbackException extends RuntimeException{

    /**
     * Creates a new instance of <code>FallbackException</code> without detail
     * message.
     */
    public FallbackException() {
    }

    /**
     * Constructs an instance of <code>FallbackException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FallbackException(String msg) {
        super("ERROR 500: Fallback. "+msg);
    }
}
