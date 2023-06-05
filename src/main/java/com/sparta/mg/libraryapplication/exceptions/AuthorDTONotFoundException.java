package com.sparta.mg.libraryapplication.exceptions;

public class AuthorDTONotFoundException extends Exception{
    public AuthorDTONotFoundException(String name) {
        super("Could not find Author with name: " + name);
    }
}