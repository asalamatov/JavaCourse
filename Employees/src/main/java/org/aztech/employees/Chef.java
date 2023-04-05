package org.aztech.employees;

public interface Chef {

    String favoriteFood = "broccoli";
    default void cook(String food){
        System.out.println("I am now cooking " + food);
    }

    default String cleanUp(){
        return "I am done cleaning up";
    }

//    String yellAtPeople();

    default String getFavoriteFood(){
        return favoriteFood;
    }

}
